import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class PreListO {
    public static List<Obstacle> preobs;
    private static Random random = new Random();
    public static int xer;

    static {
        preobs = new ArrayList<>();
        generateobs();

    }
    public static void generateobs() {
        xer = 600;
        for (int i = 1; i < 5; i++) {
            int adder = random.nextInt(2);

            //1
            preobs.add(new Obstacle(xer, 50, 410, 100, 250, 200));
            //2
            xer += 200;
            preobs.add(new Obstacle(xer, 200, 0, 100, 400, 0));
            //3
            xer += 200;
            preobs.add(new Obstacle(xer, 50, 0, 100, 275, 0));
            //4
            xer += 200;
            preobs.add(new Obstacle(xer, 400, 50, 100, 100 * adder, 50));
            //5
            xer += 200;
            preobs.add(new Obstacle(xer, 200, 410, 100, 50* adder, 200));
            //6
            xer += 200;
            preobs.add(new Obstacle(xer, 400, 0, 100, 200, 0));
            //7
            xer += 200;
            preobs.add(new Obstacle(xer, 50, 0, 100, 200, 0));
            //8
            xer += 200;
            preobs.add(new Obstacle(xer, 410, 50, 100, 150, 300));
            //9
            xer += 200;
        }
    }

}
