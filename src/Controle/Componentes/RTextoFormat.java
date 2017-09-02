package Controle.Componentes;

import javax.swing.*;
import javax.swing.text.Document;

public class RTextoFormat extends JTextField {

    public RTextoFormat() {
        super(null,null,0);
    }

    public RTextoFormat(String s) {
        super(s);
    }

    public RTextoFormat(int i) {
        super(i);
    }

    public RTextoFormat(String s, int i) {
        super(s, i);
    }

    public RTextoFormat(Document document, String s, int i) {
        super(document, s, i);
    }


}
