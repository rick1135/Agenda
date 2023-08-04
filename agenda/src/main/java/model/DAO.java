package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/* Módulo de conexão */

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbAgenda?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "325158";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/* CRUD CREATE */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contato (nome, fone, email) values (?, ?, ?)";
		try {
			// abrindo conexao com bd
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			// substituindo os parametros pelo conteudo das vars javabeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			// encerrando conexao com bd
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD READ */
	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contato = new ArrayList<>();
		String read = "select * from contato order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o while será executado enquanto tiver contatos
			while (rs.next()) {
				// variaveis auxiliares para receber dados do BD
				String idcontato = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// populando o ArrayList
				contato.add(new JavaBeans(idcontato, nome, fone, email));
			}
			con.close();
			return contato;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/*CRUD UPDATE */
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contato where idcontato = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getIdcontato());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcontato(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
