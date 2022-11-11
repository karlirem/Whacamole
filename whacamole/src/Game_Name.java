import java.awt.*;

public class Game_Name extends A_TextObject{
    public Game_Name(int x_, int y_) {
        super(x_, y_, Color.black);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    protected int type() {
        return A_Const.TYPE_NAME;
    }
}
