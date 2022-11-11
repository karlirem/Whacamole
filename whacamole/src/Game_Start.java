import java.awt.*;

public class Game_Start extends A_TextObject{

protected int height;
protected int width;

    public Game_Start(int x_, int y_) {
        super(x_, y_,Color.red );
        height = 150;
        width = 150;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    protected int type() {
        return A_Const.TYPE_START;
    }
}
