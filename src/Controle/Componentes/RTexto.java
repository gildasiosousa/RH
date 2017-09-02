package Controle.Componentes;

import javax.swing.*;
import javax.swing.text.Document;

public class RTexto extends JTextField {

    public RTexto() {
        super(null,null,0);
    }

    public RTexto(String s) {
        super(s);
    }

    public RTexto(int i) {
        super(i);
    }

    public RTexto(String s, int i) {
        super(s, i);
    }

    public RTexto(Document document, String s, int i) {
        super(document, s, i);
    }
}
