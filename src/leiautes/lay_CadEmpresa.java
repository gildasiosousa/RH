package leiautes;

import Controle.Componentes.RDataHora;
import Controle.Componentes.RNumerico;
import Controle.Componentes.RTexto;
import Controle.Componentes.RTextoFormat;

import javax.swing.*;
import java.awt.*;

class lay_CadEmpresa extends JInternalFrame{

    private Dimension tamanho_tela;

    lay_CadEmpresa() {

        Inicaliza_Atributos();
        Constroe_Form();
    }

    private void Constroe_Form(){

        this.setTitle("Cadastro de Empresas");
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

        // Criação do campo Razão Social.
        JLabel lbrazaosocial = new JLabel("Razão Social");
        painel.add(lbrazaosocial);
        leiaute.putConstraint(  SpringLayout.WEST,lbrazaosocial,10,
                                SpringLayout.WEST,painel);
        leiaute.putConstraint(  SpringLayout.NORTH,lbrazaosocial,10,
                                SpringLayout.NORTH,painel);

        RTexto tfrazaosocial = new RTexto(28);
        painel.add(tfrazaosocial);
        leiaute.putConstraint(  SpringLayout.WEST,tfrazaosocial,0,
                                SpringLayout.WEST,lbrazaosocial);
        leiaute.putConstraint(  SpringLayout.NORTH,tfrazaosocial,5,
                                SpringLayout.SOUTH,lbrazaosocial);

        // Criação do campo Nome Fantasia.
        JLabel lbnomefantasia = new JLabel("Nome Fantasia");
        painel.add(lbnomefantasia);
        leiaute.putConstraint(  SpringLayout.WEST,lbnomefantasia,240,
                                SpringLayout.EAST,lbrazaosocial);
        leiaute.putConstraint(  SpringLayout.BASELINE,lbnomefantasia,0,
                                SpringLayout.BASELINE,lbrazaosocial);

        RTexto tfnomefantasia = new RTexto(25);
        painel.add(tfnomefantasia);
        leiaute.putConstraint(  SpringLayout.WEST,tfnomefantasia,0,
                                SpringLayout.WEST,lbnomefantasia);
        leiaute.putConstraint(  SpringLayout.BASELINE,tfnomefantasia,0,
                                SpringLayout.BASELINE,tfrazaosocial);

        // Criação do campo CNPJ.
        JLabel lbcnpj = new JLabel("CNPJ");
        painel.add(lbcnpj);
        leiaute.putConstraint(  SpringLayout.WEST,lbcnpj,0,
                                SpringLayout.WEST,tfrazaosocial);
        leiaute.putConstraint(  SpringLayout.NORTH,lbcnpj,10,
                                SpringLayout.SOUTH,tfrazaosocial);

        RTextoFormat tfcnpj = new RTextoFormat(15);
        painel.add(tfcnpj);
        leiaute.putConstraint(  SpringLayout.WEST,tfcnpj,0,
                                SpringLayout.WEST,lbcnpj);
        leiaute.putConstraint(  SpringLayout.NORTH,tfcnpj,5,
                                SpringLayout.SOUTH,lbcnpj);

        // Criação do separador.
        JSeparator sepCadColab = new JSeparator(SwingConstants.HORIZONTAL);
        sepCadColab.setPreferredSize(new Dimension(tamanho_tela.width,1));
        painel.add(sepCadColab);
        leiaute.putConstraint(  SpringLayout.NORTH,sepCadColab,10,
                                SpringLayout.SOUTH,tfcnpj);

        // Criação do campo Logradouro (rua, avenida,etc...).
        JLabel lblogradouro = new JLabel("Logradouro");
        painel.add(lblogradouro);
        leiaute.putConstraint(SpringLayout.NORTH,lblogradouro,10,
                SpringLayout.SOUTH,sepCadColab);
        leiaute.putConstraint(SpringLayout.WEST,lblogradouro,10,
                SpringLayout.WEST,painel);

        RTexto tflogradouro = new RTexto(25);
        painel.add(tflogradouro);
        leiaute.putConstraint(SpringLayout.NORTH,tflogradouro,5,
                SpringLayout.SOUTH,lblogradouro);
        leiaute.putConstraint(SpringLayout.WEST,tflogradouro,0,
                SpringLayout.WEST,lblogradouro);

        // Criação do campo Número (número da residência).
        JLabel lbnro = new JLabel("Número");
        painel.add(lbnro);
        leiaute.putConstraint(SpringLayout.BASELINE,lbnro,0,
                SpringLayout.BASELINE,lblogradouro);
        leiaute.putConstraint(SpringLayout.WEST,lbnro,210,
                SpringLayout.EAST,lblogradouro);

        RNumerico tfnro = new RNumerico(7);
        painel.add(tfnro);
        leiaute.putConstraint(SpringLayout.BASELINE,tfnro,0,
                SpringLayout.BASELINE,tflogradouro);
        leiaute.putConstraint(SpringLayout.WEST,tfnro,0,
                SpringLayout.WEST,lbnro);

        // Criação do campo Complemento (complemento de endereço).
        JLabel lbcomplemento = new JLabel("Complemento");
        painel.add(lbcomplemento);
        leiaute.putConstraint(SpringLayout.BASELINE,lbcomplemento,0,
                SpringLayout.BASELINE,lbnro);
        leiaute.putConstraint(SpringLayout.WEST,lbcomplemento,40,
                SpringLayout.EAST,lbnro);

        RTexto tfcomplemento = new RTexto(20);
        painel.add(tfcomplemento);
        leiaute.putConstraint(SpringLayout.BASELINE,tfcomplemento,0,
                SpringLayout.BASELINE,tfnro);
        leiaute.putConstraint(SpringLayout.WEST,tfcomplemento,0,
                SpringLayout.WEST,lbcomplemento);

        // Criação do campo CEP.
        JLabel lbcep = new JLabel("CEP");
        painel.add(lbcep);
        leiaute.putConstraint(SpringLayout.NORTH,lbcep,5,
                SpringLayout.SOUTH,tflogradouro);
        leiaute.putConstraint(SpringLayout.WEST,lbcep,0,
                SpringLayout.WEST,tflogradouro);

        RTextoFormat tfcep = new RTextoFormat(10);
        painel.add(tfcep);
        leiaute.putConstraint(SpringLayout.NORTH,tfcep,5,
                SpringLayout.SOUTH,lbcep);
        leiaute.putConstraint(SpringLayout.WEST,tfcep,0,
                SpringLayout.WEST,lbcep);

        // Criação do campo Bairro.
        JLabel lbbairro = new JLabel("Bairro");
        painel.add(lbbairro);
        leiaute.putConstraint(SpringLayout.BASELINE,lbbairro,0,
                SpringLayout.BASELINE,lbcep);
        leiaute.putConstraint(SpringLayout.WEST,lbbairro,100,
                SpringLayout.EAST,lbcep);

        RTexto tfbairro = new RTexto(18);
        painel.add(tfbairro);
        leiaute.putConstraint(SpringLayout.BASELINE,tfbairro,0,
                SpringLayout.BASELINE,tfcep);
        leiaute.putConstraint(SpringLayout.WEST,tfbairro,0,
                SpringLayout.WEST,lbbairro);

        // Criação do campo Cidade.
        JLabel lbcidade= new JLabel("Cidade");
        painel.add(lbcidade);
        leiaute.putConstraint(SpringLayout.BASELINE,lbcidade,0,
                SpringLayout.BASELINE,lbbairro);
        leiaute.putConstraint(SpringLayout.WEST,lbcidade,170,
                SpringLayout.EAST,lbbairro);

        RTexto tfcidade = new RTexto(19);
        painel.add(tfcidade);
        leiaute.putConstraint(SpringLayout.BASELINE,tfcidade,0,
                SpringLayout.BASELINE,tfbairro);
        leiaute.putConstraint(SpringLayout.WEST,tfcidade,0,
                SpringLayout.WEST,lbcidade);

        // Criação do campo Estado.
        JLabel lbestado = new JLabel("Estado");
        painel.add(lbestado);
        leiaute.putConstraint(SpringLayout.BASELINE,lbestado,0,
                SpringLayout.BASELINE,lbcidade);
        leiaute.putConstraint(SpringLayout.WEST,lbestado,175,
                SpringLayout.EAST,lbcidade);

        RTexto tfestado = new RTexto(4);
        painel.add(tfestado);
        leiaute.putConstraint(SpringLayout.BASELINE,tfestado,0,
                SpringLayout.BASELINE,tfcidade);
        leiaute.putConstraint(SpringLayout.WEST,tfestado,0,
                SpringLayout.WEST,lbestado);

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
