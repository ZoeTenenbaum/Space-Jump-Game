import java.util.ArrayList;
import java.util.List;

class Background {
    private List<Obstacle> obstacles;
    private List<Obstacle> moreObstacles;
    public Background() {
        obstacles = new ArrayList<>();
        generateObstacles();
        moreObstacles = new ArrayList<>();
        generateMoreObstacles();
    }
    private void generateObstacles() {
        obstacles = PreListO.preobs;
    }
    private void generateMoreObstacles() {
        moreObstacles = PreListO.morepreobs;
    }

    public void update() {
        for (Obstacle obstacle : obstacles) {
            obstacle.x1 -= 1.5;

        }
        for (Obstacle obstacle : moreObstacles) {
            obstacle.x1 -= 1.5;
        }
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }
    public List<Obstacle> getMoreObstacles() {
        return moreObstacles;
    }
}