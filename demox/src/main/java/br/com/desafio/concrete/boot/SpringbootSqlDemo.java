package br.com.desafio.concrete.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSqlDemo implements CommandLineRunner{

  Logger logger = LoggerFactory.getLogger(SpringbootSqlDemo.class);
  
  
  @Autowired
  PersonService personService;
 
  
  @Autowired
  PersonRepository personRepository;

  
  @Autowired
  TelefoneService telefoneService;
  
  
  @Autowired
  TelefoneRepository telefoneRepository;
  
  public void run(String... args) {
    Person person = new Person();
    person.setNome("George");
    person.setEmail("georgeamandio@gmail.com");
    person.setPassword("25");
    personService.addPerson(person);
    logger.info("Person saved successfully");
    Telefone telefone = new Telefone();
    telefone.setNumero("981514747");
    telefone.setDdd("13");
    telefone.setPerson(person);
    person.getTelefones().add(telefone);
    telefoneService.addTelefone(telefone);
    logger.info("Telefone saved successfully");
        
    /*if ( personService.addPerson(person) > 0){
      logger.info("Person saved successfully");
    }

    if ( telefoneService.addTelefone(telefone) > 0){
    	logger.info("Telefone saved successfully");
    }*/
    
    for(Person p : personService.getAllPerson()){
      logger.info(p.toString());
    }
    
   /* logger.info("Using JPA for insert and find");
    PersonEntity personEntity = new PersonEntity("fName2", "lName2", 24, "Bangalore");
    personEntity = personRepository.save(personEntity);
    logger.info("Person with ID: " + personEntity.getId() + " saved successfully");
    
    for ( PersonEntity pEntity : personRepository.findAll()){
      logger.info(pEntity.toString());
    }*/
  }
  
  public static void main(String[] args) {
    SpringApplication.run(SpringbootSqlDemo.class, args);
  }
 
}
