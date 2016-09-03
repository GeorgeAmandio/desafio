package br.com.desafio.concrete.boot;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


@Service
public class TelefoneService {

  @Autowired
  private JdbcTemplate jdbcTemplate;
    
  public int addTelefone(Telefone telefone){
    String sql = "INSERT INTO TELEFONES(number, ddd, person) VALUES(?,?,?)";
    return jdbcTemplate.update(sql, telefone.getNumero(), telefone.getDdd(), telefone.getPerson().getId());    
  }
  
  public List<Telefone> getAllTel(){
    return jdbcTemplate.query("SELECT * FROM telefones", new RowMapper<Telefone>(){

      public Telefone mapRow(ResultSet rs, int arg1) throws SQLException {
        Telefone t = new Telefone();
        
        t.setNumero(rs.getString("number"));
        t.setDdd(rs.getString("ddd"));
        t.setPerson((Person) rs.getObject("person"));
        return t;
      }
      
    });
  }
}
