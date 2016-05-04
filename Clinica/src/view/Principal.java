package view;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;

import DAO.AdministradorDAO;
import DAO.MedicoDAO;
import DAO.SecretarioDAO;
import model.Administrador;
import model.Medico;
import model.Secretario;
import model.Usuario;

public class Principal {

	public static void main(String[] args) throws SQLException {
		AdministradorDAO admDao = new AdministradorDAO();
		Administrador adm = new Administrador();
		MedicoDAO medicoDAO = new MedicoDAO();
		Medico medico = new Medico();
		SecretarioDAO secretarioDAO = new SecretarioDAO();
		Secretario secretario = new Secretario();
//		adm.setAtivo(1);
//		adm.setDataNascimento(null);
//     	adm.setLogin("Railan Xisto");
//		adm.setSenha("blablaeu");
//		adm.setNome("Eu");
//		adm.setAtivo(1);
//		adm.setIdEndereco(1);
//		admDao.cadastrarAdministrador(adm);
//		System.out.println("teste");
		
		System.out.println("Secretarios");
		
		for (int i=0; i < secretarioDAO.getSecretarioList().size(); i++){
			System.out.print(secretarioDAO.getSecretarioList().get(i).getIdSecretario() + " ");
			System.out.print(secretarioDAO.getSecretarioList().get(i).getNome() + " ");
			System.out.println(secretarioDAO.getSecretarioList().get(i).getLogin() + " ");

		}
		
		//System.out.println("Inserido");
		//adm = admDao.getAdministrador(18);
		//System.out.println("ID="+adm.getIdAdministrador()+"Nome="+adm.getNome());
		admDao.deletarAdministrador(adm);
		//System.out.println("Deletado");
		
	}

}
