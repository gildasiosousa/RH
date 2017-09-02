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

        Constroe_Leiaute();

    }

    private void Constroe_Leiaute(){

        // Configurando o leiaute para o panel do JFrame.
        Container painel = this.getContentPane();
        SpringLayout leiaute = new SpringLayout();
        painel.setLayout(leiaute);

        JLabel lbepi = new JLabel("EPI");
        painel.add(lbepi);
        leiaute.putConstraint(  SpringLayout.NORTH, lbepi, 10,
                                SpringLayout.SOUTH, painel);
        leiaute.putConstraint(  SpringLayout.WEST, lbepi, 10,
                                SpringLayout.WEST, painel);

        JComboBox cbepi = new JComboBox();
        cbepi.setPreferredSize(new Dimension(50, 20));
        painel.add(cbepi);
        leiaute.putConstraint(  SpringLayout.NORTH, cbepi, 5,
                                SpringLayout.SOUTH, lbepi);
        leiaute.putConstraint(  SpringLayout.WEST, cbepi, 0,
                                SpringLayout.WEST, painel);

        JLabel lbtamanho = new JLabel("Tamanho");
        painel.add(lbtamanho);
        leiaute.putConstraint(  SpringLayout.BASELINE, lbtamanho, 0,
                                SpringLayout.BASELINE, lbepi);
        leiaute.putConstraint(  SpringLayout.WEST, lbtamanho, 50,
                                SpringLayout.EAST, lbepi);

        JComboBox cbtamanho = new JComboBox();
        cbtamanho.setPreferredSize(new Dimension(50, 20));
        painel.add(cbtamanho);
        leiaute.putConstraint(  SpringLayout.BASELINE, cbtamanho, 0,
                                SpringLayout.BASELINE, cbepi);
        leiaute.putConstraint(  SpringLayout.WEST, cbtamanho, 0,
                                SpringLayout.WEST, lbtamanho);

        JLabel lbca = new JLabel("CA");
        painel.add(lbca);
        leiaute.putConstraint(  SpringLayout.NORTH, lbca, 10,
                                SpringLayout.SOUTH, cbepi);
        leiaute.putConstraint(  SpringLayout.WEST, lbca, 0,
                                SpringLayout.WEST, cbepi);

        RTexto tfca = new RTexto(10);
        painel.add(tfca);
        leiaute.putConstraint(  SpringLayout.NORTH, tfca, 5,
                                SpringLayout.SOUTH, lbca);
        leiaute.putConstraint(  SpringLayout.WEST, tfca, 0,
                                SpringLayout.WEST, lbca);

        JLabel lbvalor = new JLabel("Valor");
        painel.add(lbvalor);
        leiaute.putConstraint(  SpringLayout.BASELINE, lbvalor, 0,
                                SpringLayout.BASELINE, lbca);
        leiaute.putConstraint(  SpringLayout.WEST, lbvalor, 50,
                                SpringLayout.EAST, lbca);

        RTextoFormat tfvalor = new RTextoFormat(10);
        painel.add(tfvalor);
        leiaute.putConstraint(  SpringLayout.BASELINE, tfvalor, 5,
                                SpringLayout.BASELINE, tfca);
        leiaute.putConstraint(  SpringLayout.WEST, tfvalor, 0,
                                SpringLayout.WEST, lbvalor);

    }

    private void Inicaliza_Atributos(){

        tamanho_tela = new Dimension(650,300);

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
