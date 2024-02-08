package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

import Model.Task;

/**
 * TodoListDAO
 */
public class TodoListDAO {

    // atributo
    private Connection connection;
    private List<Task> tasks;

    public TodoListDAO() {
        this.connection = ConnectionFactory.getConnection();

    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS toDoList_JDBC (TAREFA VARCHAR(255),DETALHES VARCHAR(255), ID VARCHAR (255) PRIMARY KEY, CONCLUIDA VARCHAR(3) )"; // Procurar
        // qual melhor tipo de dados para o "ID"
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // criando metodos
    public void cadastrarTask(String tarefa, String detalhes, String id, String concluida) { // prepared classe do java que conecta com jdbc
        PreparedStatement stmt = null; // null = caso o progama falhe fecha a conexão

        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO toDoList_JDBC (tarefa, detalhes, id , concluida ) VALUES (?,?,?,?)"; // colocar instrução SQL (ele deixou copy and cole )
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, tarefa);
            stmt.setString(2, detalhes);
            stmt.setString(3, id);
            stmt.setString(4, concluida);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String id) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela id
        String sql = "DELETE FROM toDoList_JDBC WHERE id = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // uso list pois terei que no final retornara lista
    public List<Task> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        tasks = new ArrayList<>();
        // Cria uma lista para armazenar as task recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM toDoList_JDBC");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto task com os valores do
                // registro

                Task task = new Task(
                        rs.getString("tarefa"),
                        rs.getString("detalhes"),
                        rs.getString("id"),
                        rs.getString("concluida"));
                task.add(task);
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);// Fecha a conexão, o PreparedStatement e o
            // ResultSet
        }
        return tasks; // Retorna a lista de task recuperados do banco de dados
    }

}