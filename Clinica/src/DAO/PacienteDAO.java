package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Paciente;
import conexao.Conexao;

public class PacienteDAO {
	public void cadastrarPaciente(Paciente paciente) throws SQLException{
		Connection con = new Conexao().getConnection();
		String sql = "INSERT INTO PACIENTE (nome, telefone, cpf, email, sexo, dataNasc, idEndereco) "
				+ "VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, paciente.getNome());
		statement.setString(2, paciente.getTelefone());
		statement.setString(3, paciente.getCpf());
		statement.setString(4, paciente.getEmail());
		statement.setInt(5, paciente.getSexo());
		statement.setDate(6, paciente.getDataNasc());
		statement.setInt(7, paciente.getIdEndereco());
		statement.executeUpdate();
		
		statement.close();
		con.close();
	}
	
	public void alterarPaciente(){
		
	}
	
	public void ListarPacientes(){
		
	}
}
