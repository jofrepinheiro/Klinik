package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Administrador;
import model.Medico;
import model.Secretario;
import model.Usuario;
import conexao.Conexao;

public class SecretarioDAO {
	public ArrayList<Secretario> getSecretarioList() throws SQLException{
		ArrayList<Secretario> secretarioList = new ArrayList<>();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		Connection con = new Conexao().getConnection();
		
		String sql = "SELECT * FROM SECRETARIO";
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()){
			Secretario secretario = new Secretario();	
			secretario.setIdSecretario(rs.getInt(1));
			secretario.setTurno(rs.getInt(2));
			secretario.setIdUsuario(rs.getInt(3));
			usuario = usuarioDAO.getUsuario(secretario);
			secretario.setNome(usuario.getNome());
			secretario.setCpf(usuario.getCpf());
			secretario.setLogin(usuario.getLogin());
			secretario.setSenha(usuario.getSenha());
			secretario.setDataNascimento(usuario.getDataNascimento());
			secretario.setEmail(usuario.getEmail());
			secretario.setTelefone(usuario.getTelefone());
			secretario.setAtivo(usuario.getAtivo());	
			if(secretario.getAtivo() != 0){
				secretarioList.add(secretario);
			}
		}
		
		statement.close();
		con.close();
		
		return secretarioList;	
	}
	
	public Secretario getSecretario(int idSecretario) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		Connection con = new Conexao().getConnection();
		Secretario secretario = new Secretario();
		
		String sql = "SELECT idSecretario, idUsuario FROM SECRETARIO WHERE idSecretario=?";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, idSecretario);
		ResultSet rs = statement.executeQuery();
		
		while (rs.next()){
			secretario.setIdSecretario(rs.getInt(1));
			secretario.setIdUsuario(rs.getInt(2));
		}
		
		usuario = usuarioDAO.getUsuario(secretario);
		secretario.setNome(usuario.getNome());
		secretario.setEmail(usuario.getEmail());
		secretario.setAtivo(usuario.getAtivo());	
		statement.close();
		con.close();
		
		return secretario;
	}
	
	public void cadastrarSecretario(Secretario secretario) throws SQLException{
		Connection con = new Conexao().getConnection();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.cadastrarUsuario(secretario);
		int idUsuario = usuarioDAO.getIdUsuario();
		System.out.println("USUARIO = " + idUsuario);
		
		String sql = "INSERT INTO SECRETARIO (idUsuario, turno) VALUES (?, ?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, idUsuario);
		statement.setInt(2, secretario.getTurno());

		statement.executeUpdate();
		
		statement.close();
		con.close();
	}
	
	public void deletarSecretario(Secretario secretario) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.inativarUsuario(secretario.getIdUsuario());
	}
	
	public void alterarSecretario(Secretario secretario) throws SQLException{
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterarUsuario(secretario);		
	}
}
