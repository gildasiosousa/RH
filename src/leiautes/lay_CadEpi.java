package leiautes;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

class lay_CadEpi extends JInternalFrame{

    private Dimension       tamanho_tela;
    private lay_Consulta    consulta;
    private lay_Inicial     form_pai;
    private NumberFormat    format;
    private NumberFormat    format2;

    lay_CadEpi(lay_Inicial formpai) {

        form_pai = formpai;
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

        JTextField tfca = new JTextField(10);
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

        JFormattedTextField tfvalor = new JFormattedTextField(new DefaultFormatterFactory(  new NumberFormatter(format),
                                                                                            new NumberFormatter(format),
                                                                                            new NumberFormatter(format2)));
        tfvalor.setHorizontalAlignment(0);
        tfvalor.setPreferredSize(new Dimension(150,19));
        painelepi.add(tfvalor);
        leiauteepi.putConstraint(  SpringLayout.BASELINE, tfvalor, 0,
                                SpringLayout.BASELINE, tfca);
        leiauteepi.putConstraint(  SpringLayout.WEST, tfvalor, 0,
                                SpringLayout.WEST, lbvalor);

        Trata_Campos(tfca);

    }

    private void Inicaliza_Atributos(){

        tamanho_tela = new Dimension(450,200);
        format = NumberFormat.getCurrencyInstance();
        format.setMinimumFractionDigits(2);
        format2 = NumberFormat.getNumberInstance();

    }

    private void TrataSoNumeros(JTextField campo){

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

    private void Trata_Campos(JTextField tfca){

        TrataSoNumeros(tfca);

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
        form_pai.setCadEpi();
    }
}
