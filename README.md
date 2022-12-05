<h1 align="center"> API BACKEND VACCINE - Krugger </h1>

## Descripcion
###### Esta API gestiona diferentes tipos de vacunas contra el COVID que un empleado tiene.

### Instalacion
##### Importar el proyecto y  actualizar las dependencias MAVEN.
##### Esta api fue desarrollada con la version 8 de Java y con la version de Srping boot 2.3.3.RELEASE.
##### En al archivo pom.xml se encuentran todas las dependencias que se usaron.

### Ejecucion
##### Para poder consumir los recursos primero debemos consumir el enpoint de autorizacion "http://localhost:8081/oauth/token" las credenciales para acceder a este recurso se encuentran en el archivo "apllication.properties".
##### security.jwt.client-id=pruebabackend
##### security.jwt.client-secret=pruebabackendjava
##### security.jwt.grant-type=password

### Pruebas
##### En la ruta resource se encuentra el archivo "import" el cual tiene todos los insert iniciales.
##### Para probar use el rol 'ADMIN' con el usuario 'admin' - contrasena '12345' (los 2 textos sin comillas)

### Modelo
##### En raiz del proyecto esta la carpeta 'MODELO-BD' ahi se encuentra el script y el modelo de la base de datos.


## Comentarios
##### Prueba tecnica dada por krugger y desarrollada por Angelo Bravo