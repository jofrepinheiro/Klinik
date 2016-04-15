package model;

import java.sql.Date;
import java.sql.Time;

public class DadosConsulta {
	private int idDadosConsulta;
	private int idConsulta;
	private Date dataRegistro;
	private Time horarioRegistro;
	private String descricao;
	
	public int getIdDadosConsulta() {
		return idDadosConsulta;
	}
	public void setIdDadosConsulta(int idDadosConsulta) {
		this.idDadosConsulta = idDadosConsulta;
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	public Time getHorarioRegistro() {
		return horarioRegistro;
	}
	public void setHorarioRegistro(Time horarioRegistro) {
		this.horarioRegistro = horarioRegistro;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
}
