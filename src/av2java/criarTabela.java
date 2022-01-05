package av2java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import crud.factory.ConnectionFactory;

public class criarTabela {

	public void criaConta() {
	 
		String sql = "create table contacorrente" + "( agID int NOT NULL , "
				+ "  conID int NOT NULL , " + "  nome VARCHAR(32) , " + "  saldo int , "
				+ "   primary key (agID , conID)" + " )";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.execute();
			System.out.println("Tabela criada com sucesso.");
			
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
