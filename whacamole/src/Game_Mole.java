import java.awt.*;

public class Game_Mole extends A_GameObject{
    protected int height;
    protected int width;
    public Game_Mole(double x_, double y_) {
        super(x_, y_, 0, 0, 0, Color.gray);
        height = 113;
        width = 150;
       // isLiving = false;

    }

    @Override
    int type() {
        return A_Const.TYPE_MOLE;
    }
}
