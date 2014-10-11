package br.ifce.teste;

import java.util.List;

import br.ifce.dao.FuncionarioDao;
import br.ifce.dao.RemedioDao;
import br.ifce.entity.Funcionario;
import br.ifce.entity.Remedio;

public class Teste {

	public static void main(String[] args) {
		
		RemedioDao rem = new RemedioDao();
		
		//FuncionarioDao fun = new FuncionarioDao();
		
		/*
		Remedio r1 = new Remedio();
		
		r1.setNomeRe("Benegrip");
		r1.setQuantidade(5);
		r1.setValor(3.8);
		
		rem.create(r1);
		*/
		
		//fun.obterPorId(7);
		
		
		/*
		Funcionario f1 = new Funcionario();
		
		f1.setIdade(32);
		f1.setNome("Alisson");
		f1.setSenha("444");
		
		fun.create(f1);
		*/
		
		
		List<Remedio> lista = rem.readByName(null);
		
		for (Remedio remedio : lista) {
			System.out.println("Nome : "+remedio.getNomeRe());
		}
		
		/*
		List<Funcionario> list = fun.readByName(null);
		
		for (Funcionario funcionario : list) {
			System.out.println("Nome : "+funcionario.getNome());
		}*/
		
	}

}
