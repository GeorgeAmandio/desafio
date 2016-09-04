package br.com.desafio.concrete.boot;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "person")
@JsonInclude(Include.NON_NULL)
public class Person{
	
  
  private String id;
  private String nome;
  private String email;
  private String password;
  private Date created;
  private Date modified;
  private Date last_login;
  private String token;
  private Set<Telefone> telefones = new HashSet<Telefone>(0);
  

  	@Id
  	@Column( name = "id" )
	public String getId() {
		return id;
	}

  	public void setId(String id) {
		this.id = id;
	}
  	
	
	@Column(name="name", length=150)
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="email", length=150)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person_fk")
	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	@Column(name="created")
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Column(name="modified")
	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
	
	@Column(name="last_login")
	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
	@Column(name="token", length=255)
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	
}
