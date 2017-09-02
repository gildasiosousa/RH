package leiautes;

import javax.swing.*;
import java.awt.*;

class lay_cadUniforme extends JInternalFrame{


    private Dimension tamanho_tela;

    lay_cadUniforme() {

        Inicaliza_Atributos();
        Constroe_Form();
    }

    private void Constroe_Form(){

        this.setTitle("Cadastro de Uniformes");
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
