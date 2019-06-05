package view;

import java.io.Serializable;
import java.util.Scanner;

import controller.AlunoController;
import model.Aluno;

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
				// this.buscarTodos();
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

		s = new Scanner(System.in);
		int opcao = 0;

		do {

			System.out.println("\n\n### Seja bem vindo ao Sistema de cadastro de professores! ###");
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

		} while (opcao != 0);

	}

	public void menuMateria() {

	}

}
