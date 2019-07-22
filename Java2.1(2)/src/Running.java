public interface Running {
    String tooHighMess = " can't jump that high! It is ";
    String tooLongMess = " can't run that much! It is ";
    public void jump(Wall w);
    public void run(Track t);
    public boolean getR();

}
