public class Heuristic {

    /**
     * One easy heuristic function is the number of black tiles to the left of the leftmost white tile.
     * For example, h(['b', 'b', 'w', 'b', '  ', 'w', 'w']) would return 2
     * @param gameBoard the board to run the heuristic on
     * @return the heuristic
     */
    public static int easyHeuristic(GameBoard gameBoard) {
        int num = 0;

        for (Character character : gameBoard.getBoard()) {
            if (character.equals('B')) {
                num++;
            } else if (character.equals('W')) {
                return num;
            }
        }
        return num;
    }


}
