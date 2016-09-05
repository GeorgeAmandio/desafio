CREATE TABLE person(
	id PRIMARY KEY IDENTITY , 
	name VARCHAR(150),
	email VARCHAR(150),
	password VARCHAR(150),
	created VARCHAR(150),
	modified VARCHAR(150),
	last_login VARCHAR(150),
	token varchar(255)
)

CREATE TABLE phones( 
  id_fone PRIMARY KEY IDENTITY, 
  number VARCHAR(9),
	ddd VARCHAR(2),
  person FOREIGN KEY REFERENCES person(id) 
  ) 
  

