package com.apiback.vaccine.module.controllers;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apiback.vaccine.exceptions.EntityNotFoundException;
import com.apiback.vaccine.module.dto.EmployeeDTO;
import com.apiback.vaccine.module.dto.FilterheadersDTO;
import com.apiback.vaccine.module.entity.Employee;
import com.apiback.vaccine.module.entity.Genstatus;
import com.apiback.vaccine.module.entity.TypeVaccine;
import com.apiback.vaccine.module.service.IEmployee;
import com.apiback.vaccine.module.service.IGenstatus;
import com.apiback.vaccine.module.service.IRole;
import com.apiback.vaccine.module.service.ITypevaccine;
import com.apiback.vaccine.security.entity.Role;
import com.apiback.vaccine.security.entity.Users;
import com.apiback.vaccine.utils.DataConfig;

@RestController
@RequestMapping("/api-vaccine/employees")
public class EmployeeController {
	
	
	@Autowired
	private IEmployee emplService;
	
	@Autowired
	private IRole roleService;
	
	@Autowired
	private IGenstatus statuService;
	
	@Autowired
	private ITypevaccine typevaccineService;
	
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> findAll() {
		List<EmployeeDTO> list = emplService.findAll().stream().map(p -> mapper.map(p, EmployeeDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody EmployeeDTO dto) throws Exception{
		
		Users userC = new Users();
    	Role rol = new Role();
    	rol = roleService.findById(DataConfig.id_rol_empl);
    	if(rol == null){
            throw new EntityNotFoundException("Role ID not found: " + DataConfig.id_rol_empl);
        }//end if
    	ArrayList<Role> list = new ArrayList<>();
    	list.add(rol);
    	
    	userC.setUsername(dto.getDni());
    	userC.setPassword(encoder.encode(dto.getDni()));
    	userC.setRole(list);
    	
        Employee obj = emplService.saveTransaccion(mapper.map(dto, Employee.class), userC, "I");
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

	@PreAuthorize("hasAuthority('EMPL')")
    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@Valid @RequestBody EmployeeDTO dto)  throws Exception{
		
		Employee employee = emplService.findById(dto.getId());
		if(employee == null) {
			throw new EntityNotFoundException("Employee ID not found: " + dto.getId());
		}//end if
		Employee obj = emplService.saveTransaccion(mapper.map(dto, Employee.class), null, "U");
		EmployeeDTO dtoR = mapper.map(obj, EmployeeDTO.class);
		
		return new ResponseEntity<>(dtoR, HttpStatus.OK);
       
    }

	@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        Employee obj = emplService.findById(id);

        if(obj == null){
        	throw new EntityNotFoundException("Employee ID not found: " + id);
        }//end if
        emplService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	/*
	 * Consultas que realiza el ADMIN
	 * 
	 * */
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/findemployeeByGenstatus")
	public ResponseEntity<List<EmployeeDTO>> findemployeeByGenstatus(@RequestBody FilterheadersDTO dto) throws Exception{
		
		Genstatus status = statuService.findById(dto.getId());
		if(status == null ) {
			throw new EntityNotFoundException("Satatus ID not found: " + dto.getId());
		}//end if
		
		List<EmployeeDTO> list =  emplService.findByGenstatus(status);
		return new ResponseEntity<List<EmployeeDTO>>(list, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/findemployeeByTypevaccine")
	public ResponseEntity<List<EmployeeDTO>> findemployeeByTypevaccine(@RequestBody FilterheadersDTO dto) throws Exception{
		
		TypeVaccine typevaccine = typevaccineService.findById(dto.getId());
		if(typevaccine == null ) {
			throw new EntityNotFoundException("TypeVaccine ID not found: " + dto.getId());
		}//end if
		
		List<EmployeeDTO> list =  emplService.findByTypeVaccine(typevaccine);
		return new ResponseEntity<List<EmployeeDTO>>(list, HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/findemployeeByBetweenDate")
	public ResponseEntity<List<EmployeeDTO>> findemployeeByBetweenDate( @RequestParam(value = "ini") String ini, 
																		@RequestParam(value = "end") String end ) throws Exception{
		
		List<EmployeeDTO> lstEmployee =  emplService.findByBetweenDate(LocalDateTime.parse(ini), LocalDateTime.parse(end));
		return new ResponseEntity<List<EmployeeDTO>>(lstEmployee, HttpStatus.OK);

	}


}
