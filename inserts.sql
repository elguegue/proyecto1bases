
-- LICENCIAS DE IMAGEN
INSERT INTO LICENSE (name, expiry_date) VALUES ('CC', '2030-06-24);


-- PROPIETARIO DE IMAGEN
INSERT INTO IMAGE_OWNER (name) VALUES ('Wikipedia');

-- PAISES
INSERT INTO COUNTRY (name) VALUES ('United States of America');

-- CUENTAS
INSERT INTO ACCOUNT (ADDRESS, COUNTRY, EMAIL, FIRST_NAME, LAST_NAME) VALUES
('742 Evergreen Terrace, Springfield', 1, 'thomas.johnson@gmail.com', 'Thomas', 'Johnson'),
('1600 Penn Avenue, Washington', 1, 'amelia.fosh@gmail.com', 'Amelia', 'Fosh'),
('221B Elm Street, Riverdale', 1, 'trevor.wallace@gmail.com', 'Trevor', 'Wallace'),
('35 Oakwood Drive, Greenville', 1, 'ben10@gmail.com', 'Ben', 'Tennyson'); 

-- TAXONES
INSERT INTO TAXON (common_name, species_name, taxon_ancestor_id) VALUES
  -- Dominio
  ('Eukarya', NULL, NULL),

  -- Reino
  ('Animalia', NULL, 1),

  -- Phylum
  ('Chordata', NULL, 2),
  ('Arthropoda', NULL, 2),

  -- Clase
  ('Aves', NULL, 3),
  ('Mammalia', NULL, 3),
  ('Insecta', NULL, 4),

  -- Orden
  ('Apodiformes', NULL, 5),
  ('Primates', NULL, 6),
  ('Hymenoptera', NULL, 7),
  -- Familia
  ('Trochilidae', NULL, 8),
  ('Atelidae', NULL, 9),
  ('Formicidae', NULL, 10),

  -- Género
  ('Archilochus', NULL, 11),
  ('Alouatta', NULL, 12),
  ('Paraponera', NULL, 13),

  -- Especie
  ('Colibrí', 'Archilochus colubris', 14),
  ('Mono aullador','Alouatta palliata', 15),
  ('Hormiga bala', 'Paraponera clavata', 16);
