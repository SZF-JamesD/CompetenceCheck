use vet_clinic;

insert into Pet_Owners (first_name, last_name, address, phone_number, email) values
	('Jim', 'Jimson', '12 Jim st.', '0123123123', 'jim@jimmail.com'),
    ('Bob', 'Bobson', '1 Bob st.', '0123123111', 'bob@bobmail.com'),
    ('Billy', 'Billyson', '15 Billyson Av.', '01231112223', 'billy@billymail.com'),
    ('Sally', 'McSallyson', '69 Sally Way', '012322233123', 'sally@sallymail.com'),
    ('Laura', 'McLauraFace', '123 Laura St.', '01111111234', 'laura@lauramail.com');
    
insert into Pets (pet_name, pet_type, breed, date_of_birth, gender, chip_no, owner_id) values
	('Good Monson', 'Cat', 'British Shorthair', '2020-11-11', 'M', '123456789012345', 1),
    ('Pet2', 'Cat', 'Maine Coon', '2024-12-12', 'F', '222222222222222', 1),
    ('Pet3', 'Dog', 'Dalmation', '2018-05-05', 'M', '333333333333333', 1),
    ('Pet4', 'Dog', 'Mix', '2021-05-07', 'M', '444', 2),
    ('Pet5', 'Horse', 'Mustang', '2017-02-07', 'M', '555', 2),
    ('Pet6', 'Dog', 'Labrador Retriever', '2014-12-17', 'M', '666', 3),
    ('Pet7', 'Cat', 'Abyssinian', '2020-05-23', 'F', '777', 4),
    ('Pet8', 'Cat', 'Birman', '2019-06-09', 'M', '888', 4),
    ('Pet9', 'Cat', 'Sphynx Cat', '2023-05-07', 'M', '999', 4),
    ('Pet10', 'Snake', 'Ball Python', '2020-11-15', 'M', '101010', 5);
    
insert into Vets (vet_name, specialization, phone_no, email, license_no) values
	('ReptilevetPerson', 'Reptiles', '011123232333', 'reptilevetperson@gmail.com', 'R14'),
    ('HorsevetPerson', 'Equine', '2223434345643', 'horsevet@gmail.com', 'E123'),
    ('dogandcatperson', 'Canine and Feline', '54345345345', 'dogsandcatsvet@gmail.com', 'CF123'),
    ('surgeonperson', 'Small animal surgery', '12343987654', 'smallanimalsurgeon@gmail.com', 'SAS12345');
    
insert into Treatments (treatment_date, diagnosis, treatment, cost, pet_id, vet_id) values
	('2021-12-12', 'diagnosis 1', 'treament 1', 100.12, 1, 3),
    ('2023-11-16', 'diagnosis 2', 'treament 2', 150.15, 1, 3),
    ('2025-05-04', 'diagnosis 3', 'treament 3', 6500.56, 1, 4),
    ('2024-07-06', 'diagnosis 4', 'treament 4', 654.88, 2, 4),
    ('2018-06-05', 'diagnosis 5', 'treament 5', 45.12, 3, 3),
    ('2019-12-07', 'diagnosis 6', 'treament 6', 250.12, 3, 4),
    ('2025-04-28', 'diagnosis 7', 'treament 7', 1234.12, 4, 4),
    ('2024-12-12', 'diagnosis 8', 'treament 8', 3243.12, 7, 4),
    ('2023-12-12', 'diagnosis 9', 'treament 9', 250.12, 9, 4),
    ('2017-08-23', 'diagnosis 10', 'treament 10', 400.12, 5, 2),
    ('2018-08-23', 'diagnosis 11', 'treament 11', 400.12, 5, 2),
    ('2019-08-23', 'diagnosis 12', 'treament 12', 400.12, 5, 2),
    ('2020-08-23', 'diagnosis 13', 'treament 13', 400.12, 5, 2),
    ('2021-08-23', 'diagnosis 14', 'treament 14', 400.12, 5, 2),
    ('2022-08-23', 'diagnosis 15', 'treament 15', 400.12, 5, 2),
    ('2023-12-12', 'diagnosis 16', 'treament 16', 410.12, 5, 2),
    ('2024-12-12', 'diagnosis 17', 'treament 17', 450.12, 5, 2),
    ('2021-12-12', 'diagnosis 18', 'treament 18', 1544.12, 10, 1),
    ('2023-05-14', 'diagnosis 19', 'treament 19', 2000.15, 10, 1),
    ('2025-04-15', 'diagnosis 20', 'treament 20', 4321.12, 10, 1);
    
insert into Owners_and_Pets (owner_id, pet_id) values
	(1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (4, 9),
    (5, 10);
 
insert into Vets_Treatments_and_Pets (vet_id, treatment_id, pet_id) values
	(1, 18, 10),
    (1, 19, 10),
    (1, 20, 10),
    (2, 10, 5),
    (2, 11, 5),
    (2, 12, 5),
    (2, 13, 5),
    (2, 14, 5),
    (2, 15, 5),
    (2, 16, 5),
    (2, 17, 5),
    (3, 1, 1),
    (3, 2, 1),
    (3, 5, 3),
    (4, 3, 1),
    (4, 4, 2),
    (4, 6, 3),
    (4, 7, 4),
    (4, 8, 7),
    (4, 9, 9);