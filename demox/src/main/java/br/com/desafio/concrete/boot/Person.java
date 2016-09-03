package br.com.desafio.concrete.boot;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person implements java.io.Serializable{
	
  
  private Long id;
  private String nome;
  private String email;
  private String password;
  
  /*@Transient*/
  /*private List<Telefone> telefones;*/
  private Set<Telefone> telefones = new HashSet<Telefone>(0);
  
  	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
	/*public List<Telefone> getTelefones() {
		return telefones;
	}
	
	@OneToMany
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}*/
	
	
}
