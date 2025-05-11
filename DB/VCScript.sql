create database if not exists vet_clinic;
use vet_clinic;

create table if not exists Pet_Owners(
	owner_id int primary key auto_increment,
    first_name varchar(55) not null,
    last_name varchar(55) not null,
    address varchar(100) not null,
    phone_number varchar(20) not null,
    email varchar(55) not null
    );
    
create table if not exists Pets(
	pet_id int primary key auto_increment,
    pet_name varchar(55) not null,
    pet_type varchar(10) not null,
    breed varchar(30) not null,
    date_of_birth date not null,
    gender char not null check (gender IN ('M', 'F')),
    chip_no varchar(15),
    owner_id int not null,
    foreign key (owner_id)  references Pet_Owners(owner_id) 
    );

create table if not exists Vets(
	vet_id int primary key auto_increment,
    vet_name varchar(55) not null,
    specialization varchar(55) not null,
    phone_no varchar(20) not null,
    email varchar(55) not null,
    license_no varchar(55) not null
    );
    
create table if not exists Treatments(
	treatment_id int primary key auto_increment,
    treatment_date date not null,
    diagnosis varchar(255) not null,
    treatment varchar(255) not null,
    cost decimal(10,2) not null,
    pet_id int not null,
    vet_id int not null,
    foreign key (pet_id) references Pets(pet_id),
    foreign key (vet_id) references Vets(vet_id)
    );
    
create table if not exists Owners_and_Pets(
	owner_id int,
    pet_id int,
    foreign key (owner_id) references Pet_Owners(owner_id),
    foreign key (pet_id) references Pets(pet_id)
    );
    
create table if not exists Vets_Treatments_and_Pets(
	vet_id int,
    treatment_id int,
    pet_id int,
    foreign key (vet_id) references Vets(vet_id),
    foreign key (treatment_id) references Treatments(treatment_id),
    foreign key (pet_id) references Pets(pet_id)
    );
	

    