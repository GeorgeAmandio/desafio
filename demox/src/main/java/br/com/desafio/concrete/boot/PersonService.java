package br.com.desafio.concrete.boot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

  @Autowired
  private JdbcTemplate jdbcTemplate;
    
  public int addPerson(Person person){
    String sql = "INSERT INTO person(id, name, email, password, created, modified, last_login, token) VALUES(?,?,?,?,?,?,?,?)";
    return jdbcTemplate.update(sql, person.getId(), person.getNome(), person.getEmail(), person.getPassword(), person.getCreated(), person.getModified(), person.getLast_login(), person.getToken());    
  }
  
  public int updatePerson(String id, String token){
	    String sql = "Update person set modified=? , last_login=?, token=? where id=?";
	    return jdbcTemplate.update(sql, new Date(), new Date(), token, id);    
	  }  
   
  public Person getPersonComplete(String id){

		String sql = "SELECT p.id, p.password, p.name, p.email, p.created, p.modified, p.last_login, p.token, t.ddd, t.number FROM person p, telefones t where p.id = t.person and p.id = ?";
		Person person = (Person)jdbcTemplate.queryForObject(sql, new Object[] { id }, new RowMapper<Person>(){
				
			 public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			  Person p = new Person();
			  Telefone t = new Telefone();
			  p.setId(rs.getString("id"));
			  p.setPassword(rs.getString("password"));
			  p.setNome(rs.getString("name"));
			  p.setEmail(rs.getString("email"));
			  p.setCreated(rs.getDate("created"));
			  p.setModified(rs.getDate("modified"));
			  p.setLast_login(rs.getDate("last_login"));
			  p.setToken(rs.getString("token"));
			  t.setDdd(rs.getString("ddd"));
			  t.setNumero(rs.getString("number"));
			  p.getTelefones().add(t);
			  return p;
		  }
		  
	  });
		
		return person;
	}
  
  
  public Person getPersonCompleteByEmailAndPassword(String email, String password){

		String sql = "SELECT p.id, p.password, p.name, p.email, p.created, p.modified, p.last_login, p.token, t.ddd, t.number FROM person p, telefones t where p.id = t.person and p.email = ? and p.password = ?";
		Person person = (Person)jdbcTemplate.queryForObject(sql, new Object[] { email, password }, new RowMapper<Person>(){
				
			 public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			  Person p = new Person();
			  Telefone t = new Telefone();
			  p.setId(rs.getString("id"));
			  p.setPassword(rs.getString("password"));
			  p.setNome(rs.getString("name"));
			  p.setEmail(rs.getString("email"));
			  p.setCreated(rs.getDate("created"));
			  p.setModified(rs.getDate("modified"));
			  p.setLast_login(rs.getDate("last_login"));
			  p.setToken(rs.getString("token"));
			  t.setDdd(rs.getString("ddd"));
			  t.setNumero(rs.getString("number"));
			  p.getTelefones().add(t);
			  return p;
		  }
		  
	  });
		
		return person;
	}
 }
