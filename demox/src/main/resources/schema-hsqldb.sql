CREATE TABLE person(
	id PRIMARY KEY IDENTITY , 
	name 	VARCHAR(150),
	email 	VARCHAR(150),
	password	INTEGER,
	created date,
	modified date,
	last_login date,
	token varchar(255)
)

CREATE TABLE TELEFONES( 
  id_fone PRIMARY KEY IDENTITY , 
  number 	VARCHAR(9),
	ddd 	VARCHAR(2),
  person FOREIGN KEY REFERENCES person(id) 
  ); 
  

