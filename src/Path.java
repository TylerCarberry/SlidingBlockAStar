import java.util.ArrayList;
import java.util.List;

/**
 * A list of GameBoards that have been traveled on.
 * Has a cost which is the total cost of all moves in that Path.
 */
public class Path implements Comparable<Path> {

    private int cost = 0;
    private List<GameBoard> boards;

    public Path() {
        boards = new ArrayList<>();
    }

    public Path(GameBoard gameBoard) {
        this();
        boards.add(gameBoard);
    }

    public void addToPath(GameBoard gameBoard, int cost) {
        boards.add(gameBoard);
        this.cost += cost;
    }

    public int getCost() {
        return cost;
    }

    public List<GameBoard> getBoards() {
        return boards;
    }

    public GameBoard getLastItem() {
        return boards.get(boards.size() - 1);
    }

    public int getCostIncludingHeuristic() {
        int heuristic = 0;
        if (!boards.isEmpty()) {
            heuristic = Heuristic.easyHeuristic(boards.get(boards.size() -1));
        }

        return cost + heuristic;
    }

    public int compareTo(Path other) {
        return getCostIncludingHeuristic() - other.getCostIncludingHeuristic();
    }

    @Override
    public Path clone() {
        Path other = new Path();
        other.cost = cost;
        other.boards = new ArrayList<>(boards);
        return other;
    }

    @Override
    public String toString() {
        String str = "Cost: " + cost + "\n";
        for (GameBoard board : boards) {
            str += board + "\n";
        }
        return str;
    }

}
