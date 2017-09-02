package leiautes;

import Controle.Componentes.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class lay_CadColaborador extends JInternalFrame {

    private Dimension tamanho_tela;
    private Color     cor_fundo;
    private String[]  nomes_col;
    private Object    dados[][];

    public lay_CadColaborador() {

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

        RTexto tfnome = new RTexto(44);
        painel_1.add(tfnome);
        leiaute_1.putConstraint(SpringLayout.NORTH,tfnome,5,
                                SpringLayout.SOUTH,lbnome);
        leiaute_1.putConstraint(SpringLayout.WEST,tfnome,0,
                                SpringLayout.WEST,lbnome);

        // Criação do campo Data de Nascimento.
        RDataHora tfdtanasc = new RDataHora(10);
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

        RTextoFormat tfcpf = new RTextoFormat(12);
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

        RTextoFormat tfrg = new RTextoFormat(12);
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

        RTextoFormat tfctps = new RTextoFormat(12);
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

        RTextoFormat tfpis = new RTextoFormat(13);
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

        RTextoFormat tfcnh = new RTextoFormat(12);
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

        RTexto tflogradouro = new RTexto(25);
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

        RNumerico tfnro = new RNumerico(7);
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

        RTexto tfcomplemento = new RTexto(20);
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

        RTextoFormat tfcep = new RTextoFormat(10);
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

        RTexto tfbairro = new RTexto(18);
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

        RTexto tfcidade = new RTexto(19);
        painel_1.add(tfcidade);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfcidade,0,
                                SpringLayout.BASELINE,tfbairro);
        leiaute_1.putConstraint(SpringLayout.WEST,tfcidade,0,
                                SpringLayout.WEST,lbcidade);

        // Criação do campo Estado.
        JLabel lbestado = new JLabel("Estado");
        painel_1.add(lbestado);
        leiaute_1.putConstraint(SpringLayout.BASELINE,lbestado,0,
                                SpringLayout.BASELINE,lbcidade);
        leiaute_1.putConstraint(SpringLayout.WEST,lbestado,175,
                                SpringLayout.EAST,lbcidade);

        RTexto tfestado = new RTexto(4);
        painel_1.add(tfestado);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfestado,0,
                                SpringLayout.BASELINE,tfcidade);
        leiaute_1.putConstraint(SpringLayout.WEST,tfestado,0,
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

        RTextoFormat tftelefone_1 = new RTextoFormat(11);
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

        RTextoFormat tftelefone_2 = new RTextoFormat(11);
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

        RTextoFormat tfcelular_1 = new RTextoFormat(11);
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

        RTextoFormat tfcelular_2 = new RTextoFormat(11);
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

        RTextoFormat tfemail_1 = new RTextoFormat(26);
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

        RTextoFormat tfemail_2 = new RTextoFormat(26);
        painel_1.add(tfemail_2);
        leiaute_1.putConstraint(SpringLayout.BASELINE,tfemail_2,0,
                                SpringLayout.BASELINE,tfemail_1);
        leiaute_1.putConstraint(SpringLayout.WEST,tfemail_2,0,
                                SpringLayout.WEST,lbemail_2);


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

        RTexto tfnomemae = new RTexto(55);
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

        RTexto tfnomeconjuge = new RTexto(43);
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

        RDataHora tfdtanascconsjuge = new RDataHora(10);
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
        JTable tbfilhos = new JTable(dados,nomes_col);
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

        // Retornando o JPanel criado e populado.
        return painel_2;

    }

    private JPanel Constroe_Leiaute3(){

        // Criação do painel Dados Contratuais.
        JPanel painel_3 = new JPanel();
        painel_3.setBackground(Color.WHITE);
        SpringLayout leiaute_3 = new SpringLayout();
        painel_3.setLayout(leiaute_3);

        JLabel lbEmpresa = new JLabel("Empresa Contratante");
        painel_3.add(lbEmpresa);
        leiaute_3.putConstraint(SpringLayout.WEST,lbEmpresa,10,
                                SpringLayout.WEST,painel_3);
        leiaute_3.putConstraint(SpringLayout.NORTH,lbEmpresa,10,
                                SpringLayout.NORTH,painel_3);

        JComboBox cbempresa = new JComboBox();
        painel_3.add(cbempresa);
        leiaute_3.putConstraint(SpringLayout.WEST,cbempresa,0,
                                SpringLayout.WEST,lbEmpresa);
        leiaute_3.putConstraint(SpringLayout.NORTH,cbempresa,5,
                                SpringLayout.SOUTH,lbEmpresa);

        JLabel lbcargo = new JLabel("Função/Cargo");
        painel_3.add(lbcargo);
        leiaute_3.putConstraint(SpringLayout.BASELINE,lbcargo,0,
                                SpringLayout.BASELINE,lbEmpresa);
        leiaute_3.putConstraint(SpringLayout.WEST,lbcargo,50,
                                SpringLayout.EAST,lbEmpresa);

        JComboBox cbcargo = new JComboBox();
        painel_3.add(cbcargo);
        leiaute_3.putConstraint(SpringLayout.BASELINE,cbcargo,0,
                                SpringLayout.BASELINE,cbempresa);
        leiaute_3.putConstraint(SpringLayout.WEST,cbcargo,0,
                                SpringLayout.WEST,lbcargo);

        JLabel lbdtaadmissao = new JLabel("Data de Admissão");
        painel_3.add(lbdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.NORTH,lbdtaadmissao,10,
                                SpringLayout.SOUTH,cbempresa);
        leiaute_3.putConstraint(SpringLayout.WEST,lbdtaadmissao,0,
                                SpringLayout.WEST,cbempresa);

        RDataHora tfdtaadmissao = new RDataHora(10);
        painel_3.add(tfdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.NORTH,tfdtaadmissao,5,
                                SpringLayout.SOUTH,lbdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.WEST,tfdtaadmissao,0,
                                SpringLayout.WEST,lbdtaadmissao);

        JLabel lbdtademissao = new JLabel("Data de Demissão");
        painel_3.add(lbdtademissao);
        leiaute_3.putConstraint(SpringLayout.BASELINE,lbdtademissao,0,
                                SpringLayout.BASELINE,lbdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.WEST,lbdtademissao,50,
                                SpringLayout.EAST,lbdtaadmissao);

        RDataHora tfdtademissao = new RDataHora(10);
        painel_3.add(tfdtademissao);
        leiaute_3.putConstraint(SpringLayout.BASELINE,tfdtademissao,0,
                                SpringLayout.BASELINE,tfdtaadmissao);
        leiaute_3.putConstraint(SpringLayout.WEST,tfdtademissao,0,
                                SpringLayout.WEST,lbdtademissao);

        JLabel lbsalario = new JLabel("Salário");
        painel_3.add(lbsalario);
        leiaute_3.putConstraint(SpringLayout.BASELINE,lbsalario,0,
                                SpringLayout.BASELINE,lbdtademissao);
        leiaute_3.putConstraint(SpringLayout.WEST,lbsalario,50,
                                SpringLayout.EAST,lbdtademissao);

        RNumerico tfsalario = new RNumerico(10);
        painel_3.add(tfsalario);
        leiaute_3.putConstraint(SpringLayout.BASELINE,tfsalario,0,
                                SpringLayout.BASELINE,tfdtademissao);
        leiaute_3.putConstraint(SpringLayout.WEST,tfsalario,0,
                                SpringLayout.WEST,lbsalario);

        return painel_3;
    }

    private void Inicaliza_Atributos(){

        tamanho_tela = new Dimension(650,450);
        cor_fundo    = new Color(230,230,230);
        nomes_col    = new String[]{"Nome","Data Nasc."};
        dados        = new Object[][]{{null,null}};

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
