package br.com.desafio.concrete.boot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefones")
public class Telefone implements java.io.Serializable{
	
  private Long id;
  private String numero;
  private String ddd;
  private Person person;
  	
  	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_fone" )
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="number", length=150)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(name="ddd", length=150)
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	} 
  
}
