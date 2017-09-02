package Controle.Componentes;

import javax.swing.*;
import javax.swing.text.Document;

public class RDataHora extends JTextField {

    public RDataHora() {
        super(null,null,0);
    }

    public RDataHora(String s) {
        super(s);
    }

    public RDataHora(int i) {
        super(i);
    }

    public RDataHora(String s, int i) {
        super(s, i);
    }

    public RDataHora(Document document, String s, int i) {
        super(document, s, i);
    }
}
