import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Sprite extends JButton {
    int x;
    int y;
    //JLabel img;
    Image img;
    int tempy;
    int tempx;

    int vx = 2, vy = -10, ay = 1;

    AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

    // constructs player as affinetransform instead of image
    public Sprite(String filename) {
        tx = AffineTransform.getTranslateInstance(x, y);
        x = 455;
        y = 400;
        img = getImage(filename);

        this.setBounds(x, y, 100, 100);
        init(x, y);

    }


    public Sprite(String f, int x2, int y2) {
        // TODO Auto-generated constructor stub
        x = x2;
        y = y2;
        img = getImage(f);
        init(x, y);
    }


    // move with input from driver
    public void move() {
        //	tx.translate(vx, vy);
    }

    // use find affinetransform current position
    public int gety() {
        return (int) tx.getTranslateY();
    }

    public int getx() {
        return (int) tx.getTranslateX();
    }


    public void rotateCW() {
        tx.rotate(2);
    }

    // "rotate" based on direction
    public void rotateleft() {
        img = getImage("Playerleft.png");

    }

    public void rotateright() {
        img = getImage("Playerright.png");

    }

    public void rotatedown() {
        img = getImage("Playerdown.png");

    }

    public void rotateup() {
        img = getImage("Player.png");

    }

    // set size and position and reset player
    public void init(double a, double b) {
        tx.setToTranslation(a, b);
        tx.scale(2, 2);
    }

    // draw the affinetransform
    public void paint(Graphics g, Point p) {
        Graphics2D g2 = (Graphics2D) g;

        //example resizing image on call to paint
        BufferedImage resizedImg = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g3 = resizedImg.createGraphics();

        g3.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g3.drawImage(img, (int) p.getX() - 550, (int) p.getY() - 600, 200, 200, null);
        g3.dispose();

        //example rotating image on call to paint
        //tx.rotate(1,50,50);
        g2.drawImage(resizedImg, tx, null);


    }

    // converts image to make it drawable in paint
    private Image getImage(String path) {
        Image tempImage = null;
        try {
            URL imageURL = Sprite.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempImage;
    }

}
