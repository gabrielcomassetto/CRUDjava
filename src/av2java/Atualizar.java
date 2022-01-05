package av2java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Atualizar {
	
Scanner sc = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
	
	public void Atualiza() {
	
		
	Cliente cliente = new Cliente();
		
	System.out.println("Digite o numero da conta para ser alterado. ");
	cliente.setAgenciaID(sc.nextInt());
	System.out.println("Digite o novo nome do Cliente: ");
	cliente.setNome(sc.next());
	System.out.println("Digite o novo saldo do cliente: ");
	cliente.setSaldo(sc.nextFloat());
	
	String sql = "UPDATE contacorrente SET nome = ?, saldo = ?  WHERE conID like ?";
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn =	Conexao.createConnectionToMySQL();
		
		pstm = (PreparedStatement)conn.prepareStatement(sql);
		
		pstm.setString(1, cliente.getNome());
		pstm.setFloat(2, cliente.getSaldo());
		pstm.setInt(3, cliente.getAgenciaID());
		pstm.execute();
		System.out.println("Dados atualizados. ");
		
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
