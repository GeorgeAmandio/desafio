package br.com.desafio.concrete.boot;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("api/teste")
public class TesteController {
	
	/*@Autowired
	private TesteRepository testeRepository;*/
	 
	@Autowired
	PersonService testeRepository;

	@Autowired
	TelefoneService telefoneService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> index() {
		return testeRepository.getAllPerson();
	}

	@RequestMapping(value = "/tel" ,method = RequestMethod.GET)
	public List<Telefone> indexTel() {
		return telefoneService.getAllTel();
	}
	
	/*@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Teste get(@PathVariable Long id) {
		Teste teste = this.testeRepository.findOne(id);
		return teste;
	}	*/
	
	@RequestMapping(value = "/post", method = RequestMethod.PUT)
	public @ResponseBody int post(@RequestBody Person person) {		
/*		this.testeRepository.addPerson(person);*/
	    this.testeRepository.addPerson(person);
	    /*logger.info("Person saved successfully");*/
	    Telefone telefone = new Telefone();
	    for(Telefone aux :person.getTelefones()){
	    	telefone.setNumero(aux.getNumero());
	    	telefone.setDdd(aux.getDdd());
	    	telefone.setPerson(person);
	    	person.getTelefones().add(telefone);
	    }
	    return telefoneService.addTelefone(telefone);
	}
	
	/*@RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
	public HttpStatus put(@PathVariable Long id, Teste teste) {
		try {
			teste.setId(id);
			this.testeRepository.save(teste);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}*/
	
	/*@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public HttpStatus delete(@PathVariable Long id) {
		try {
			this.testeRepository.delete(id);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
*/	
}
