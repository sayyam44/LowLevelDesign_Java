package strategies.botplayingstrategies.gamewinningstrategies;

import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {
    //logic for winning the game is just to check that if the count of the last move column or row is
    //the number of symbols is equal to the number of columns/rows.
    private List<HashMap<Character, Integer>> rowCharCounts;
    private List<HashMap<Character, Integer>> colCharCounts;

    private void initializeCounts(Board board) { //here I am initializing the hashmap that is associated to every
        //row and column
        rowCharCounts = new ArrayList<>();
        colCharCounts = new ArrayList<>();

        for (int i = 0; i < board.getDimension(); ++i) {
            rowCharCounts.add(new HashMap<>());
            colCharCounts.add(new HashMap<>());
        }
    }

    //logic for winning the game is just to check that if the count of the last move column or row is
    //the number of symbols is equal to the number of columns/rows.
    @Override
    public boolean checkIfWon(Board board, Player player, Cell moveCell) { //here since we need the the cell in
        // which the last move was made that is why we have Cell moveCell
        if (rowCharCounts == null) { //when for each cell the hashmap is empty
            initializeCounts(board);
        }

        //here we are getting the location of the last move
        int row = moveCell.getRow();
        int col = moveCell.getColumn();

        //initializing the hashmap for each cell in row and columns
        if (!rowCharCounts.get(row).containsKey(moveCell.getSymbol().getCharacter())) {
            rowCharCounts.get(row).put(moveCell.getSymbol().getCharacter(), 0);
        }

        if (!colCharCounts.get(col).containsKey(moveCell.getSymbol().getCharacter())) {
            colCharCounts.get(col).put(moveCell.getSymbol().getCharacter(), 0);
        }

        //inserting the count of symbols in hashmap for each cell in rows
        rowCharCounts.get(row).put(
                moveCell.getSymbol().getCharacter(),
                1 + rowCharCounts.get(row).get(moveCell.getSymbol().getCharacter())
        );
        //inserting the count of symbols in hashmap for each cell in rows
        colCharCounts.get(col).put(
                moveCell.getSymbol().getCharacter(),
                1 + colCharCounts.get(col).get(moveCell.getSymbol().getCharacter())
        );

        //now we are checking if the any cell in the row have a hashmap with value greater than the dimension that means
        //this is the winner
        if (rowCharCounts.get(row).get(moveCell.getSymbol().getCharacter()).equals(board.getDimension())) {
            return true;
        }

        //now we are checking if the any cell in the column have a hashmap with value greater than the dimension that means
        //this is the winner
        if (colCharCounts.get(col).get(moveCell.getSymbol().getCharacter()).equals(board.getDimension())) {
            return true;
        }
        return false;
    }
}
