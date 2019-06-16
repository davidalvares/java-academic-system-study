package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import dao.CrudDAO;
import model.Materia;

public class MateriaController<T> extends CrudDAO<T> implements Serializable {

	private static final long serialVersionUID = 2813129240492192004L;

	Materia materia = new Materia();
	CrudDAO<Materia> materiaCrud = new CrudDAO<Materia>();

	Scanner ler = new Scanner(System.in);

	public void salvar() {

		System.out.println("Digite o nome da materia:");
		materia.setNome(ler.nextLine());
		materiaCrud.save(materia);
		System.out.println("Matéria cadastrada com sucesso!");
	}

	public void buscarPorId() {

		System.out.println("Digite o Id da materia:");
		materia.setId(ler.nextLong());

		materia = materiaCrud.findById(Materia.class, materia.getId());
		if (materia == null) {
			System.out.println("Matéria não encontrada!");
		} else {
			System.out.println("Matéria do Id digitado:");
			System.out.println("Id:" + materia.getId());
			System.out.println("Nome:" + materia.getNome());
			System.out.println("__________________________________\n");
		}
	}

	public List<Materia> buscarTodos() {
		List<Materia> materias = materiaCrud.findAll(Materia.class);
		System.out.println("Lista de matérias:");
		if (materias.size() > 0) {
			materias.forEach(materia -> {
				System.out.println("ID:" + materia.getId());
				System.out.println("Nome da matéria:" + materia.getNome());
				System.out.println("__________________________________\n");
			});
		} else {
			System.out.println("A lista de professores está vazia!");
		}
		return materias;
	}

	public void atualizar() {

		System.out.println("Digite o Id da matéria para realizar a atualização:");
		materia.setId(ler.nextLong());
		ler.nextLine();

		materia = materiaCrud.findById(Materia.class, materia.getId());
		if (materia == null) {
			System.out.println("Id não encontrado!");
		} else {
			System.out.println("Digite o nome da matéria:");
			materia.setNome(ler.next());
			materiaCrud.update(materia);
			System.out.println("Matéria atualizada com sucesso!");
		}

	}

	public void delete() {

		System.out.println("Digite o Id da matéria a ser excluida:");
		materia.setId(ler.nextLong());
		ler.nextLine();

		materia = materiaCrud.findById(Materia.class, materia.getId());
		if (materia == null) {
			System.out.println("Id não encontrado!");
		} else {

			materiaCrud.remove(materia);
			System.out.println("Matéria excluida com sucesso!");

		}
	}
}
