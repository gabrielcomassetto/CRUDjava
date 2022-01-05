package av2java;

public class Cliente {

	private String nome;
	private int clientId = 0;
	private int agenciaId = 0;
	private float saldo = 0;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getAgenciaID() {
		return agenciaId;
	}
	public void setAgenciaID(int agenciaID) {
		this.agenciaId = agenciaID;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
