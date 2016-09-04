package br.com.desafio.concrete.boot;

import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("desafio/concrete")
public class PrincipalController {
	 
	@Autowired
	PersonService personService;

	@Autowired
	TelefoneService telefoneService;
		
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.PUT)
	public @ResponseBody Person post(@RequestBody Person person) {		
		person.setId(new BigInteger(UUID.randomUUID().toString().replaceAll("-", ""), 16).toString(36));
		person.setCreated(new Date());
	    person.setLast_login(new Date());
	    person.setModified(new Date());
	    this.personService.addPerson(person);
	    Telefone telefone = new Telefone();
	    for(Telefone aux :person.getTelefones()){
	    	telefone.setId(new BigInteger(UUID.randomUUID().toString().replaceAll("-", ""), 16).toString(36));
	    	telefone.setNumero(aux.getNumero());
	    	telefone.setDdd(aux.getDdd());
	    	telefone.setPerson_fk(person.getId());
	    	person.getTelefones().add(telefone);
	    }
	    telefoneService.addTelefone(telefone);
	    
	    return personService.getPersonComplete(person.getId());
	}
	
}
