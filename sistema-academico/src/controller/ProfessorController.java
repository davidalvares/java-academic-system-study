package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import dao.CrudDAO;
import model.Professor;

public class ProfessorController<T> extends CrudDAO<T> implements Serializable {

	private static final long serialVersionUID = -7126093798949676295L;

	Professor professor = new Professor();
	CrudDAO<Professor> professorCrud = new CrudDAO<Professor>();

	Scanner ler = new Scanner(System.in);

	public void salvar() {

		System.out.println("Digite o nome do professor:");
		professor.setNome(ler.nextLine());

		System.out.println("Digite o nome da materia a ser ministrada:");
		professor.setMateria(ler.nextLine());

		professorCrud.save(professor);
		System.out.println("Professor cadastrado com sucesso!");

	}

	public void buscarPorId() {

		System.out.println("Digite o id do professor:");
		professor.setId(ler.nextLong());

		professor = professorCrud.findById(Professor.class, professor.getId());
		if (professor == null) {
			System.out.println("Professor(a) não encontrado!");
		} else {
			System.out.println("Professor do ID Digitado:" + "\n" + "ID:" + professor.getId() + "\n" + "Nome:"
					+ professor.getNome() + "\n" + "Materia:" + professor.getMateria());
			System.out.println("__________________________________\n");
		}

	}

	public List<Professor> buscarTodos() {

		List<Professor> professores = professorCrud.findAll(Professor.class);
		System.out.println("Lista de Professores:");
		if (professores.size() > 0) {
			professores.forEach(professor -> {
				System.out.println("ID:" + professor.getId());
				System.out.println("Nome:" + professor.getNome());
				System.out.println("Materia:" + professor.getMateria());
				System.out.println("__________________________________\n");
			});
		} else {
			System.out.print("A lista de professores(a) está vazia!");
		}
		return professores;

	}

	public void atualizar() {
		System.out.println("Digite o id do professor(a) para realizar a atualização:");
		professor.setId(ler.nextLong());
		ler.nextLine();

		professor = professorCrud.findById(Professor.class, professor.getId());
		if (professor == null) {
			System.out.println("ID não encotrando!");
		} else {
			System.out.println("Digite o nome do professor(a):");
			professor.setNome(ler.nextLine());
			System.out.println("Digite o nome da materia:");
			professor.setMateria(ler.nextLine());
			professorCrud.update(professor);
			System.out.println("Professor atualizado com sucesso!");
		}
	}

	public void delete() {
		System.out.println("Digite o id do professor a ser excluido:");
		professor.setId(ler.nextLong());
		ler.nextLine();

		professor = professorCrud.findById(Professor.class, professor.getId());
		if (professor == null) {
			System.out.println("ID não encontrado!");
		} else {
			professorCrud.remove(professor);
			System.out.println("profesor(a) excluido com sucesso!");

		}
	}
}
