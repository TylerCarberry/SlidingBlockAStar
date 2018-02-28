import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GameBoard {

    private List<Character> board;

    public GameBoard() {
        board.add('B');
        board = Arrays.asList('B', 'B', 'B', ' ', 'W', 'W', 'W');
    }

    public GameBoard(List<Character> board) {
        this.board = board;
    }

    public GameBoard(String configuration) {
        board = new ArrayList<>();
        for (int i = 0; i < configuration.length(); i++) {
            board.add(configuration.charAt(i));
        }
    }

    /**
     * @return if the game board is solved
     */
    public boolean isSolved() {
        int numWhiteFound = 0;
        for (Character tile : board) {
            if (tile.equals('W')) {
                numWhiteFound++;

                if (numWhiteFound == 3) {
                    return true;
                }

            } else if (tile.equals('B')) {
                return false;
            }
        }
        return false;
    }

    /**
     * @return a list of possible next states
     */
    public List<GameBoard> getPossibleMoves() {
        int indexOfSpace = board.indexOf(' ');

        List<GameBoard> possibleMoves = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            if (indexOfSpace < board.size() - i) {
                GameBoard boardSlideLeft = clone();
                swap(boardSlideLeft.board, indexOfSpace, indexOfSpace+i);
                possibleMoves.add(boardSlideLeft);
            }
        }

        for (int i = 0; i <= 2; i++) {
            if (indexOfSpace > i) {
                GameBoard boardSlideRight = clone();
                swap(boardSlideRight.board, indexOfSpace, indexOfSpace-(i+1));
                possibleMoves.add(boardSlideRight);
            }
        }

        return possibleMoves;
    }

    /**
     * Util method to swap two indexes of a List
     */
    private void swap(List<Character> list, int index1, int index2) {
        Character temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    @Override
    public GameBoard clone() {
        return new GameBoard(new ArrayList<>(board));
    }

    public List<Character> getBoard() {
        return board;
    }

    public void setBoard(List<Character> board) {
        this.board = board;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameBoard gameBoard = (GameBoard) o;
        return Objects.equals(board, gameBoard.board);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board);
    }

    @Override
    public String toString() {
        return board.toString();
    }
}
