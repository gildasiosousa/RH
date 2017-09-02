package Controle.Componentes;

import javax.swing.*;
import javax.swing.text.Document;

public class RNumerico extends JTextField {

    public RNumerico() {
        super(null,null,0);
    }

    public RNumerico(String s) {
        super(s);
    }

    public RNumerico(int i) {
        super(i);
    }

    public RNumerico(String s, int i) {
        super(s, i);
    }

    public RNumerico(Document document, String s, int i) {
        super(document, s, i);
    }
}
