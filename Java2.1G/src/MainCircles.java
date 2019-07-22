import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainCircles extends JFrame{
    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static  int num = 10;
    private Sprite[] sprites = new Sprite[30];


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        GameCanvas gameCanvas = new GameCanvas(this);
        gameCanvas.addMouseListener(new MyMouseListener());
        initApplication();
        add(gameCanvas, BorderLayout.CENTER);
        setVisible(true);
    }

    void initApplication() {
        for (int i = 0; i < num; i++) {
            sprites[i] = new Ball();
        }
    }

    void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime){
        for (int i = 0; i < num; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < num; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public class MyMouseListener extends MouseAdapter{

        @Override
        public void mousePressed(MouseEvent e) {
            super.mouseDragged(e);
            double x = e.getX();
            double y = e.getY();
            boolean isBall = false;
            int j;
            for (j = 0; j < num; j++){
                if (x > sprites[j].getLeft() && x < sprites[j].getRight()
                        && y > sprites[j].getTop() && y < sprites[j].getBottom()) {
                    isBall = true;
                    break;
                }
            }
            if (isBall){
                if (j != num-1) sprites[j] = sprites[num-1];
                sprites[--num] = null;
            }
            else {
                if (num==sprites.length){
                    Sprite[] spritesN = new Sprite[num*2];
                    for (int k=0; k<sprites.length; k++){
                        spritesN[k] = sprites[k];
                    }
                    sprites = spritesN;
                }
                Ball ball = new Ball();
                ball.setLeft((int)x);
                ball.setTop((int)y);
                sprites[num++] = ball;
            }
        }
    }
}
