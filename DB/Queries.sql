use vet_clinic;

-- query 1 select all pets with name, type, and owner name
select 
	p.pet_name,
    p.pet_type,
    concat(o.first_name, ' ', o.last_name) as owner_name
    from Owners_and_Pets op
    join
    Pet_Owners o on op.owner_id = o.owner_id
    join 
    Pets p on op.pet_id = p.pet_id
    order by
    owner_name;

-- query 2 select appointments from a pet, with vet name + diagnosis
select
	v.vet_name,
    t.diagnosis
    from
    Vets_Treatments_and_Pets vtp
    join 
    Treatments t ON vtp.treatment_id = t.treatment_id
    join
    Vets v on vtp.vet_id = v.vet_id
    where
    vtp.pet_id = 1;
    
-- query 3 select the average cost per vet
select
	v.vet_name,
    round(avg(t.cost),2) as average_cost
    from Vets_Treatments_and_Pets vtp
    join Vets v on vtp.vet_id = v.vet_id
    join Treatments t on vtp.treatment_id = t.treatment_id
    group by
    v.vet_name
    order by
    average_cost desc;
    
-- query 4 all animals that were treated inthe last 30 days
select 
	p.pet_id,
	p.pet_name,
    t.treatment_date
    from Treatments t
    join Pets p on t.pet_id = p.pet_id
    where t.treatment_date >= current_date() - Interval 30 day;

-- query 5 owners who's pets have had more than 2 treatments
select
	o.owner_id,
	concat(o.first_name, ' ', o.last_name) as owner_name
    from Owners_and_Pets oap
    join Pet_Owners o on oap.owner_id = o.owner_id
    where oap.pet_id in
		(
		select pet_id
		from Treatments t
        group by pet_id
        having count(*) > 1
        )
    group by owner_id;
    
-- query 6 select the most expensive treatment for each pet
select
	pet_id,
	pet_name,
    treatment,
    cost
    from
    (
		select
			p.pet_id,
			p.pet_name,
            t.treatment,
            t.cost,
            row_number() over (partition by p.pet_id order by t.cost desc) rn
		from 
			Treatments t
		join Pets p on t.pet_id = p.pet_id
        )
	ranked
    where rn = 1
    order by cost desc;
    
-- query 7 select all pets treated by a specific vet
select
	p.pet_name,
    v.vet_name,
    v.vet_id
    from Vets_Treatments_and_Pets vtp
    join Pets p on vtp.pet_id = p.pet_id
    join Vets v on vtp.vet_id = v.vet_id
    where vtp.vet_id = 3
    group by p.pet_name;

-- query 8 select all owners who havent yet brought a pet for treatment
select
	o.owner_id,
	concat(o.first_name, ' ', o.last_name) as owner_name,
    p.pet_name
    from Owners_and_Pets oap
    join Pet_Owners o on oap.owner_id = o.owner_id
    join Pets p on oap.pet_id = p.pet_id
    where oap.pet_id not in
		(
		select pet_id
		from Treatments
        );