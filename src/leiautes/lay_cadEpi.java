package leiautes;

import Controle.Componentes.RTexto;
import Controle.Componentes.RTextoFormat;

import javax.swing.*;
import java.awt.*;

class lay_cadEpi extends JInternalFrame{

    private Dimension tamanho_tela;

    lay_cadEpi() {

        Inicaliza_Atributos();
        Constroe_Form();
    }

    private void Constroe_Form(){

        this.setTitle("Cadastro de EPI");
        this.setResizable(false);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(tamanho_tela);

        this.setJMenuBar(Constroe_Menu());

        Constroe_Leiauteepi();

    }

    private void Constroe_Leiauteepi(){

        // Configurando o leiauteepi para o panel do JFrame.
        Container painelepi = this.getContentPane();
        SpringLayout leiauteepi = new SpringLayout();
        painelepi.setLayout(leiauteepi);

        JLabel lbepi = new JLabel("EPI");
        painelepi.add(lbepi);
        leiauteepi.putConstraint(   SpringLayout.NORTH, lbepi, 10,
                                    SpringLayout.NORTH, painelepi);
        leiauteepi.putConstraint(   SpringLayout.WEST, lbepi, 10,
                                    SpringLayout.WEST, painelepi);

        JComboBox cbepi = new JComboBox();
        cbepi.setPreferredSize(new Dimension(300, 20));
        painelepi.add(cbepi);
        leiauteepi.putConstraint(   SpringLayout.NORTH, cbepi, 5,
                                    SpringLayout.SOUTH, lbepi);
        leiauteepi.putConstraint(   SpringLayout.WEST, cbepi, 0,
                                    SpringLayout.WEST, lbepi);

        JLabel lbtamanho = new JLabel("Tamanho");
        painelepi.add(lbtamanho);
        leiauteepi.putConstraint(   SpringLayout.BASELINE, lbtamanho, 0,
                                    SpringLayout.BASELINE, lbepi);
        leiauteepi.putConstraint(   SpringLayout.WEST, lbtamanho, 300,
                                    SpringLayout.EAST, lbepi);

        JComboBox cbtamanho = new JComboBox();
        cbtamanho.setPreferredSize(new Dimension(80, 20));
        painelepi.add(cbtamanho);
        leiauteepi.putConstraint(   SpringLayout.BASELINE, cbtamanho, 0,
                                    SpringLayout.BASELINE, cbepi);
        leiauteepi.putConstraint(   SpringLayout.WEST, cbtamanho, 0,
                                    SpringLayout.WEST, lbtamanho);

        JLabel lbca = new JLabel("CA");
        painelepi.add(lbca);
        leiauteepi.putConstraint(   SpringLayout.NORTH, lbca, 10,
                                    SpringLayout.SOUTH, cbepi);
        leiauteepi.putConstraint(   SpringLayout.WEST, lbca, 0,
                                    SpringLayout.WEST, cbepi);

        RTexto tfca = new RTexto(10);
        painelepi.add(tfca);
        leiauteepi.putConstraint(   SpringLayout.NORTH, tfca, 5,
                                    SpringLayout.SOUTH, lbca);
        leiauteepi.putConstraint(   SpringLayout.WEST, tfca, 0,
                                    SpringLayout.WEST, lbca);

        JLabel lbvalor = new JLabel("Valor");
        painelepi.add(lbvalor);
        leiauteepi.putConstraint(  SpringLayout.BASELINE, lbvalor, 0,
                                SpringLayout.BASELINE, lbca);
        leiauteepi.putConstraint(  SpringLayout.WEST, lbvalor, 110,
                                SpringLayout.EAST, lbca);

        RTextoFormat tfvalor = new RTextoFormat(10);
        painelepi.add(tfvalor);
        leiauteepi.putConstraint(  SpringLayout.BASELINE, tfvalor, 0,
                                SpringLayout.BASELINE, tfca);
        leiauteepi.putConstraint(  SpringLayout.WEST, tfvalor, 0,
                                SpringLayout.WEST, lbvalor);

    }

    private void Inicaliza_Atributos(){

        tamanho_tela = new Dimension(450,200);

    }

    private JMenuBar Constroe_Menu(){

        JMenuBar mnbar = new JMenuBar();
        JMenu mnnovo = new JMenu("Novo");
        JMenu mnsalvar = new JMenu("Salvar");
        mnbar.add(mnnovo);
        mnbar.add(mnsalvar);

        return mnbar;

    }

}
