import java.awt.*;

public class Game_Bomb extends A_GameObject{
    public Game_Bomb(double x_, double y_) {
        super(x_, y_, 0, 0, 0, Color.gray);
        isLiving = true;
    }

    @Override
    int type() {
        return A_Const.TYPE_BOMB;
    }
}
