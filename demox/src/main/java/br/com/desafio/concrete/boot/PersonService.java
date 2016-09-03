package br.com.desafio.concrete.boot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

  @Autowired
  private JdbcTemplate jdbcTemplate;
    
  public int addPerson(Person person){
    String sql = "INSERT INTO person(name, email, password) VALUES(?,?,?)";
    return jdbcTemplate.update(sql, person.getNome(), person.getEmail(), person.getPassword());    
  }
  
  public List<Person> getAllPerson(){
    return jdbcTemplate.query("SELECT * FROM person", new RowMapper<Person>(){

      public Person mapRow(ResultSet rs, int arg1) throws SQLException {
        Person p = new Person();
        p.setPassword(rs.getString("password"));
        p.setNome(rs.getString("name"));
        p.setEmail(rs.getString("email"));
        return p;
      }
      
    });
  }

  public List<Person> getAllPersonWithTel(){
	  return jdbcTemplate.query("SELECT * FROM person p, telefones t where p.id = t.person", new RowMapper<Person>(){
		  
		  public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			  Person p = new Person();
			  p.setPassword(rs.getString("password"));
			  p.setNome(rs.getString("name"));
			  p.setEmail(rs.getString("email"));
			  return p;
		  }
		  
	  });
  }
}
