
import java.awt.Graphics;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Panel_Imagen_Dinamico extends JScrollPane {

        private JScrollBar HBar, VBar;

        

        public Panel_Imagen_Dinamico() {
            this.HBar = getHorizontalScrollBar();
            this.VBar = getVerticalScrollBar();
            
        }


        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }

        

    }
