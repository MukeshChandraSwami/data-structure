package tree.binary.common;

public class Holder {

    private int x;
    private int y;
    private int level;
    private String s;
    private boolean flag;

    public Holder() {
        this.x = 0;
        this.y = 0;
        this.level = 0;
        this.s = "";
        this.flag = flag;
    }

    public Holder(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
