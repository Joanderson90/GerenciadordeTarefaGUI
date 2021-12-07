package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import date.MyDate;
import model.Status;
import model.Tarefa;

public class TarefaDAO {

	public static boolean create(Tarefa tarefa) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(
					"INSERT INTO tarefas (titulo, descricao, validade, status, idProjetoPertencente) VALUES (?, ?, ? , ?, ?)");

			stmt.setString(1, tarefa.getTitulo());
			stmt.setString(2, tarefa.getDescricao());
			stmt.setDate(3, new Date(MyDate.parseToSQLFormat(tarefa.getValidade()).getTime()));
			stmt.setString(4, tarefa.getStatus().name());
			stmt.setInt(5, tarefa.getIdProjetoPertencente());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(con, stmt);
		}

		return false;
	}

	public static List<Tarefa> getTarefas() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Tarefa> tarefasCadastradas = new ArrayList<>();

		try {

			stmt = con.prepareStatement("SELECT * FROM tarefas");

			rs = stmt.executeQuery();

			while (rs.next()) {

				Tarefa tarefa = new Tarefa();

				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setStatus(Status.getStatus(rs.getString("status")));
				tarefa.setValidade(MyDate.parseToComumFormat(rs.getDate("validade")));
				tarefa.setIdProjetoPertencente(rs.getInt("idProjetoPertencente"));

				tarefasCadastradas.add(tarefa);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return tarefasCadastradas;

	}

	public static boolean update(Tarefa newTarefa) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement(
					"UPDATE tarefas SET titulo = ?, descricao = ?, validade = ?, status = ? WHERE id = ?");

			stmt.setString(1, newTarefa.getTitulo());
			stmt.setString(2, newTarefa.getDescricao());
			stmt.setDate(3, new Date(MyDate.parseToSQLFormat(newTarefa.getValidade()).getTime()));
			stmt.setString(4, newTarefa.getStatus().name());
			stmt.setInt(5, newTarefa.getId());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt);
		}

		return false;
	}

	public static boolean remove(Tarefa tarefaTarget) {

		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement("DELETE FROM tarefas  WHERE id = ?");

			stmt.setInt(1, tarefaTarget.getId());

			stmt.executeUpdate();

			return true;

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(connection, stmt);
		}

		return false;
	}

	public static List<Tarefa> getTarefasByIdProjeto(int idProjeto) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Tarefa> tarefasCadastradas = new ArrayList<>();

		try {

			stmt = con.prepareStatement("SELECT * FROM tarefas WHERE idProjetoPertencente = ?");

			stmt.setInt(1, idProjeto);

			rs = stmt.executeQuery();

			while (rs.next()) {

				Tarefa tarefa = new Tarefa();

				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setStatus(Status.getStatus(rs.getString("status")));
				tarefa.setValidade(MyDate.parseToComumFormat(rs.getDate("validade")));
				tarefa.setIdProjetoPertencente(rs.getInt("idProjetoPertencente"));

				tarefasCadastradas.add(tarefa);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return tarefasCadastradas;

	}

	public static Tarefa getTarefaById(int id) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Tarefa tarefa = null;

		try {

			stmt = con.prepareStatement("SELECT * FROM tarefas WHERE id = ?");

			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {

				tarefa = new Tarefa();

				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setStatus(Status.getStatus(rs.getString("status")));
				tarefa.setValidade(MyDate.parseToComumFormat(rs.getDate("validade")));
				tarefa.setIdProjetoPertencente(rs.getInt("idProjetoPertencente"));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return tarefa;

	}

}
