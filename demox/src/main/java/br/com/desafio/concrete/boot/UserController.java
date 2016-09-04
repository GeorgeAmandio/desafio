package br.com.desafio.concrete.boot;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/desafio/concrete/login")
public class UserController {

	@Autowired
	PersonService personService;
	
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public Person login(@RequestBody final UserLogin login) throws ServletException {
        
    	Person person = personService.getPersonCompleteByEmailAndPassword(login.name, login.password);
    	
    	if (person == null) {
            throw new ServletException("Invalid login");
        }
    	
    	String token = new LoginResponse(Jwts.builder().setSubject(login.name)
                .claim("roles", person.getEmail()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact()).token;
    	
    	personService.updatePerson(person.getId(), token);
    	
    	
         new LoginResponse(Jwts.builder().setSubject(login.name)
            .claim("roles", person.getEmail()).setIssuedAt(new Date())
            .signWith(SignatureAlgorithm.HS256, "secretkey").compact());
         
         return personService.getPersonComplete(person.getId());
         
    }

    @SuppressWarnings("unused")
    private static class UserLogin {
        public String name;
        public String password;
    }

    @SuppressWarnings("unused")
    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
}
