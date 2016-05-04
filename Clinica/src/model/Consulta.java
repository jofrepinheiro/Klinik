package model;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
	private int idConsulta;
	private int idPagamento;
	private int idPaciente;
	private int idMedico;
	private Date dataConsulta;
	private Time horarioConsulta;
	private String motivo;
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataRealizacao) {
		this.dataConsulta = dataRealizacao;
	}
	public Time getHorarioConsulta() {
		return horarioConsulta;
	}
	public void setHorarioConsulta(Time horario) {
		this.horarioConsulta = horario;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
