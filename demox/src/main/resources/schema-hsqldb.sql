CREATE TABLE person(
	id PRIMARY KEY IDENTITY , 
	name 	VARCHAR(150),
	email 	VARCHAR(150),
	password	INTEGER
)

CREATE TABLE TELEFONES( 
  id_fone PRIMARY KEY IDENTITY , 
  number 	VARCHAR(9),
	ddd 	VARCHAR(2),
  person integer FOREIGN KEY REFERENCES person(id) 
  ); 
  

