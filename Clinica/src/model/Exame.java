package model;

import java.sql.Date;
import java.sql.Time;

public class Exame {
	private int idExame;
	private int idPagamento;
	private int idConsulta;
	private int idPaciente;
	private Date dataExame;
	private Time horarioExame;
	private String resultado;
	private int idTipoExame;
	
	public int getIdExame() {
		return idExame;
	}
	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public int getIdTipoExame() {
		return idTipoExame;
	}
	public void setIdTipoExame(int idTipoExame) {
		this.idTipoExame = idTipoExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public Time getHorarioExame() {
		return horarioExame;
	}
	public void setHorarioExame(Time horarioExame) {
		this.horarioExame = horarioExame;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}	
}
