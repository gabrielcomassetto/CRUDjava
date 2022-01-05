package av2java;

import java.util.Scanner;


public class Main {
	Scanner sc = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
	
		public static void main(String[] args) {
		
			new Main().menu();
	}
		private void menu() {
			Main opc = new Main();
			
			int opçao = 0;
			while(opçao != 9) {
					System.out.println("----------------------------------");
					System.out.println("1 - Criar tabela conta corrente. ");
					System.out.println("2 - Inserir dados do cliente. ");
					System.out.println("3 - Listar dados da conta. ");
					System.out.println("4 - Deletar cliente. ");
					System.out.println("5 - Atualizar dados. ");
					System.out.println("9 - Encerrar. ");
					System.out.println("Escolha uma opção: ");
					System.out.println("----------------------------------");
					int opcao = sc.nextInt();
					
					if (opcao == 9) {
						break;
					}
					switch (opcao) {
					case 1:
						opc.CriarTabelaConta();
						break;
					case 2:
						opc.InserirDados();
						break;
					case 3:
						opc.ExibirDados();
						break;
					case 4:
						opc.DeletarCliente();
						break;
					case 5:
						opc.AtualizaDados();
						break;
					default:
					
					}
				}
			}
		

			private void CriarTabelaConta() {
			criarTabela ex = new criarTabela();
			ex.criaConta();
		}
			
			private void InserirDados() {
				Cadastrar ex = new Cadastrar();
				ex.inserirDados();
			}
			
			private void ExibirDados() {
				Listagem ex = new Listagem();
				ex.getClientes();
				
				
			}
			
			private void DeletarCliente() {
				Excluir ex = new Excluir();
				ex.Deletar();
			}
			
			private void AtualizaDados() {
				Atualizar ex = new Atualizar();
				ex.Atualiza();
			}
	}
