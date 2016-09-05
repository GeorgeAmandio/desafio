package br.com.desafio.concrete.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class TelefoneService {

  @Autowired
  private JdbcTemplate jdbcTemplate;
    
  public int addTelefone(Telefone telefone){
    String sql = "INSERT INTO phones(id_fone, number, ddd, person) VALUES(?,?,?,?)";
    return jdbcTemplate.update(sql, telefone.getId(), telefone.getNumber(), telefone.getDdd(), telefone.getPerson_fk());    
  }
}
