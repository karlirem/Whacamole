import java.awt.*;

public class Game_Hammer extends A_GameObject{
    public Game_Hammer(double x_, double y_, double a_, double s_, int r_, Color color_) {
        super(x_, y_, a_, s_, r_, color_);
    }

    @Override
    int type() {
        return A_Const.TYPE_HAMMER;
    }
}
