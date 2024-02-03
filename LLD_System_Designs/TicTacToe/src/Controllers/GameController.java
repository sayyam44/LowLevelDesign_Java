package Controllers;
import java.util.List;

//GAME CONTROLLER WILL GET THE INPUTS FROM THE CLIENT AND WILL GET THE GAME SERVICE FOR THAT INPUTS

// Start a game
// Make a move
// Undo
// CheckWinner
// GetCurrentState
public class GameController {
    public Game createGame(int dimensionOfBoard,
                           List<Player> players,
                           List<GameWinningStrategy> strategies) {
        Game game = null;

        try {
            game = Game.create()
                    .setDimenston(dimensionOfBoard)
                    .addPlayers(players)
                    .addGameWinningStrategies(strategies)
                    .build();
        } catch (Exception exception) {
            System.out.println("We did something wrong");
            exception.printStackTrace();
        }

        return game;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public boolean undo(Game game) throws EmptyMovesUndoOperationException {
        return game.undo();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void display(Game game) {
        game.getBoard().printBoard();
    }
}
