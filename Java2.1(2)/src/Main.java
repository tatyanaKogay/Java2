public class Main {
    public static void main(String[] args) {
        Human human = new Human(3, 2000, "Jack");
        Cat cat = new Cat(1, 700, "Leo");
        Robot robot = new Robot(5, 3000, "Rob");
        Running[] runners = {human, cat, robot};
        Obstacle[] obstacles = makeOb(20);
        for (int i=0; i<runners.length; i++){
            for (int j=0; j<obstacles.length; j++){
                if (obstacles[j] instanceof Track) runners[i].run((Track)obstacles[j]);
                else runners[i].jump((Wall) obstacles[j]);
                if (!runners[i].getR()) break;
            }
        }
    }

    static Obstacle[] makeOb(int i){
        Obstacle[] o = new Obstacle[i];
        for (int j=0; j<i; j++){
            o[j] = randomOb();
        }
        return o;
    }

    static Obstacle randomOb(){
        int l,h;
        do{
        l = (int) (Math.random() * 2000);
        h = (int) (Math.random() * 4);
        } while (l==0 || h==0);
        return (int)(Math.random()*2) == 1 ? new Track(l) : new Wall(h);
    }
}
