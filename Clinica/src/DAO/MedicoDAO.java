package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrador;
import model.Medico;
import model.Secretario;
import model.Usuario;
import conexao.Conexao;

public class MedicoDAO {
	public Medico getMedico(int idMedico) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		Connection con = new Conexao().getConnection();
		Medico medico = new Medico();
		
		String sql = "SELECT idMedico, idUsuario, CRM FROM Medico WHERE idMedico=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, idMedico);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()){
			medico.setIdMedico(rs.getInt(1));
			medico.setIdUsuario(rs.getInt(2));
			medico.setCRM(rs.getString(3));
		}
		
		usuario = usuarioDAO.getUsuario(medico);
		medico.setNome(usuario.getNome());
		medico.setEmail(usuario.getEmail());
		medico.setAtivo(usuario.getAtivo());	
		statement.close();
		con.close();
		
		return medico;
	}
	
	public void cadastrarMedico(Medico medico) throws SQLException{
		Connection con = new Conexao().getConnection();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrarUsuario(medico);
		int idUsuario = usuarioDAO.getIdUsuario();
		System.out.println("USUARIO = " + idUsuario);
		
		String sql = "INSERT INTO MEDICO (idUsuario, CRM) VALUES (?, ?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, idUsuario);
		statement.setString(2, medico.getCRM());

		statement.executeUpdate();
		
		statement.close();
		con.close();
	}
	
	public void deletarMedico(Medico medico) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inativarUsuario(medico.getIdUsuario());
	}
	
	public void alterarMedico(Medico medico) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterarUsuario(medico);;		
	}
}
