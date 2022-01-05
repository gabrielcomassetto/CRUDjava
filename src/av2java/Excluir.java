package av2java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Excluir {
	
	Scanner sc = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
	
	public void Deletar() {
	
		
	Cliente cliente = new Cliente();
		
	System.out.println("Digite o nome do cliente para deletar.");
	cliente.setNome(sc.next());
	String sql = "DELETE FROM contacorrente WHERE nome like ?";
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn =	Conexao.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setString(1, cliente.getNome());
		pstm.execute();
		System.out.println("Cliente deletado com sucesso.");
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm!=null) {
				pstm.close();
			}
			
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
			}
		}
	}
}
