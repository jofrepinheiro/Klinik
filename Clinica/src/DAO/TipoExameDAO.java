package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TipoExame;
import conexao.Conexao;

public class TipoExameDAO {
	
	//public getTipoExameList
	
	public void cadastrarTipoExame(TipoExame tipoExame) throws SQLException{
		Connection con = new Conexao().getConnection();
		
		String sql = "INSERT INTO TIPOEXAME (idTipoExame, descricao) VALUES (?, ?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1, tipoExame.getIdTipoExame());
		statement.setString(2, tipoExame.getDescricao());

		statement.executeUpdate();
		
		statement.close();
		con.close();
	}

}
