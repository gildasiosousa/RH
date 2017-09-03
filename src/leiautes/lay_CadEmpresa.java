package leiautes;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

class lay_CadEmpresa extends JInternalFrame{

    private Dimension       tamanho_tela;
    private lay_Consulta    consulta;
    private lay_Inicial     form_pai;
    private MaskFormatter   mascaracnpj;
    private MaskFormatter   mascaraCep;

    lay_CadEmpresa(lay_Inicial formpai) {

        form_pai = formpai;
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

        JTextField tfrazaosocial = new JTextField(28);
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

        JTextField tfnomefantasia = new JTextField(25);
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

        JFormattedTextField tfcnpj = new JFormattedTextField(mascaracnpj);
        tfcnpj.setHorizontalAlignment(0);
        tfcnpj.setPreferredSize(new Dimension(180,19));
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
        leiaute.putConstraint(  SpringLayout.NORTH,lblogradouro,10,
                                SpringLayout.SOUTH,sepCadColab);
        leiaute.putConstraint(  SpringLayout.WEST,lblogradouro,10,
                                SpringLayout.WEST,painel);

        JTextField tflogradouro = new JTextField(25);
        painel.add(tflogradouro);
        leiaute.putConstraint(  SpringLayout.NORTH,tflogradouro,5,
                                SpringLayout.SOUTH,lblogradouro);
        leiaute.putConstraint(  SpringLayout.WEST,tflogradouro,0,
                                SpringLayout.WEST,lblogradouro);

        // Criação do campo Número (número da residência).
        JLabel lbnro = new JLabel("Número");
        painel.add(lbnro);
        leiaute.putConstraint(SpringLayout.BASELINE,lbnro,0,
                SpringLayout.BASELINE,lblogradouro);
        leiaute.putConstraint(SpringLayout.WEST,lbnro,210,
                SpringLayout.EAST,lblogradouro);

        JTextField tfnro = new JTextField(7);
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

        JTextField tfcomplemento = new JTextField(20);
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

        JFormattedTextField tfcep = new JFormattedTextField(mascaraCep);
        tfcep.setHorizontalAlignment(0);
        tfcep.setPreferredSize(new Dimension(115,19));
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

        JTextField tfbairro = new JTextField(18);
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

        JComboBox cbcidade = new JComboBox();
        cbcidade.setPreferredSize(new Dimension(185, 19));
        painel.add(cbcidade);
        leiaute.putConstraint(SpringLayout.BASELINE,cbcidade,0,
                SpringLayout.BASELINE,tfbairro);
        leiaute.putConstraint(SpringLayout.WEST,cbcidade,0,
                SpringLayout.WEST,lbcidade);

        // Criação do campo Estado.
        JLabel lbestado = new JLabel("Estado");
        painel.add(lbestado);
        leiaute.putConstraint(SpringLayout.BASELINE,lbestado,0,
                SpringLayout.BASELINE,lbcidade);
        leiaute.putConstraint(SpringLayout.WEST,lbestado,150,
                SpringLayout.EAST,lbcidade);

        JComboBox cbestado = new JComboBox();
        cbestado.setPreferredSize(new Dimension(70, 19));
        painel.add(cbestado);
        leiaute.putConstraint(SpringLayout.BASELINE,cbestado,0,
                SpringLayout.BASELINE,cbcidade);
        leiaute.putConstraint(SpringLayout.WEST,cbestado,0,
                SpringLayout.WEST,lbestado);

        Trata_Campos(tflogradouro, tfbairro);

    }

    private void Inicaliza_Atributos(){

        tamanho_tela = new Dimension(650,300);
        //Define as máscaras
        try{
            mascaracnpj = new MaskFormatter("##.###.###/####-##");
            mascaraCep  = new MaskFormatter("#####-###");
            mascaracnpj.setPlaceholderCharacter('_');
            mascaraCep.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }

    }

    private void TrataSoLetras(JTextField campo){

        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c >= '0') && (c <= '9')) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });

    }

    private void Trata_Campos(JTextField tflogradouro, JTextField tfbairro){

        TrataSoLetras(tflogradouro);

        TrataSoLetras(tfbairro);

    }

    private JMenuBar Constroe_Menu(){

        JMenuBar mnbar = new JMenuBar();
        JMenu mnnovo = new JMenu("Novo");
        JMenu mnsalvar = new JMenu("Salvar");
        JMenu mnconsulta = new JMenu("Consultar");
        mnconsulta.addActionListener(ActiveEvent -> {

            if(consulta == null){

                consulta = new lay_Consulta();
                consulta.setVisible(true);

            }else{

                consulta.moveToFront();

            }

        });
        mnbar.add(mnnovo);
        mnbar.add(mnsalvar);
        mnbar.add(mnconsulta);

        return mnbar;

    }

    @Override
    public void dispose() {
        super.dispose();
        form_pai.setCadEmpresa();
    }
}
