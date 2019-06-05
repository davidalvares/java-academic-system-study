package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import dao.CrudDAO;
import model.Aluno;

public class AlunoController<T> extends CrudDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	Aluno aluno = new Aluno();

	CrudDAO<Aluno> alunoCrud = new CrudDAO<Aluno>();

	Scanner ler = new Scanner(System.in);

	public void salvar() {

		System.out.println("Digite o nome do aluno:");
		aluno.setNome(ler.nextLine());
		alunoCrud.save(aluno);
		System.out.println("Aluno(a) cadastrado com sucesso!");
	}

	public List<Aluno> buscarTodos() {

		List<Aluno> alunos = alunoCrud.findAll(Aluno.class);
		if (alunos.isEmpty()) {
			System.out.println("A lista de alunos(a) está vazia!");

		} else {
			System.out.println("Lista de alunos:\n" + alunos);
		}

		return alunos;

	}

	public void buscarPorId() {

		System.out.println("Digite o Id do aluno");
		aluno.setId(ler.nextLong());

		aluno = alunoCrud.findById(Aluno.class, aluno.getId());
		if (aluno == null) {
			System.out.println("Aluno(a) não encontrado!");
		} else {
			System.out.println("Aluno do ID digitado:" + aluno.getId() + "\n" + aluno.getNome());
		}

	}

	public void atualizar() {

		System.out.println("Digite o id no aluno para realizar a atualização:");
		aluno.setId(ler.nextLong());
		ler.nextLine();

		aluno = alunoCrud.findById(Aluno.class, aluno.getId());
		if (aluno == null) {
			System.out.println("ID não encontrado!");

		} else {
			System.out.println("Digite o nome do Aluno:");
			aluno.setNome(ler.next());
			alunoCrud.update(aluno);
			System.out.println("Aluno alterado com sucesso!");
		}

	}

	public void delete() {
		System.out.println("Digite o Id do aluno a ser excluido");
		aluno.setId(ler.nextLong());
		ler.nextLine();

		aluno = alunoCrud.findById(Aluno.class, aluno.getId());
		if (aluno == null) {
			System.out.println("A lista de alunos(a) está vazia!");
		}
		alunoCrud.remove(aluno, aluno.getId());
		System.out.println("Aluno(a) Excluido com sucesso!");

	}

}
