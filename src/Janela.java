import java.awt.Dimension;

import javax.swing.*;
import javax.swing.JMenuBar;

public class Janela extends JFrame {
    public Janela() {
        this.setSize(500, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Controle de Acesso");

        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);


        JMenu menuArquivo = new JMenu("Arquivo");
        menubar.add(menuArquivo);


        JMenuItem itemNovo = new JMenuItem("Novo");

        menuArquivo.add(itemNovo);
    }

}
