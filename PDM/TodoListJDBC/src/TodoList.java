import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;  
import java.awt.event.*; 


import javax.swing.*;

import Model.Task;

public class TodoList extends JFrame {
    // atributos

    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;
    private JButton detalhesButton;

    // construtor
    /**
     * 
     */
    public TodoList() {
        // Configuração da janela principal
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField(); // aonde vou escrever
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        detalhesButton = new JButton("Detalhes");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas",
                "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");
        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        buttonPanel.add(detalhesButton);
        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);
        // Configuração de Listener para os Eventos
        // tratamento de eventos da aplicação

        addButton.addActionListener(e -> { // usa o tratmento encurtado para adicionar ao botão o evento ja feito
            addTask();
        });

        deleteButton.addActionListener(e -> {
            deleteTask();
        });

        markDoneButton.addActionListener(e -> {
            markTaskDone();

        });

        filterComboBox.addActionListener(e -> {
            filterTasks();
        });

        clearCompletedButton.addActionListener(e -> {
            clearCompletedTasks();
        });


        detalhesButton.addActionListener(e -> {
            detalhesTask();

        }); 

        taskList.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteTask();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    markTaskDone();  
                    addTask(); 
                } 
            }
        });  

         taskInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                } 
            } 
            
        });  

         taskInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    detalhesTask();
                } 
            } 
            
        });  


       
    }


 
    // metodos

    // teste botoes dando funcionalidade

    private void addTask() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = taskInputField.getText().trim();// remove espaços vazios
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    private void deleteTask() {
        // Exclui a task selecionada da lista de tasks
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            tasks.remove(selectedIndex);
            updateTaskList();
        }
    }

    private void detalhesTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task selectedTask = tasks.get(selectedIndex);
         //   selectedTask.setDetails(JPanel.) 
    
            // Crie um diálogo (JDialog) para exibir e editar os detalhes da tarefa
            JDialog dialog = new JDialog(this, "Detalhes da Tarefa", true);
            dialog.setSize(400, 200);
    
            // Crie um painel para exibir e editar os detalhes da tarefa
            JPanel detalhesPanel = new JPanel();
            JLabel detalhesLabel = new JLabel("Detalhes da Tarefa: ");
            JTextArea detalhesTextArea = new JTextArea(selectedTask.getDetails(), 5, 30); // Use JTextArea para entrada de detalhes
            JScrollPane scrollPane = new JScrollPane(detalhesTextArea);
    
            detalhesPanel.add(detalhesLabel);
            detalhesPanel.add(scrollPane);
    
            // Botão para salvar os detalhes editados
            JButton saveButton = new JButton("Salvar");
            saveButton.addActionListener(e -> {
                String newDetails = detalhesTextArea.getText();
                selectedTask.setDetails(newDetails);
                dialog.dispose(); // Fecha o diálogo
            });
    
            detalhesPanel.add(saveButton);
    
            saveButton.addActionListener(e -> {
                String newDetails = detalhesTextArea.getText();
                selectedTask.setDetails(newDetails);
                detalhesLabel.setText("Detalhes da Tarefa: " + newDetails); // Atualiza o rótulo com os detalhes salvos
                dialog.dispose(); // Fecha o diálogo
            });
    
            dialog.add(detalhesPanel);
            dialog.setVisible(true);
        }
    }
    

    private void markTaskDone() {
        // Marca a task selecionada como concluída
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    private void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    private void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    private void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ?

                    " (Concluída)" : ""));

        }
    }

    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }
}
