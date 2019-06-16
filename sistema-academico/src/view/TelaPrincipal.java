package view;

import java.io.Serializable;
import java.util.Scanner;

import controller.AlunoController;
import controller.MateriaController;
import controller.ProfessorController;
import model.Aluno;
import model.Materia;
import model.Professor;

public class TelaPrincipal implements Serializable {

	private static final long serialVersionUID = 1L;
	private Scanner s;

	public void MenuPrincipal() {
		s = new Scanner(System.in);
		int opcao = 0;
		do {

			System.out.println("\n\n### Seja bem vindo ao Sistema de cadastro de academico! ###");
			System.out.println("\n                  ===============================");
			System.out.println("                  |     1 - Alunos               |");
			System.out.println("                  |     2 - Professores          |");
			System.out.println("                  |     3 - Materias             |");
			System.out.println("                  |     0 - Sair                 |");
			System.out.println("                  |==============================|\n");
			opcao = s.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				this.menuAlunos();
				break;
			case 2:
				this.menuProfessores();
				break;
			case 3:
				this.menuMateria();
			default:
				System.out.println("Opção invalida!");
				break;
			}
		} while (opcao != 0);
	}

	public void menuAlunos() {

		AlunoController<Aluno> a = new AlunoController<Aluno>();

		s = new Scanner(System.in);
		int opcao = 0;
		do {

			System.out.println("\n\n### Seja bem vindo ao Sistema de cadastro de alunos! ###");
			System.out.println("\n                  ================================");
			System.out.println("                  |     1 - Matricular aluno        |");
			System.out.println("                  |     2 - Listar aluno            |");
			System.out.println("                  |     3 - listar todos os alunos  |");
			System.out.println("                  |     4 - Atualizar aluno         |");
			System.out.println("                  |     5 - Deletar aluno           |");
			System.out.println("                  |     0 - Sair                    |");
			System.out.println("                  |==============================   |\n");
			opcao = s.nextInt();
			System.out.print("\n");

			switch (opcao) {
			case 1:
				a.salvar();
				break;
			case 2:
				a.buscarPorId();
				break;
			case 3:
				a.buscarTodos();
				break;
			case 4:
				a.atualizar();
				break;
			case 5:
				a.delete();
			default:
				System.out.println("Opção invalida!");
				break;
			}
		} while (opcao != 0);

	}

	public void menuProfessores() {

		ProfessorController<Professor> p = new ProfessorController<Professor>();

		s = new Scanner(System.in);
		int opcao = 0;

		do {

			System.out.println("\n\n### Seja bem vindo ao modulo de cadastro de professores! ###");
			System.out.println("\n                  =====================================");
			System.out.println("                  |     1 - Cadastrar professor         |");
			System.out.println("                  |     2 - Listar professor            |");
			System.out.println("                  |     3 - listar todos os professores |");
			System.out.println("                  |     4 - Atualizar professor         |");
			System.out.println("                  |     5 - Deletar professor           |");
			System.out.println("                  |     0 - Sair                        |");
			System.out.println("                  |======================================|\n");
			opcao = s.nextInt();
			System.out.print("\n");

			switch (opcao) {
			case 1:
				p.salvar();
				break;
			case 2:
				p.buscarPorId();
				break;
			case 3:
				p.buscarTodos();
				break;
			case 4:
				p.atualizar();
				break;
			case 5:
				p.delete();
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		} while (opcao != 0);

	}

	public void menuMateria() {
		int opcao = 0;
		MateriaController<Materia> m = new MateriaController<Materia>();

		s = new Scanner(System.in);
		do {

			System.out.println("\n\n### Seja bem vindo ao Modulo de cadastro de materias! ###");
			System.out.println("\n                  =====================================");
			System.out.println("                  |     1 - Cadastrar matéria           |");
			System.out.println("                  |     2 - Listar matéria              |");
			System.out.println("                  |     3 - listar todas as matérias    |");
			System.out.println("                  |     4 - Atualizar matéria           |");
			System.out.println("                  |     5 - Deletar matéria             |");
			System.out.println("                  |     0 - Sair                        |");
			System.out.println("                  |======================================|\n");
			opcao = s.nextInt();
			System.out.print("\n");

			switch (opcao) {
			case 1:
				m.salvar();
				break;
			case 2:
				m.buscarPorId();
				break;
			case 3:
				m.buscarTodos();
				break;
			case 4:
				m.atualizar();
				break;
			case 5:
				m.delete();
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		} while (opcao != 0);

	}

}
