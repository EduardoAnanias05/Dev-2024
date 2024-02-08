package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Model.Task;

public class JanelaPrincipal extends JFrame {
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
    private ToDoListPainel toDoListPainel;
 

    // construtor
    /**
     * 
     */
    public JanelaPrincipal() {
        // Configuração da janela principal
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);

        //Inicializa o ToDoListPainel
        toDoListPainel = new ToDoListPainel(); 

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
      
          // Adicona ToDoList ao mainpanel painel principal
          mainPanel.add(toDoListPainel, BorderLayout.CENTER);  

        // Add the main panel to the JFrame
        this.add(mainPanel);
    }

    public void run() {
        // Exibe a janela
        this.setVisible(true);
        JanelaPrincipal janela = new JanelaPrincipal();
        janela.run(); 
    } 


}