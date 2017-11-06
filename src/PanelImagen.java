import boofcv.alg.filter.binary.GThresholdImageOps;
import boofcv.core.image.ConvertImage;
import boofcv.gui.binary.VisualizeBinaryData;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.struct.image.GrayU8;
import boofcv.struct.image.Planar;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelImagen extends JPanel{

    private BufferedImage I = null;
    
    public BufferedImage getI() {
        return I;
    }
    
    public void setI(BufferedImage I){
        this.I = I;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(I, 0, 0, null);
    }
    
    public BufferedImage umbralizar(BufferedImage imagen, int umbral){
        Planar<GrayU8> imagenColor = ConvertBufferedImage.convertFromPlanar(imagen, null, true, GrayU8.class);
        GrayU8 imagenGris = new GrayU8(imagen.getWidth(),imagen.getHeight());
        GrayU8 imagenUmbralizada = new GrayU8(imagen.getWidth(),imagen.getHeight());
        ConvertImage.average(imagenColor, imagenGris);
        GThresholdImageOps.threshold(imagenGris, imagenUmbralizada, umbral, false);
        return VisualizeBinaryData.renderBinary(imagenUmbralizada, false, null);
    }
}
