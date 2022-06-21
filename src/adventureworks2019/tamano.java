package adventureworks2019;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class tamano extends JFrame {

    public int Ancho() {
        Toolkit p = Toolkit.getDefaultToolkit();
        Dimension tama = p.getScreenSize();;
        int anch = tama.width;
        return anch;
    }
    
    public int altura(){
        Toolkit p = Toolkit.getDefaultToolkit();
        Dimension tama = p.getScreenSize();;
        int alt = tama.height;
        return alt;
    }
}
