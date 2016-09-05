package br.com.desafio.concrete.boot;

import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
		try{
		person.setId(new BigInteger(UUID.randomUUID().toString().replaceAll("-", ""), 16).toString(36));
		String dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
		person.setCreated(dataAtual);
	    person.setLast_login(dataAtual);
	    person.setModified(dataAtual);
	    this.personService.addPerson(person);
	    Telefone telefone = new Telefone();
	    for(Telefone aux :person.getPhones()){
	    	telefone.setId(new BigInteger(UUID.randomUUID().toString().replaceAll("-", ""), 16).toString(36));
	    	telefone.setNumero(aux.getNumero());
	    	telefone.setDdd(aux.getDdd());
	    	telefone.setPerson_fk(person.getId());
	    	person.getPhones().add(telefone);
	    }
	    telefoneService.addTelefone(telefone);
		}catch(Exception e){
			e.printStackTrace();
		}
	    return personService.getPersonComplete(person.getId());
	}
	
	@ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
    	response.sendError(HttpStatus.BAD_REQUEST.value());
    }
	
}
