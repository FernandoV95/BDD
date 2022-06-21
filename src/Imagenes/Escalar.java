package Imagenes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Escalar {

    public void ELabel(JLabel l, String Imagen) {
        l.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(Imagen)).getImage().getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_DEFAULT)));

    }
}
