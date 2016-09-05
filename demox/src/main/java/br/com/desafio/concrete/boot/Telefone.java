package br.com.desafio.concrete.boot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "phones")
@JsonInclude(Include.NON_NULL)
public class Telefone{
	
  private String id;
  private String number;
  private String ddd;
  private String person_fk;
  	
  	
  	@Id 
  	@Column( name = "id_fone" )
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Column(name="ddd", length=150)
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	@Column(name="person", length=150)
	public String getPerson_fk() {
		return person_fk;
	}

	public void setPerson_fk(String person_fk) {
		this.person_fk = person_fk;
	}
	
}
