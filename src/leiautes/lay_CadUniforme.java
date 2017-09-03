package leiautes;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

class lay_CadUniforme extends JInternalFrame{


    private Dimension       tamanho_tela;
    private lay_Consulta    consulta;
    private lay_Inicial     form_pai;
    private NumberFormat    format;
    private NumberFormat    format2;

    lay_CadUniforme(lay_Inicial formpai) {

        form_pai = formpai;
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

        // Configurando o leiauteunif para o panel do JFrame.
        Container painelunif = this.getContentPane();
        SpringLayout leiauteunif = new SpringLayout();
        painelunif.setLayout(leiauteunif);

        JLabel lbuniforme = new JLabel("Uniforme");
        painelunif.add(lbuniforme);
        leiauteunif.putConstraint(  SpringLayout.NORTH, lbuniforme, 10,
                                    SpringLayout.NORTH, painelunif);
        leiauteunif.putConstraint(  SpringLayout.WEST, lbuniforme, 10,
                                    SpringLayout.WEST, painelunif);

        JComboBox cbuniforme = new JComboBox();
        cbuniforme.setPreferredSize(new Dimension(300, 20));
        painelunif.add(cbuniforme);
        leiauteunif.putConstraint(  SpringLayout.NORTH, cbuniforme, 5,
                                    SpringLayout.SOUTH, lbuniforme);
        leiauteunif.putConstraint(  SpringLayout.WEST, cbuniforme, 0,
                                    SpringLayout.WEST, lbuniforme);

        JLabel lbtamanho = new JLabel("Tamanho");
        painelunif.add(lbtamanho);
        leiauteunif.putConstraint(  SpringLayout.BASELINE, lbtamanho, 0,
                                    SpringLayout.BASELINE, lbuniforme);
        leiauteunif.putConstraint(  SpringLayout.WEST, lbtamanho, 250,
                                    SpringLayout.EAST, lbuniforme);

        JComboBox cbtamanho = new JComboBox();
        cbtamanho.setPreferredSize(new Dimension(80, 20));
        painelunif.add(cbtamanho);
        leiauteunif.putConstraint(  SpringLayout.BASELINE, cbtamanho, 0,
                                    SpringLayout.BASELINE, cbuniforme);
        leiauteunif.putConstraint(  SpringLayout.WEST, cbtamanho, 0,
                                    SpringLayout.WEST, lbtamanho);

        JLabel lbvalor = new JLabel("Valor");
        painelunif.add(lbvalor);
        leiauteunif.putConstraint(  SpringLayout.NORTH, lbvalor, 10,
                                    SpringLayout.SOUTH, cbuniforme);
        leiauteunif.putConstraint(  SpringLayout.WEST, lbvalor, 0,
                                    SpringLayout.WEST, cbuniforme);

        JFormattedTextField tfvalor = new JFormattedTextField(new DefaultFormatterFactory(  new NumberFormatter(format),
                                                                                            new NumberFormatter(format),
                                                                                            new NumberFormatter(format2)));
        tfvalor.setHorizontalAlignment(0);
        tfvalor.setPreferredSize(new Dimension(150,19));
        painelunif.add(tfvalor);
        leiauteunif.putConstraint(  SpringLayout.NORTH, tfvalor, 5,
                                    SpringLayout.SOUTH, lbvalor);
        leiauteunif.putConstraint(  SpringLayout.WEST, tfvalor, 0,
                                    SpringLayout.WEST, lbvalor);

    }

    private void Inicaliza_Atributos(){

        tamanho_tela = new Dimension(450,200);
        format = NumberFormat.getCurrencyInstance();
        format.setMinimumFractionDigits(2);
        format2 = NumberFormat.getNumberInstance();

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
        form_pai.setCadUniforme();
    }
}
