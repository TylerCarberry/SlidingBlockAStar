import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {

    public AStar() {

    }

    /**
     * Solve the given gameboard using the A* algorithm
     */
    public void run(GameBoard startingGameboard) {
        PriorityQueue<Path> frontier = new PriorityQueue<>();
        List<GameBoard> closed = new ArrayList<>();

        frontier.add(new Path(startingGameboard));

        while(!frontier.isEmpty()) {
            // Take the shortest path off the frontier
            Path path = frontier.poll();

            // If the shortest path is the solution, print it and stop solving
            if (path.getLastItem().isSolved()) {
                System.out.println(path);
                return;
            }

            closed.add(path.getLastItem());
            // Loop through each child node
            for (GameBoard gameBoard : path.getLastItem().getPossibleMoves()) {
                // Don't search items in closed to avoid a loop
                if (!closed.contains(gameBoard)) {
                    Path cloned = path.clone();
                    // Add each next node to the frontier
                    cloned.addToPath(gameBoard, costBetweenMoves(gameBoard, path.getLastItem()));
                    frontier.add(cloned);
                }
            }
        }

        System.out.println("No solution found!");
    }


    /**
     * Precondition: board2 is one move away from board1
     * @return the cost of the move between these two boards
     */
    private int costBetweenMoves(GameBoard board1, GameBoard board2) {
        int index1 = board1.getBoard().indexOf(' ');
        int index2 = board2.getBoard().indexOf(' ');

        if (Math.abs(index1 - index2) == 3) {
            return 2;
        }
        return 1;
    }

}
