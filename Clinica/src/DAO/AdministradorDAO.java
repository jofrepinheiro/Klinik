package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrador;
import model.Secretario;
import model.Usuario;
import conexao.Conexao;

public class AdministradorDAO {
	
	public Administrador getAdministrador(int idAdministrador) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		Connection con = new Conexao().getConnection();
		Administrador administrador = new Administrador();
		
		String sql = "SELECT idAdministrador, idUsuario FROM ADMINISTRADOR WHERE idAdministrador=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, idAdministrador);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()){
			administrador.setIdAdministrador(rs.getInt(1));
			administrador.setIdUsuario(rs.getInt(2));
		}
		
		usuario = usuarioDAO.getUsuario(administrador);
		administrador.setNome(usuario.getNome());
		administrador.setEmail(usuario.getEmail());
		administrador.setAtivo(usuario.getAtivo());	
		statement.close();
		con.close();
		
		return administrador;
	}
	
	public void cadastrarAdministrador(Administrador administrador) throws SQLException{
		Connection con = new Conexao().getConnection();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrarUsuario(administrador);
		int idUsuario = usuarioDAO.getIdUsuario();
		System.out.println("USUARIO = " + idUsuario);
		
		String sql = "INSERT INTO ADMINISTRADOR (idUsuario) VALUES (?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, idUsuario);

		statement.executeUpdate();
		
		statement.close();
		con.close();
	}
	
	public void deletarAdministrador(Administrador administrador) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inativarUsuario(administrador.getIdUsuario());
	}
	
	public void alterarAdministrador(Administrador administrador) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterarUsuario(administrador);		
	}
	

}
