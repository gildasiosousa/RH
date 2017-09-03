package leiautes;

// Importação das bibliotecas
import javax.swing.*;
import java.awt.*;

public class lay_Inicial extends JFrame {

    // Declaração dos atributos globais
    private Font    fonte_menu;
    private Font    fonte_menu_item;
    private Color   cor_menuBar;
    private Color   cor_fundo_tela;
    private Dimension  tamanho_tela;
    private JDesktopPane desktop;
    private lay_CadColaborador cadColaborador;
    private lay_CadEmpresa cadEmpresa;
    private lay_CadEpi cadEpi;
    private lay_CadUniforme cadUniforme;

    // Método Construtor
    public lay_Inicial() {

        Inicializa_Atributos();
        Constroe_Form();

    }

    // Método responsável por construir o formulário.
    private void Constroe_Form(){

        // Configurações do formulário.
        this.setTitle("RH - Software de Soluções em Recursos Humanos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize((int)(tamanho_tela.width*0.92),(int)(tamanho_tela.height*0.92));
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);

        // Atribuindo o modo Desktop (MDI) ao formulário.
        Container painel = this.getContentPane();
        desktop = new JDesktopPane();
        desktop.setBackground(cor_fundo_tela);
        painel.add(desktop);

        // Inclusão da barra de menu.
        this.setJMenuBar(Constroe_Menu());

    }

    // Método de criação da barra de menu.
    private JMenuBar Constroe_Menu(){

        // Criação da barra para o menu.
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(cor_menuBar);

        // Criação dos botões menu nível I.
        JMenu menuCad = new JMenu("Cadastro");
        menuCad.setFont(fonte_menu);

        JMenu menuLanc = new JMenu("Lançamento");
        menuLanc.setFont(fonte_menu);

        JMenu menuRel = new JMenu("Relatório");
        menuRel.setFont(fonte_menu);

        JMenu menuComp = new JMenu("Compartilhamento");
        menuComp.setFont(fonte_menu);


        // Criação dos botões menu nível II.
        JMenuItem mnCadColaborador  = new JMenuItem("Colaborador");
        mnCadColaborador.setFont(fonte_menu_item);
        mnCadColaborador.addActionListener(ActionEvent -> {

            if (cadColaborador == null){

                cadColaborador = new lay_CadColaborador(this);
                this.desktop.add(cadColaborador);
                cadColaborador.setVisible(true);

            }else{

                desktop.moveToFront(cadColaborador);
            }

        });

        JMenuItem mnCadEmpresa      = new JMenuItem("Empresa");
        mnCadEmpresa.setFont(fonte_menu_item);
        mnCadEmpresa.addActionListener(ActiveEvent -> {

            if(cadEmpresa == null){

                cadEmpresa = new lay_CadEmpresa(this);
                this.desktop.add(cadEmpresa);
                cadEmpresa.setVisible(true);

            }else{

                desktop.moveToFront(cadEmpresa);

            }

        });

        JMenuItem mnCadEpi  = new JMenuItem("EPI");
        mnCadEpi.setFont(fonte_menu_item);
        mnCadEpi.addActionListener(ActiveEvent -> {

            if(cadEpi == null){

                cadEpi = new lay_CadEpi(this);
                this.desktop.add(cadEpi);
                cadEpi.setVisible(true);

            }else{

                desktop.moveToFront(cadEpi);

            }

        });

        JMenuItem mnCadUniforme = new JMenuItem("Uniforme");
        mnCadUniforme.setFont(fonte_menu_item);
        mnCadUniforme.addActionListener(ActiveEvent -> {

            if(cadUniforme == null){

                cadUniforme = new lay_CadUniforme(this);
                this.desktop.add(cadUniforme);
                cadUniforme.setVisible(true);

            }else{

                desktop.moveToFront(cadUniforme);

            }

        });

        JMenuItem mnLancFerias      = new JMenuItem("Férias");
        mnLancFerias.setFont(fonte_menu_item);

        JMenuItem mnLancEpi         = new JMenuItem("EPI");
        mnLancEpi.setFont(fonte_menu_item);

        JMenuItem mnLancUniforme    = new JMenuItem("Uniforme");
        mnLancUniforme.setFont(fonte_menu_item);

        JMenu mnLancBenefico    = new JMenu("Benefício");
        mnLancBenefico.setFont(fonte_menu_item);

        JMenu mnLancDocument    = new JMenu("Documentação");
        mnLancDocument.setFont(fonte_menu_item);

        JMenu mnLancTreinamento = new JMenu("Treinamento");
        mnLancTreinamento.setFont(fonte_menu_item);

        JMenuItem mnCompImport  = new JMenuItem("Importar                   ");
        mnCompImport.setFont(fonte_menu_item);

        JMenuItem mnCompExport  = new JMenuItem("Exportar                   ");
        mnCompExport.setFont(fonte_menu_item);


        // Criação dos botões menu nível III.
        JMenuItem mnLancValeTransp    = new JMenuItem("Vale Transporte");
        mnLancValeTransp.setFont(fonte_menu_item);

        JMenuItem mnLancSegVida       = new JMenuItem("Seguro de Vida");
        mnLancSegVida.setFont(fonte_menu_item);

        JMenuItem mnLancPlanoSaude    = new JMenuItem("Plano de Saúde");
        mnLancPlanoSaude.setFont(fonte_menu_item);

        JMenuItem mnLancPlanoOdonto   = new JMenuItem("Plano Odontológico");
        mnLancPlanoOdonto.setFont(fonte_menu_item);

        JMenuItem mnLancASO   = new JMenuItem("ASO");
        mnLancASO.setFont(fonte_menu_item);

        JMenuItem mnLancPPRA  = new JMenuItem("PPRA");
        mnLancPPRA.setFont(fonte_menu_item);

        JMenuItem mnLancPCMSO = new JMenuItem("PCMSO");
        mnLancPCMSO.setFont(fonte_menu_item);

        JMenuItem mnLancInterno = new JMenuItem("Interno");
        mnLancInterno.setFont(fonte_menu_item);

        JMenuItem mnLancExterno = new JMenuItem("Externo");
        mnLancExterno.setFont(fonte_menu_item);

        // Adição dos menus aos seus respectivos pais.
        menuCad.add(mnCadColaborador);
        menuCad.add(mnCadEmpresa);
        menuCad.add(mnCadEpi);
        menuCad.add(mnCadUniforme);

        mnLancBenefico.add(mnLancValeTransp);
        mnLancBenefico.add(mnLancSegVida);
        mnLancBenefico.add(mnLancPlanoSaude);
        mnLancBenefico.add(mnLancPlanoOdonto);

        mnLancDocument.add(mnLancASO);
        mnLancDocument.add(mnLancPPRA);
        mnLancDocument.add(mnLancPCMSO);

        mnLancTreinamento.add(mnLancInterno);
        mnLancTreinamento.add(mnLancExterno);

        menuLanc.add(mnLancFerias);
        menuLanc.add(mnLancEpi);
        menuLanc.add(mnLancUniforme);
        menuLanc.add(mnLancBenefico);
        menuLanc.add(mnLancDocument);
        menuLanc.add(mnLancTreinamento);

        menuComp.add(mnCompImport);
        menuComp.add(mnCompExport);

        menuBar.add(menuCad);
        menuBar.add(menuLanc);
        menuBar.add(menuRel);
        menuBar.add(menuComp);

        // Retorna o menu construído.
        return menuBar;
    }

    // Método para inicializar os atributos.
    private void Inicializa_Atributos(){

        fonte_menu      = new Font("TimesRoman",Font.BOLD,14);
        fonte_menu_item = new Font("TimesRoman",Font.BOLD,12);
        cor_menuBar     = new Color(255,255,255);
        cor_fundo_tela  = new Color(210,200,255);
        Toolkit ferramenta = Toolkit.getDefaultToolkit();
        tamanho_tela = ferramenta.getScreenSize();

    }

    void setCadColaborador() {
        this.cadColaborador = null;
    }

    void setCadEmpresa() {
        this.cadEmpresa = null;
    }

    void setCadEpi() {
        this.cadEpi = null;
    }

    void setCadUniforme() {
        this.cadUniforme = null;
    }
}
