package leiautes;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.*;

class lay_CadColaborador extends JInternalFrame {

    private Dimension       tamanho_tela;
    private Color           cor_fundo;
    private String[]        nomes_col;
    private Object          dados[][];
    private lay_Consulta    consulta;
    private lay_Inicial     form_pai;
    private MaskFormatter mascaraCep = null;
    private MaskFormatter mascaraTel = null;
    private MaskFormatter mascaraCpf = null;
    private MaskFormatter mascaraData = null;
    private MaskFormatter mascaraCel = null;

    lay_CadColaborador(lay_Inicial formpai) {

        form_pai = formpai;
        Inicaliza_Atributos();
        Constroe_Form();
    }

    private void Constroe_Form(){

        this.setTitle("Cadastro de Colaboradores");
        this.setResizable(false);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(tamanho_tela);
        this.setBackground(cor_fundo);

        this.setJMenuBar(Constroe_Menu());

        JTabbedPane tabPn = new JTabbedPane();
        tabPn.addTab("Dados Pessoais",Constroe_Leiaute1());
        tabPn.addTab("Dados Familiares",Constroe_Leiaute2());
        tabPn.addTab("Dados Contratuais",Constroe_Leiaute3());

        this.add(tabPn);

    }

    private JPanel Constroe_Leiaute1(){

        // Criação do painel Dados Pessoais
        JPanel painel_1 = new JPanel();
        painel_1.setBackground(Color.WHITE);
        SpringLayout leiaute_1 = new SpringLayout();
        painel_1.setLayout(leiaute_1);

        // Criação do campo Nome.
        JLabel lbnome = new JLabel("Nome Completo");
        painel_1.add(lbnome);
        leiaute_1.putConstraint(SpringLayout.WEST,lbnome,10,
                                SpringLayout.WEST,painel_1);
        leiaute_1.putConstraint(SpringLayout.NORTH,lbnome,10,
                                SpringLayout.NORTH,painel_1);

        JTextField tfnome = new JTextField(44);
        painel_1.add(tfnome);
        leiaute_1.putConstraint(SpringLayout.NORTH,tfnome,5,
                                SpringLayout.SOUTH,lbnome);
        leiaute_1.putConstraint(SpringLayout.WEST,tfnome,0,
                                SpringLayout.WEST,lbnome);

        // Criação do campo Data de Nascimento.
        JFormattedTextField tfdtanasc = new JFormattedTextField(mascaraData);
        tfdtanasc.setPreferredSize(new Dimension(115,20));
        tfdtanasc.setHorizontalAlignment(0);
        painel_1.add(tfdtanasc);
        leiaute_1.putConstraint(SpringLayout.WEST,tfdtanasc,10,
                                SpringLayout.EAST,tfnome);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfdtanasc,0,
                                SpringLayout.BASELINE,tfnome);

        JLabel lbdtanasc = new JLabel("Data Nasc.");
        painel_1.add(lbdtanasc);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbdtanasc,0,
                                SpringLayout.BASELINE,lbnome);
        leiaute_1.putConstraint(SpringLayout.WEST,lbdtanasc,0,
                                SpringLayout.WEST,tfdtanasc);

        // Criação do campo CPF.
        JLabel lbcpf = new JLabel("CPF");
        painel_1.add(lbcpf);
        leiaute_1.putConstraint(SpringLayout.NORTH,lbcpf,5,
                                SpringLayout.SOUTH,tfnome);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcpf,0,
                                SpringLayout.WEST,tfnome);

        JFormattedTextField tfcpf = new JFormattedTextField(mascaraCpf);
        tfcpf.setPreferredSize(new Dimension(140,20));
        tfcpf.setHorizontalAlignment(0);
        painel_1.add(tfcpf);
        leiaute_1.putConstraint(SpringLayout.WEST,tfcpf,0,
                                SpringLayout.WEST,lbcpf);
        leiaute_1.putConstraint(SpringLayout.NORTH,tfcpf,5,
                                SpringLayout.SOUTH,lbcpf);

        // Cração do campo RG.
        JLabel lbrg = new JLabel("RG");
        painel_1.add(lbrg);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbrg,0,
                                SpringLayout.BASELINE,lbcpf);
        leiaute_1.putConstraint(SpringLayout.WEST,lbrg,130,
                                SpringLayout.EAST,lbcpf);

        JTextField tfrg = new JTextField(12);
        tfrg.setHorizontalAlignment(0);
        painel_1.add(tfrg);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfrg,0,
                                SpringLayout.BASELINE,tfcpf);
        leiaute_1.putConstraint(SpringLayout.WEST,tfrg,0,
                                SpringLayout.WEST,lbrg);

        // Criação do campo CTPS (Carteira de Trabalho).
        JLabel lbctps = new JLabel("CTPS");
        painel_1.add(lbctps);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbctps,0,
                                SpringLayout.BASELINE,lbrg);
        leiaute_1.putConstraint(SpringLayout.WEST,lbctps,135,
                                SpringLayout.EAST,lbrg);

        JTextField tfctps = new JTextField(12);
        tfctps.setHorizontalAlignment(0);
        painel_1.add(tfctps);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfctps,0,
                                SpringLayout.BASELINE,tfrg);
        leiaute_1.putConstraint(SpringLayout.WEST,tfctps,0,
                                SpringLayout.WEST,lbctps);

        // Criação do campo Pis/Pasep.
        JLabel lbpis = new JLabel("Pis/Pasep");
        painel_1.add(lbpis);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbpis,0,
                                SpringLayout.BASELINE,lbctps);
        leiaute_1.putConstraint(SpringLayout.WEST,lbpis,120,
                                SpringLayout.EAST,lbctps);

        JTextField tfpis = new JTextField(13);
        tfpis.setHorizontalAlignment(0);
        painel_1.add(tfpis);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfpis,0,
                                SpringLayout.BASELINE,tfctps);
        leiaute_1.putConstraint(SpringLayout.WEST,tfpis,0,
                                SpringLayout.WEST,lbpis);

        // Criação do campo CNH (Carteira Nacional de Trabalho).
        JLabel lbcnh = new JLabel("CNH");
        painel_1.add(lbcnh);
        leiaute_1.putConstraint(SpringLayout.NORTH,lbcnh,5,
                                SpringLayout.SOUTH,tfcpf);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcnh,0,
                                SpringLayout.WEST,tfcpf);

        JTextField tfcnh = new JTextField(12);
        tfcnh.setHorizontalAlignment(0);
        painel_1.add(tfcnh);
        leiaute_1.putConstraint(SpringLayout.WEST,tfcnh,0,
                                SpringLayout.WEST,lbcnh);
        leiaute_1.putConstraint(SpringLayout.NORTH,tfcnh,5,
                                SpringLayout.SOUTH,lbcnh);

        // Grupo de categorias de CNH.
        JLabel lbcategcnh = new JLabel("Categorias");
        painel_1.add(lbcategcnh);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbcategcnh,0,
                                SpringLayout.BASELINE,lbcnh);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcategcnh,200,
                                SpringLayout.EAST,lbcnh);

        JCheckBox chcnh_a = new JCheckBox("A");
        painel_1.add(chcnh_a);
        leiaute_1.putConstraint(SpringLayout.BASELINE,chcnh_a,0,
                                SpringLayout.BASELINE,tfcnh);
        leiaute_1.putConstraint(SpringLayout.WEST,chcnh_a,20,
                                SpringLayout.EAST,tfcnh);

        JCheckBox chcnh_b = new JCheckBox("B");
        painel_1.add(chcnh_b);
        leiaute_1.putConstraint(SpringLayout.BASELINE,chcnh_b,0,
                                SpringLayout.BASELINE,chcnh_a);
        leiaute_1.putConstraint(SpringLayout.WEST,chcnh_b,20,
                                SpringLayout.EAST,chcnh_a);

        JCheckBox chcnh_c = new JCheckBox("C");
        painel_1.add(chcnh_c);
        leiaute_1.putConstraint(SpringLayout.BASELINE,chcnh_c,0,
                                SpringLayout.BASELINE,chcnh_b);
        leiaute_1.putConstraint(SpringLayout.WEST,chcnh_c,20,
                                SpringLayout.EAST,chcnh_b);

        JCheckBox chcnh_d = new JCheckBox("D");
        painel_1.add(chcnh_d);
        leiaute_1.putConstraint(SpringLayout.BASELINE,chcnh_d,0,
                                SpringLayout.BASELINE,chcnh_c);
        leiaute_1.putConstraint(SpringLayout.WEST,chcnh_d,20,
                                SpringLayout.EAST,chcnh_c);

        JCheckBox chcnh_e = new JCheckBox("E");
        painel_1.add(chcnh_e);
        leiaute_1.putConstraint(SpringLayout.BASELINE,chcnh_e,0,
                                SpringLayout.BASELINE,chcnh_d);
        leiaute_1.putConstraint(SpringLayout.WEST,chcnh_e,20,
                                SpringLayout.EAST,chcnh_d);

        // Criação do separador.
        JSeparator sepCadColab = new JSeparator(SwingConstants.HORIZONTAL);
        sepCadColab.setPreferredSize(new Dimension(tamanho_tela.width,1));
        painel_1.add(sepCadColab);
        leiaute_1.putConstraint(SpringLayout.NORTH,sepCadColab,10,
                                SpringLayout.SOUTH,chcnh_d);

        // Criação do campo Logradouro (rua, avenida,etc...).
        JLabel lblogradouro = new JLabel("Logradouro");
        painel_1.add(lblogradouro);
        leiaute_1.putConstraint(SpringLayout.NORTH,lblogradouro,10,
                                SpringLayout.SOUTH,sepCadColab);
        leiaute_1.putConstraint(SpringLayout.WEST,lblogradouro,10,
                                SpringLayout.WEST,painel_1);

        JTextField tflogradouro = new JTextField(25);
        painel_1.add(tflogradouro);
        leiaute_1.putConstraint(SpringLayout.NORTH,tflogradouro,5,
                                SpringLayout.SOUTH,lblogradouro);
        leiaute_1.putConstraint(SpringLayout.WEST,tflogradouro,0,
                                SpringLayout.WEST,lblogradouro);

        // Criação do campo Número (número da residência).
        JLabel lbnro = new JLabel("Número");
        painel_1.add(lbnro);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbnro,0,
                                SpringLayout.BASELINE,lblogradouro);
        leiaute_1.putConstraint(SpringLayout.WEST,lbnro,210,
                                SpringLayout.EAST,lblogradouro);

        JTextField tfnro = new JTextField(7);
        painel_1.add(tfnro);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfnro,0,
                                SpringLayout.BASELINE,tflogradouro);
        leiaute_1.putConstraint(SpringLayout.WEST,tfnro,0,
                                SpringLayout.WEST,lbnro);

        // Criação do campo Complemento (complemento de endereço).
        JLabel lbcomplemento = new JLabel("Complemento");
        painel_1.add(lbcomplemento);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbcomplemento,0,
                                SpringLayout.BASELINE,lbnro);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcomplemento,40,
                                SpringLayout.EAST,lbnro);

        JTextField tfcomplemento = new JTextField(20);
        painel_1.add(tfcomplemento);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfcomplemento,0,
                                SpringLayout.BASELINE,tfnro);
        leiaute_1.putConstraint(SpringLayout.WEST,tfcomplemento,0,
                                SpringLayout.WEST,lbcomplemento);

        // Criação do campo CEP.
        JLabel lbcep = new JLabel("CEP");
        painel_1.add(lbcep);
        leiaute_1.putConstraint(SpringLayout.NORTH,lbcep,5,
                                SpringLayout.SOUTH,tflogradouro);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcep,0,
                                SpringLayout.WEST,tflogradouro);

        JFormattedTextField tfcep = new JFormattedTextField(mascaraCep);
        tfcep.setHorizontalAlignment(0);
        tfcep.setPreferredSize(new Dimension(115,19));
        painel_1.add(tfcep);
        leiaute_1.putConstraint(SpringLayout.NORTH,tfcep,5,
                                SpringLayout.SOUTH,lbcep);
        leiaute_1.putConstraint(SpringLayout.WEST,tfcep,0,
                                SpringLayout.WEST,lbcep);

        // Criação do campo Bairro.
        JLabel lbbairro = new JLabel("Bairro");
        painel_1.add(lbbairro);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbbairro,0,
                                SpringLayout.BASELINE,lbcep);
        leiaute_1.putConstraint(SpringLayout.WEST,lbbairro,100,
                                SpringLayout.EAST,lbcep);

        JTextField tfbairro = new JTextField(18);
        painel_1.add(tfbairro);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfbairro,0,
                                SpringLayout.BASELINE,tfcep);
        leiaute_1.putConstraint(SpringLayout.WEST,tfbairro,0,
                                SpringLayout.WEST,lbbairro);

        // Criação do campo Cidade.
        JLabel lbcidade= new JLabel("Cidade");
        painel_1.add(lbcidade);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbcidade,0,
                                SpringLayout.BASELINE,lbbairro);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcidade,170,
                                SpringLayout.EAST,lbbairro);

        JComboBox cbcidade = new JComboBox();
        cbcidade.setPreferredSize(new Dimension(185, 19));
        painel_1.add(cbcidade);
        leiaute_1.putConstraint(SpringLayout.BASELINE,cbcidade,0,
                                SpringLayout.BASELINE,tfbairro);
        leiaute_1.putConstraint(SpringLayout.WEST,cbcidade,0,
                                SpringLayout.WEST,lbcidade);

        // Criação do campo Estado.
        JLabel lbestado = new JLabel("Estado");
        painel_1.add(lbestado);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbestado,0,
                                SpringLayout.BASELINE,lbcidade);
        leiaute_1.putConstraint(SpringLayout.WEST,lbestado,150,
                                SpringLayout.EAST,lbcidade);

        JComboBox cbestado = new JComboBox();
        cbestado.setPreferredSize(new Dimension(70, 19));
        painel_1.add(cbestado);
        leiaute_1.putConstraint(SpringLayout.BASELINE,cbestado,0,
                                SpringLayout.BASELINE,cbcidade);
        leiaute_1.putConstraint(SpringLayout.WEST,cbestado,0,
                                SpringLayout.WEST,lbestado);

        // Criação do separador.
        JSeparator sepCadColab2 = new JSeparator(SwingConstants.HORIZONTAL);
        sepCadColab2.setPreferredSize(new Dimension(tamanho_tela.width,1));
        painel_1.add(sepCadColab2);
        leiaute_1.putConstraint(SpringLayout.NORTH,sepCadColab2,15,
                                SpringLayout.SOUTH,tfcep);

        // Criação do campo Telefone Principal.
        JLabel lbtelefone_1 = new JLabel("Telefone Principal");
        painel_1.add(lbtelefone_1);
        leiaute_1.putConstraint(SpringLayout.NORTH,lbtelefone_1,10,
                                SpringLayout.SOUTH,sepCadColab2);
        leiaute_1.putConstraint(SpringLayout.WEST,lbtelefone_1,10,
                                SpringLayout.WEST,painel_1);

        JFormattedTextField tftelefone_1 = new JFormattedTextField(mascaraTel);
        tftelefone_1.setHorizontalAlignment(0);
        tftelefone_1.setPreferredSize(new Dimension(125,19));
        painel_1.add(tftelefone_1);
        leiaute_1.putConstraint(SpringLayout.NORTH,tftelefone_1,5,
                                SpringLayout.SOUTH,lbtelefone_1);
        leiaute_1.putConstraint(SpringLayout.WEST,tftelefone_1,0,
                                SpringLayout.WEST,lbtelefone_1);

        // Criação do campo Telefone Reserva.
        JLabel lbtelefone_2 = new JLabel("Telefone Reserva");
        painel_1.add(lbtelefone_2);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbtelefone_2,0,
                                SpringLayout.BASELINE,lbtelefone_1);
        leiaute_1.putConstraint(SpringLayout.WEST,lbtelefone_2,40,
                                SpringLayout.EAST,lbtelefone_1);

        JFormattedTextField tftelefone_2 = new JFormattedTextField(mascaraTel);
        tftelefone_2.setHorizontalAlignment(0);
        tftelefone_2.setPreferredSize(new Dimension(125,19));
        painel_1.add(tftelefone_2);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tftelefone_2,0,
                                SpringLayout.BASELINE,tftelefone_1);
        leiaute_1.putConstraint(SpringLayout.WEST,tftelefone_2,0,
                                SpringLayout.WEST,lbtelefone_2);

        // Criação do campo Celular Principal.
        JLabel lbcelular_1 = new JLabel("Celular Principal");
        painel_1.add(lbcelular_1);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbcelular_1,0,
                                SpringLayout.BASELINE,lbtelefone_2);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcelular_1,40,
                                SpringLayout.EAST,lbtelefone_2);

        JFormattedTextField tfcelular_1 = new JFormattedTextField(mascaraCel);
        tfcelular_1.setHorizontalAlignment(0);
        tfcelular_1.setPreferredSize(new Dimension(125,19));
        painel_1.add(tfcelular_1);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfcelular_1,0,
                                SpringLayout.BASELINE,tftelefone_2);
        leiaute_1.putConstraint(SpringLayout.WEST,tfcelular_1,0,
                                SpringLayout.WEST,lbcelular_1);

        // Criação do campo Celular Reserva.
        JLabel lbcelular_2 = new JLabel("Celular Reserva");
        painel_1.add(lbcelular_2);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbcelular_2,0,
                                SpringLayout.BASELINE,lbcelular_1);
        leiaute_1.putConstraint(SpringLayout.WEST,lbcelular_2,40,
                                SpringLayout.EAST,lbcelular_1);

        JFormattedTextField tfcelular_2 = new JFormattedTextField(mascaraCel);
        tfcelular_2.setHorizontalAlignment(0);
        tfcelular_2.setPreferredSize(new Dimension(125,19));
        painel_1.add(tfcelular_2);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfcelular_2,0,
                                SpringLayout.BASELINE,tfcelular_1);
        leiaute_1.putConstraint(SpringLayout.WEST,tfcelular_2,0,
                                SpringLayout.WEST,lbcelular_2);

        // Criação do campo Email Principal.
        JLabel lbemail_1 = new JLabel("Email Principal");
        painel_1.add(lbemail_1);
        leiaute_1.putConstraint(SpringLayout.NORTH,lbemail_1,5,
                                SpringLayout.SOUTH,tftelefone_1);
        leiaute_1.putConstraint(SpringLayout.WEST,lbemail_1,0,
                                SpringLayout.WEST,tftelefone_1);

        JTextField tfemail_1 = new JTextField(26);
        painel_1.add(tfemail_1);
        leiaute_1.putConstraint(SpringLayout.NORTH,tfemail_1,5,
                                SpringLayout.SOUTH,lbemail_1);
        leiaute_1.putConstraint(SpringLayout.WEST,tfemail_1,0,
                                SpringLayout.WEST,lbemail_1);

        // Criação do campo Email Reserva.
        JLabel lbemail_2 = new JLabel("Email Reserva");
        painel_1.add(lbemail_2);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbemail_2,0,
                                SpringLayout.BASELINE,lbemail_1);
        leiaute_1.putConstraint(SpringLayout.WEST,lbemail_2,220,
                                SpringLayout.EAST,lbemail_1);

        JTextField tfemail_2 = new JTextField(26);
        painel_1.add(tfemail_2);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfemail_2,0,
                                SpringLayout.BASELINE,tfemail_1);
        leiaute_1.putConstraint(SpringLayout.WEST,tfemail_2,0,
                                SpringLayout.WEST,lbemail_2);


        TrataCampos_Painel1(tfnome, tfrg, tfctps, tfpis, tfcnh,
                            chcnh_b, chcnh_c, chcnh_d, chcnh_e, tflogradouro,
                            tfbairro);

        return painel_1;
    }

    private JPanel Constroe_Leiaute2(){

        // Criação do painel Dados Familiares
        JPanel painel_2 = new JPanel();
        painel_2.setBackground(Color.WHITE);
        SpringLayout leiaute_2 = new SpringLayout();
        painel_2.setLayout(leiaute_2);

        // Criação do campo Nome da Mãe.
        JLabel lbnomemae = new JLabel("Nome da Mãe");
        painel_2.add(lbnomemae);
        leiaute_2.putConstraint(SpringLayout.WEST,lbnomemae,10,
                                SpringLayout.WEST,painel_2);
        leiaute_2.putConstraint(SpringLayout.NORTH,lbnomemae,10,
                                SpringLayout.NORTH,painel_2);

        JTextField tfnomemae = new JTextField(55);
        painel_2.add(tfnomemae);
        leiaute_2.putConstraint(SpringLayout.WEST,tfnomemae,0,
                                SpringLayout.WEST,lbnomemae);
        leiaute_2.putConstraint(SpringLayout.NORTH,tfnomemae,5,
                                SpringLayout.SOUTH,lbnomemae);

        // Criação do campo Nome do Conjugê.
        JLabel lbnomeconjuge = new JLabel("Nome do Conjugê");
        painel_2.add(lbnomeconjuge);
        leiaute_2.putConstraint(SpringLayout.WEST,lbnomeconjuge,0,
                                SpringLayout.WEST,tfnomemae);
        leiaute_2.putConstraint(SpringLayout.NORTH,lbnomeconjuge,10,
                                SpringLayout.SOUTH,tfnomemae);

        JTextField tfnomeconjuge = new JTextField(43);
        painel_2.add(tfnomeconjuge);
        leiaute_2.putConstraint(SpringLayout.WEST,tfnomeconjuge,0,
                                SpringLayout.WEST,lbnomeconjuge);
        leiaute_2.putConstraint(SpringLayout.NORTH,tfnomeconjuge,5,
                                SpringLayout.SOUTH,lbnomeconjuge);

        // Criação do campo Data de Nasc. (do conjugê)
        JLabel lbdtanascconjuge = new JLabel("Data Nasc.");
        painel_2.add(lbdtanascconjuge);
        leiaute_2.putConstraint(SpringLayout.BASELINE,lbdtanascconjuge,0,
                                SpringLayout.BASELINE,lbnomeconjuge);
        leiaute_2.putConstraint(SpringLayout.WEST,lbdtanascconjuge,370,
                                SpringLayout.EAST,lbnomeconjuge);

        JFormattedTextField tfdtanascconsjuge = new JFormattedTextField(mascaraData);
        tfdtanascconsjuge.setHorizontalAlignment(0);
        tfdtanascconsjuge.setPreferredSize(new Dimension(115, 19));
        painel_2.add(tfdtanascconsjuge);
        leiaute_2.putConstraint(SpringLayout.BASELINE,tfdtanascconsjuge,0,
                                SpringLayout.BASELINE,tfnomeconjuge);
        leiaute_2.putConstraint(SpringLayout.WEST,tfdtanascconsjuge,0,
                                SpringLayout.WEST,lbdtanascconjuge);

        // Criação da tabela para inserir os dados dos filhos.
        JLabel lbnomefilhos = new JLabel("Filhos");
        painel_2.add(lbnomefilhos);
        leiaute_2.putConstraint(SpringLayout.WEST,lbnomefilhos,0,
                                SpringLayout.WEST,tfnomeconjuge);
        leiaute_2.putConstraint(SpringLayout.NORTH,lbnomefilhos,10,
                                SpringLayout.SOUTH,tfnomeconjuge);

        // Criação da tabela utilizando o construtor para definir os nomes das colunas.
        JTable tbfilhos = new JTable(new DefaultTableModel(dados,nomes_col));
        tbfilhos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        // Definindo o tamanho de uma das colunas.
        TableColumn colnome = tbfilhos.getColumnModel().getColumn(0);
        colnome.setResizable(false);
        colnome.setPreferredWidth(380);

        // Criando o Scrollpanel onde a tabela ficará.
        JScrollPane scpfilhos = new JScrollPane(tbfilhos);
        scpfilhos.setPreferredSize(new Dimension(530,200));
        painel_2.add(scpfilhos);
        leiaute_2.putConstraint(SpringLayout.WEST,scpfilhos,0,
                                SpringLayout.WEST,lbnomefilhos);
        leiaute_2.putConstraint(SpringLayout.NORTH,scpfilhos,5,
                                SpringLayout.SOUTH,lbnomefilhos);

        // Criação dos botões para inserir e excluir linhas da tabela.
        JButton btaddfilho = new JButton("Novo");
        btaddfilho.setSize(new Dimension(10,10));
        painel_2.add(btaddfilho);
        leiaute_2.putConstraint(SpringLayout.WEST,btaddfilho,7,
                                SpringLayout.EAST,scpfilhos);
        leiaute_2.putConstraint(SpringLayout.NORTH,btaddfilho,0,
                                SpringLayout.NORTH,scpfilhos);

        JButton btExcluifilho = new JButton("Del");
        painel_2.add(btExcluifilho);
        leiaute_2.putConstraint(SpringLayout.WEST,btExcluifilho,0,
                                SpringLayout.WEST,btaddfilho);
        leiaute_2.putConstraint(SpringLayout.EAST,btExcluifilho,0,
                                SpringLayout.EAST,btaddfilho);
        leiaute_2.putConstraint(SpringLayout.NORTH,btExcluifilho,5,
                                SpringLayout.SOUTH,btaddfilho);

        TrataCampos_Painel2(tfnomemae, tfnomeconjuge, tbfilhos, btaddfilho, btExcluifilho);

        // Retornando o JPanel criado e populado.
        return painel_2;

    }

    private JPanel Constroe_Leiaute3(){

        // Criação do painel Dados Contratuais.
        JPanel painel_3 = new JPanel();
        painel_3.setBackground(Color.WHITE);
        SpringLayout leiaute_3 = new SpringLayout();
        painel_3.setLayout(leiaute_3);

        // Criação do combobox empresa.
        JLabel lbEmpresa = new JLabel("Empresa Contratante");
        painel_3.add(lbEmpresa);
        leiaute_3.putConstraint(SpringLayout.WEST,lbEmpresa,10,
                                SpringLayout.WEST,painel_3);
        leiaute_3.putConstraint(SpringLayout.NORTH,lbEmpresa,10,
                                SpringLayout.NORTH,painel_3);

        JComboBox cbempresa = new JComboBox();
        cbempresa.setPreferredSize(new Dimension(300, 20));
        painel_3.add(cbempresa);
        leiaute_3.putConstraint(SpringLayout.WEST,cbempresa,0,
                                SpringLayout.WEST,lbEmpresa);
        leiaute_3.putConstraint(SpringLayout.NORTH,cbempresa,5,
                                SpringLayout.SOUTH,lbEmpresa);

        //Criação do combobox Cargo.
        JLabel lbcargo = new JLabel("Função/Cargo");
        painel_3.add(lbcargo);
        leiaute_3.putConstraint(SpringLayout.BASELINE,lbcargo,0,
                                SpringLayout.BASELINE,lbEmpresa);
        leiaute_3.putConstraint(SpringLayout.WEST,lbcargo,160,
                                SpringLayout.EAST,lbEmpresa);

        JComboBox cbcargo = new JComboBox();
        cbcargo.setPreferredSize(new Dimension(300, 20));
        painel_3.add(cbcargo);
        leiaute_3.putConstraint(SpringLayout.BASELINE,cbcargo,0,
                                SpringLayout.BASELINE,cbempresa);
        leiaute_3.putConstraint(SpringLayout.WEST,cbcargo,0,
                                SpringLayout.WEST,lbcargo);

        // Criação do campo Data de Admissão.
        JLabel lbdtaadmissao = new JLabel("Data Admissão");
        painel_3.add(lbdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.NORTH,lbdtaadmissao,10,
                                SpringLayout.SOUTH,cbempresa);
        leiaute_3.putConstraint(SpringLayout.WEST,lbdtaadmissao,0,
                                SpringLayout.WEST,cbempresa);

        JFormattedTextField tfdtaadmissao = new JFormattedTextField(mascaraData);
        tfdtaadmissao.setHorizontalAlignment(0);
        tfdtaadmissao.setPreferredSize(new Dimension(110,19));
        painel_3.add(tfdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.NORTH,tfdtaadmissao,5,
                                SpringLayout.SOUTH,lbdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.WEST,tfdtaadmissao,0,
                                SpringLayout.WEST,lbdtaadmissao);

        // Criação do campo data de Demissão.
        JLabel lbdtademissao = new JLabel("Data Demissão");
        painel_3.add(lbdtademissao);
        leiaute_3.putConstraint(SpringLayout.BASELINE,lbdtademissao,0,
                                SpringLayout.BASELINE,lbdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.WEST,lbdtademissao,20,
                                SpringLayout.EAST,lbdtaadmissao);

        JFormattedTextField tfdtademissao = new JFormattedTextField(mascaraData);
        tfdtademissao.setHorizontalAlignment(0);
        tfdtademissao.setPreferredSize(new Dimension(110,19));
        painel_3.add(tfdtademissao);
        leiaute_3.putConstraint(SpringLayout.BASELINE,tfdtademissao,0,
                                SpringLayout.BASELINE,tfdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.WEST,tfdtademissao,0,
                                SpringLayout.WEST,lbdtademissao);

        // Criação do campo Salário.
        JLabel lbsalario = new JLabel("Salário");
        painel_3.add(lbsalario);
        leiaute_3.putConstraint(SpringLayout.BASELINE,lbsalario,0,
                                SpringLayout.BASELINE,lbdtademissao);
        leiaute_3.putConstraint(SpringLayout.WEST,lbsalario,20,
                                SpringLayout.EAST,lbdtademissao);

        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMinimumFractionDigits(2);
        NumberFormat format2 = NumberFormat.getNumberInstance();
        JFormattedTextField tfsalario = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(format),
                                                                                            new NumberFormatter(format),
                                                                                            new NumberFormatter(format2)));
        tfsalario.setHorizontalAlignment(0);
        tfsalario.setPreferredSize(new Dimension(150,19));
        painel_3.add(tfsalario);
        leiaute_3.putConstraint(SpringLayout.BASELINE,tfsalario,0,
                                SpringLayout.BASELINE,tfdtademissao);
        leiaute_3.putConstraint(SpringLayout.WEST,tfsalario,0,
                                SpringLayout.WEST,lbsalario);

        // Criação do separador.
        JSeparator sepCadColab_3 = new JSeparator(SwingConstants.HORIZONTAL);
        sepCadColab_3.setPreferredSize(new Dimension(tamanho_tela.width,1));
        painel_3.add(sepCadColab_3);
        leiaute_3.putConstraint(SpringLayout.NORTH,sepCadColab_3,10,
                                SpringLayout.SOUTH,tfdtaadmissao);

        // Criação das opções de benefícios.
        JLabel lbbeneficios = new JLabel("Benefícios");
        painel_3.add(lbbeneficios);
        leiaute_3.putConstraint(SpringLayout.NORTH, lbbeneficios, 10,
                                SpringLayout.SOUTH, sepCadColab_3);
        leiaute_3.putConstraint(SpringLayout.WEST, lbbeneficios, 10,
                                SpringLayout.WEST, painel_3);

        JCheckBox chvaletransp = new JCheckBox("Vale Transporte");
        painel_3.add(chvaletransp);
        leiaute_3.putConstraint(SpringLayout.NORTH, chvaletransp, 5,
                                SpringLayout.SOUTH, lbbeneficios);
        leiaute_3.putConstraint(SpringLayout.WEST, chvaletransp, 0,
                                SpringLayout.WEST, lbbeneficios);

        JCheckBox chplanosaude = new JCheckBox("Plano de Saúde");
        painel_3.add(chplanosaude);
        leiaute_3.putConstraint(SpringLayout.BASELINE, chplanosaude, 0,
                                SpringLayout.BASELINE, chvaletransp);
        leiaute_3.putConstraint(SpringLayout.WEST, chplanosaude, 20,
                                SpringLayout.EAST, chvaletransp);

        JCheckBox chplanoodonto = new JCheckBox("Plano Odontológico");
        painel_3.add(chplanoodonto);
        leiaute_3.putConstraint(SpringLayout.BASELINE, chplanoodonto, 0,
                                SpringLayout.BASELINE, chplanosaude);
        leiaute_3.putConstraint(SpringLayout.WEST, chplanoodonto, 20,
                                SpringLayout.EAST, chplanosaude);

        // Criação do separador.
        JSeparator sepCadColab_4 = new JSeparator(SwingConstants.HORIZONTAL);
        sepCadColab_4.setPreferredSize(new Dimension(tamanho_tela.width,1));
        painel_3.add(sepCadColab_4);
        leiaute_3.putConstraint(SpringLayout.NORTH,sepCadColab_4,10,
                                SpringLayout.SOUTH,chvaletransp);

        // Criação da area de dados bancários.
        JLabel lbdadosbancarios = new JLabel("Dados Bancários");
        painel_3.add(lbdadosbancarios);
        leiaute_3.putConstraint(SpringLayout.NORTH, lbdadosbancarios, 10,
                                SpringLayout.SOUTH, sepCadColab_4);
        leiaute_3.putConstraint(SpringLayout.WEST, lbdadosbancarios, 10,
                                SpringLayout.WEST, painel_3);

        JLabel lbbanco = new JLabel("Banco");
        painel_3.add(lbbanco);
        leiaute_3.putConstraint(SpringLayout.NORTH, lbbanco, 10,
                                SpringLayout.SOUTH, lbdadosbancarios);
        leiaute_3.putConstraint(SpringLayout.WEST, lbbanco, 0,
                                SpringLayout.WEST, lbdadosbancarios);

        JComboBox cbbanco = new JComboBox();
        cbbanco.setPreferredSize(new Dimension(200, 20));
        painel_3.add(cbbanco);
        leiaute_3.putConstraint(SpringLayout.NORTH,cbbanco,5,
                                SpringLayout.SOUTH,lbbanco);
        leiaute_3.putConstraint(SpringLayout.WEST,cbbanco,0,
                                SpringLayout.WEST,lbbanco);

        JLabel lbagencia = new JLabel("Agência");
        painel_3.add(lbagencia);
        leiaute_3.putConstraint(SpringLayout.BASELINE, lbagencia, 0,
                                SpringLayout.BASELINE, lbbanco);
        leiaute_3.putConstraint(SpringLayout.WEST, lbagencia, 180,
                                SpringLayout.EAST, lbbanco);

        JTextField tfagencia = new JTextField(10);
        painel_3.add(tfagencia);
        leiaute_3.putConstraint(SpringLayout.BASELINE, tfagencia, 0,
                                SpringLayout.BASELINE, cbbanco);
        leiaute_3.putConstraint(SpringLayout.WEST, tfagencia, 0,
                                SpringLayout.WEST, lbagencia);

        JLabel lboperacao = new JLabel("Op.");
        painel_3.add(lboperacao);
        leiaute_3.putConstraint(SpringLayout.BASELINE, lboperacao, 0,
                                SpringLayout.BASELINE, lbagencia);
        leiaute_3.putConstraint(SpringLayout.WEST, lboperacao, 70,
                                SpringLayout.EAST, lbagencia);

        JTextField tfoperacao = new JTextField(2);
        painel_3.add(tfoperacao);
        leiaute_3.putConstraint(SpringLayout.BASELINE, tfoperacao, 0,
                                SpringLayout.BASELINE, tfagencia);
        leiaute_3.putConstraint(SpringLayout.WEST, tfoperacao, 0,
                                SpringLayout.WEST, lboperacao);

        JLabel lbconta = new JLabel("Conta");
        painel_3.add(lbconta);
        leiaute_3.putConstraint(SpringLayout.BASELINE, lbconta, 0,
                                SpringLayout.BASELINE, lboperacao);
        leiaute_3.putConstraint(SpringLayout.WEST, lbconta, 15,
                                SpringLayout.EAST, lboperacao);

        JTextField tfconta = new JTextField(19);
        painel_3.add(tfconta);
        leiaute_3.putConstraint(SpringLayout.BASELINE, tfconta, 0,
                                SpringLayout.BASELINE, tfoperacao);
        leiaute_3.putConstraint(SpringLayout.WEST, tfconta, 0,
                                SpringLayout.WEST, lbconta);

        // Criação do campo de adiantamento.
        JLabel lbvalor = new JLabel("Valor");
        painel_3.add(lbvalor);
        leiaute_3.putConstraint(SpringLayout.NORTH, lbvalor, 10,
                                SpringLayout.SOUTH, cbbanco);
        leiaute_3.putConstraint(SpringLayout.WEST, lbvalor, 0,
                                SpringLayout.WEST, cbbanco);

        JFormattedTextField tfvalor = new JFormattedTextField(new DefaultFormatterFactory(new NumberFormatter(format),
                                                                                          new NumberFormatter(format),
                                                                                          new NumberFormatter(format2)));
        tfvalor.setHorizontalAlignment(0);
        tfvalor.setPreferredSize(new Dimension(150,19));
        tfvalor.setEnabled(false);
        painel_3.add(tfvalor);
        leiaute_3.putConstraint(SpringLayout.NORTH, tfvalor, 5,
                                SpringLayout.SOUTH, lbvalor);
        leiaute_3.putConstraint(SpringLayout.WEST, tfvalor, 0,
                                SpringLayout.WEST, lbvalor);

        JCheckBox chadiantamento = new JCheckBox("Adiantamento");
        painel_3.add(chadiantamento);
        leiaute_3.putConstraint(SpringLayout.BASELINE, chadiantamento, 0,
                                SpringLayout.BASELINE, tfvalor);
        leiaute_3.putConstraint(SpringLayout.WEST, chadiantamento, 20,
                                SpringLayout.EAST, tfvalor);

        TrataCampos_Painel3(tfagencia, tfoperacao, tfconta, chadiantamento, tfvalor);

        // Retorna o panel populado.
        return painel_3;
    }

    private void Inicaliza_Atributos(){

        tamanho_tela = new Dimension(650,450);
        cor_fundo    = new Color(230,230,230);
        nomes_col    = new String[]{"Nome","Data Nasc."};
        dados        = new Object[][]{{null,null}};

        //Define as máscaras
        try{
            mascaraCep = new MaskFormatter("#####-###");
            mascaraTel = new MaskFormatter("(##)####-####");
            mascaraCel = new MaskFormatter("(##)#####-####");
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraData = new MaskFormatter("##/##/####");
            mascaraCep.setPlaceholderCharacter('_');
            mascaraTel.setPlaceholderCharacter('_');
            mascaraCel.setPlaceholderCharacter('_');
            mascaraCpf.setPlaceholderCharacter('_');
            mascaraData.setPlaceholderCharacter('_');
        }
        catch(ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
            System.exit(-1);
        }

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

    private void TrataSoNumeros(JTextField campo, String tipo){

        if(tipo.equals("rg")){

            campo.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!((c >= '0') && (c <= '9') ||
                            (c == 'x') || (c == 'X') ||
                            (c == KeyEvent.VK_BACK_SPACE) ||
                            (c == KeyEvent.VK_DELETE))) {
                        getToolkit().beep();
                        e.consume();
                    }
                }
            });

        }else{

            campo.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!((c >= '0') && (c <= '9') ||
                            (c == KeyEvent.VK_BACK_SPACE) ||
                            (c == KeyEvent.VK_DELETE))) {
                        getToolkit().beep();
                        e.consume();
                    }
                }
            });

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

    private void TrataCampos_Painel1(JTextField tfnome, JTextField tfrg,JTextField tfctps,JTextField tfpis,
                                     JTextField tfcnh, JCheckBox chcnhb,JCheckBox chcnhc, JCheckBox chcnhd,
                                     JCheckBox chcnhe, JTextField tflogradouro, JTextField tfbairro){

        TrataSoNumeros(tfrg,"rg");

        TrataSoNumeros(tfctps,"");

        TrataSoNumeros(tfpis,"");

        TrataSoNumeros(tfcnh,"");

        TrataSoLetras(tfnome);

        TrataSoLetras(tflogradouro);

        TrataSoLetras(tfbairro);

        chcnhb.addActionListener(actionEvent -> {
            if(chcnhb.isSelected()){
                chcnhc.setSelected(false);
                chcnhd.setSelected(false);
                chcnhe.setSelected(false);
            }
        });

        chcnhc.addActionListener(actionEvent -> {
            if(chcnhc.isSelected()){
                chcnhb.setSelected(false);
                chcnhd.setSelected(false);
                chcnhe.setSelected(false);
            }
        });

        chcnhd.addActionListener(actionEvent -> {
            if(chcnhd.isSelected()){
                chcnhb.setSelected(false);
                chcnhc.setSelected(false);
                chcnhe.setSelected(false);
            }
        });

        chcnhe.addActionListener(actionEvent -> {
            if(chcnhe.isSelected()){
                chcnhb.setSelected(false);
                chcnhc.setSelected(false);
                chcnhd.setSelected(false);
            }
        });


    }

    private void TrataCampos_Painel2(JTextField tfnomemae,JTextField tfnomeconjuge, JTable tbfilhos,
                                     JButton btaddfilho, JButton btExcluifilho){

        TrataSoLetras(tfnomemae);

        TrataSoLetras(tfnomeconjuge);

        btaddfilho.addActionListener(actionEvent -> {
            DefaultTableModel model = (DefaultTableModel) tbfilhos.getModel();
            model.addRow(new Object[]{null,null});
        });

        btExcluifilho.addActionListener(actionEvent -> {
            DefaultTableModel model = (DefaultTableModel) tbfilhos.getModel();
            model.removeRow(tbfilhos.getSelectedRow());
        });

    }

    private void TrataCampos_Painel3(JTextField tfagencia, JTextField tfoperacao, JTextField tfconta,
                                     JCheckBox chadiantamento, JFormattedTextField tfvalor){

        TrataSoNumeros(tfagencia, "");

        TrataSoNumeros(tfoperacao, "");

        TrataSoNumeros(tfconta, "");

        chadiantamento.addActionListener(actionEvent -> {

            if(chadiantamento.isSelected()){
                tfvalor.setEnabled(true);
            }else{
                tfvalor.setValue(null);
                tfvalor.setEnabled(false);
            }

        });

    }

    @Override
    public void dispose() {
        super.dispose();
        form_pai.setCadColaborador();
    }

}
