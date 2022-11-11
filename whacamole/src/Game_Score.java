import java.awt.*;

public class Game_Score extends A_TextObject{
    public Game_Score(int x_, int y_, Color color_) {
        super(x_, y_, color_);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    protected int type() {
        return A_Const.TYPE_SCORE;
    }
}
