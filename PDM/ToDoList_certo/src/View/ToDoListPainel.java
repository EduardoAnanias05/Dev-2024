package View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.*;

import Model.Task;

public class ToDoListPainel extends JPanel { 

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
    
     // Configuração do painel de entrada 

     public ToDoListPainel(){ 
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
     
        } 

      
    }