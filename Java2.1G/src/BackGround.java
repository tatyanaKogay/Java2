import java.awt.*;

public class BackGround {
    Color color;

    void setCanvasColor(GameCanvas canvas, float n){
        int c1 = (int)(n*100000 % 255);
        int c2 = (int)(n*100000 % 255);
        int c3 = (int)(n*100000 % 255);
        color = new Color(c1,c2,c3);
        canvas.setBackground(color);
    }
}
