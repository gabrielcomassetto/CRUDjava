package av2java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Listagem {
	
	public List<Cliente> getClientes() {
		String sql = "SELECT * FROM contacorrente";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Cliente cliente = new Cliente();
				
				cliente.setAgenciaID(rset.getInt(1));
				cliente.setClientId(rset.getInt(2));
				cliente.setNome(rset.getString(3));
				cliente.setSaldo(rset.getFloat(4));
				
				System.out.println("Nome: " + rset.getString(3));
				System.out.println("Numero da agencia: " + rset.getInt(1));
				System.out.println("Numero da conta: " + rset.getInt(2));
				System.out.println("Saldo: " + rset.getFloat(4));
				

				
				
				
				clientes.add(cliente);
			}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
				}catch(Exception e) {
				e.printStackTrace();
			}
		}
			return clientes;
	}
}
