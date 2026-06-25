-- Country table creation script (as per Hands on - Spring Data JPA Quick Example)

create table country(code varchar(2) primary key, name varchar(50));

insert into country values ('IN', 'India');
insert into country values ('US', 'United States of America');

-- NOTE: For this Quick Example project, spring.jpa.hibernate.ddl-auto=update is used,
-- so Hibernate auto-creates the 'country' table from the Country entity.
-- This script is provided for reference if you want to create the table manually
-- in MySQL (as described in the original hands-on document).
