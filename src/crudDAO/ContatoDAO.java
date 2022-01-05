package crudDAO;

import java.sql.Connection;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crud.factory.ConnectionFactory;
import crudjava.Contato;

public class ContatoDAO {
	Scanner sc = new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
	
	public void inserir(Contato contato) {

		System.out.println("Digite o nome para inserção: ");
		contato.setNome(sc.next());
		System.out.println("Digite o telefone para inserção:");
		contato.setTelefone(sc.next());
		 
		String sql = "INSERT INTO registros(nome, telefone) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			
			pstm.execute();
			System.out.println("Dados inseridos com sucesso");
			
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
 
	public List<Contato> getContatos() {
		String sql = "SELECT * FROM registros";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Contato contato = new Contato();
				
				contato.setNome(rset.getString("nome"));
				contato.setTelefone(rset.getString("telefone"));
				
				contatos.add(contato);
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
			return contatos;
	}


	public void atualizar(Contato contato) {
		

		String sql = "UPDATE registros SET nome = ?, telefone = ?"+ "WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = 	(PreparedStatement) conn.prepareStatement(sql);
			
			System.out.println("Digite o id que deseja alterar");
			pstm.setInt(0, contato.getId(sc.nextInt()));
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getTelefone());
			;
			
			pstm.execute();
			
			
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

	public void deleteById(Contato contato) {
		
		System.out.println("Digite um ID para deletar.");
		contato.setId(0);
		String sql = "DELETE FROM agenda WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement)conn.prepareStatement(sql);
			
			pstm.setInt(1, contato.getId(0));
			
			pstm.execute();
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
	  
	
    

		
