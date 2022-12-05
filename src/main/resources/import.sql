INSERT INTO "public"."type_vaccine"("id", "name") VALUES (1, 'Sputnik');
INSERT INTO "public"."type_vaccine"("id", "name") VALUES (2, 'AstraZeneca');
INSERT INTO "public"."type_vaccine"("id", "name") VALUES (3, 'Pfizer');
INSERT INTO "public"."type_vaccine"("id", "name") VALUES (4, 'Jhonson&Jhonson');

INSERT INTO "public"."genstatus"("id", "name") VALUES (1, 'VACUNADO');
INSERT INTO "public"."genstatus"("id", "name") VALUES (2, 'NO VACUNADO');

INSERT INTO "public"."role"("id", "name") VALUES (1, 'ADMIN');
INSERT INTO "public"."role"("id", "name") VALUES (2, 'EMPL');

INSERT INTO "public"."users"("username", "password") VALUES ('admin', '$2a$12$ayFCd0zl8gA0zHjqmt2TkuZEqGTuxb7mTzak6f0jBzzGyZFsawUpm');
INSERT INTO "public"."user_role"("id_user", "id_role") VALUES (1, 1);

