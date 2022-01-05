package av2java;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
	
		private static final String USERNAME = "root";
		private static final String PASSWORD = "1234";
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3307/av2";
		
		public static Connection createConnectionToMySQL() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			return connection;
		}
		
		public static void main(String[] args) throws Exception{
			Connection conn = createConnectionToMySQL();
		
			if(conn!=null) {
				System.out.println("Conexao obtida com sucesso.");
				conn.close();
			}
				else {
					System.out.println("Falha na conexao.");
		}
	}
}


