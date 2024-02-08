package View;

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
    
        // construtor
        /**
         * 
         */
        public JanelaPrincipal() {
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
            this.add(mainPanel); } 
        
            public void run() {
                // Exibe a janela
                this.setVisible(true);
            }
        }
        