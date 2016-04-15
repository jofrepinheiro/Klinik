package model;

public class Secretario extends Usuario{
	private int idSecretario;
	private int idUsuario;
	private int turno;
	
	public int getIdSecretario() {
		return idSecretario;
	}
	public void setIdSecretario(int idSecretario) {
		this.idSecretario = idSecretario;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
}
