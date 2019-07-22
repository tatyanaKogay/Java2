public class Cat implements Running{

    private int maxHeight;
    private int maxLength;
    String name;
    boolean got;

    public Cat (int h, int l, String _name){
        this.maxHeight = h;
        this.maxLength = l;
        this.name = _name;
        got = false;
    }
    @Override
    public void jump(Wall w) {
        if (w.getheight()>maxHeight)
        {
            System.out.println(name+tooHighMess+w.getheight());
            got = false;
        }
        else {
            System.out.println(name + " jumped over " + w.getheight() + " m.");
            got = true;
        }
    }

    @Override
    public void run(Track t) {
        if (t.getlenght()>maxLength) {
            System.out.println(name+tooLongMess+t.getlenght());
            got = false;
        }
        else {
            System.out.println(name + " ran " + t.getlenght() + " m.");
            got = true;
        }
    }
    @Override
    public boolean getR() {
        return got;
    }
}
