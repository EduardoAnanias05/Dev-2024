package View;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Detalhes {
    Dimension d = new Dimension(100, 100);
    public Detalhes() {
        super();
        JPanel painelDetalhes = new JPanel();
        painelDetalhes.setVisible(true);
        painelDetalhes.setPreferredSize(d);
        
    }
}
