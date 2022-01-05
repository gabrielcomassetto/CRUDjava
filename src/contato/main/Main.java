package contato.main;

import crudDAO.ContatoDAO;
import crudjava.Contato;

public class Main {
	
	public static void main(String[] args) {
		
		
		//Inserir
		ContatoDAO contatoDao = new ContatoDAO();
		Contato contato = new Contato();
		contatoDao.inserir(contato);
		
		//Visualizar
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Nome: "+c.getNome());
			System.out.println("Telefone: "+c.getTelefone());
			}
		
		//Atualizar	
		Contato c1 = new Contato();
		contatoDao.atualizar(c1);
		
		
		//Deletar
		Contato d1 = new Contato();
		contatoDao.deleteById(d1);
	
	}
}
