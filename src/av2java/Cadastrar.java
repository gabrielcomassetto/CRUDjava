package av2java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Cadastrar {
	Scanner sc = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
	
	public void inserirDados() {
		 
		Cliente cliente = new Cliente();
		
		System.out.println("Digite a agencia: ");
		cliente.setAgenciaID(sc.nextInt());
		System.out.println("Digite o numero da conta: ");
		cliente.setClientId(sc.nextInt());
		System.out.println("Digite o nome do Cliente: ");
		cliente.setNome(sc.next());
		System.out.println("Digite o saldo do cliente: ");
		cliente.setSaldo(sc.nextFloat());
		
		String sql = "INSERT INTO contacorrente(agID, conID, nome, saldo) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, cliente.getAgenciaID());
			pstm.setInt(2, cliente.getClientId());
			pstm.setString(3, cliente.getNome());
			pstm.setFloat(4, cliente.getSaldo());
			
			
			
			pstm.execute();
			System.out.println("Cliente cadastrado com sucesso.");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {

			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	}

}
