package br.ifce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="remedio")
public class Remedio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nomeRe;
	
	@Column(name = "valor", nullable = true)
	private double valor;
	
	@Column(name = "quantidade", nullable = true)
	private int quantidade;

	
	
	public Remedio() {
		super();
	}
	
	

	public Remedio(int id, String nomeRe, double valor, int quantidade) {
		super();
		this.id = id;
		this.nomeRe = nomeRe;
		this.valor = valor;
		this.quantidade = quantidade;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRe() {
		return nomeRe;
	}

	public void setNomeRe(String nomeRe) {
		this.nomeRe = nomeRe;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double d) {
		this.valor = d;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
