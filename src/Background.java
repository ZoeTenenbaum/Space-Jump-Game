import java.util.ArrayList;
import java.util.List;

class Background {
    private List<Obstacle> obstacles;
    public Background() {
        obstacles = new ArrayList<>();
        generateObstacles();
    }
    private void generateObstacles() {
        obstacles = PreListO.preobs;
    }

    public void update() {
        for (Obstacle obstacle : obstacles) {
            obstacle.x1 -= 1.5;

        }
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
}