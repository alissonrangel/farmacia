package br.ifce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "idade", nullable = true)
	private int idade;
	
	@Column(name = "salario", nullable = true)
	private float salario;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	
	
	public Funcionario() {
		super();
	}

	
	
	public Funcionario(int id, String nome, int idade, float salario, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.senha = senha;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
