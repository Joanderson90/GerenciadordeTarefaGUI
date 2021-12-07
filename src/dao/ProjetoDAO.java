package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Projeto;

public class ProjetoDAO {

	public static boolean create(Projeto projeto) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement("INSERT INTO projetos (titulo, descricao) VALUES (?, ?)");

			stmt.setString(1, projeto.getTitulo());
			stmt.setString(2, projeto.getDescricao());
			
			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(con, stmt);
		}

		return false;
	}

	public static List<Projeto> getProjetos() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Projeto> projetosCadastrados = new ArrayList<>();

		try {

			stmt = con.prepareStatement("SELECT * FROM projetos");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Projeto projeto = new Projeto();

				projeto.setId(rs.getInt("id"));
				projeto.setTitulo(rs.getString("titulo"));
				projeto.setDescricao(rs.getString("descricao"));

				projetosCadastrados.add(projeto);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return projetosCadastrados;

	}

	public static boolean update(Projeto newProjeto) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement("UPDATE projetos SET titulo = ?, descricao = ? WHERE id = ?");

			stmt.setString(1, newProjeto.getTitulo());
			stmt.setString(2, newProjeto.getDescricao());
			stmt.setInt(5, newProjeto.getId());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt);
		}

		return false;
	}

	public static boolean remove(Projeto projetoTarget) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement("DELETE FROM projetos  WHERE id = ?");

			stmt.setInt(1, projetoTarget.getId());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt);
		}

		return false;
	}

}
