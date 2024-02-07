package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Task;

public class TodoListDAO {
    private Connection connection;
    private List<Model.Task> tasks;

    public TodoListDAO() {
        this.connection = ConnectionFactory.getConnection();
        createTable(); // Adicione esta linha para criar a tabela durante a inicialização
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS tasks_table (DESCRIPTION VARCHAR(255), DONE BOOLEAN, DETAILS TEXT)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public List<Model.Task> getAllTasks() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        tasks = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM tasks_table");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Model.Task task = new Task(
                        rs.getString("DESCRIPTION"),
                        rs.getBoolean("DONE"),
                        rs.getString("DETAILS")
                );
                tasks.add(task);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return tasks;
    }

    public void addTask(Model.Task task) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO tasks_table (DESCRIPTION, DONE, DETAILS) VALUES (?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getDescription());
            stmt.setBoolean(2, task.isDone());
            stmt.setString(3, task.getDetails());
            stmt.executeUpdate();
            System.out.println("Task inserida com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir task no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void updateTask(Model.Task task) {
        PreparedStatement stmt = null;
        String sql = "UPDATE tasks_table SET DESCRIPTION = ?, DONE = ?, DETAILS = ? WHERE DESCRIPTION = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getDescription());
            stmt.setBoolean(2, task.isDone());
            stmt.setString(3, task.getDetails());
            stmt.setString(4, task.getDescription());
            stmt.executeUpdate();
            System.out.println("Task atualizada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar task no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void deleteTask(Model.Task task) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM tasks_table WHERE DESCRIPTION = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, task.getDescription());
            stmt.executeUpdate();
            System.out.println("Task apagada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar task no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
