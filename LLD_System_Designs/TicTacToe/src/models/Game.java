//Models - these are the internal entities that are defined in the code.
package models;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public int getLastMovedPlayerIndex() {
        return lastMovedPlayerIndex;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    private Game() {
        this.players = new ArrayList<>();
        this.moves = new ArrayList<>();
        this.gameWinningStrategies = new ArrayList<>();
        this.lastMovedPlayerIndex = -1;
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public void makeMove() {
        this.lastMovedPlayerIndex += 1;//here we are incrementing the last player moved index by 1
        this.lastMovedPlayerIndex %= this.players.size(); //if we have 3 players so here we are making each player index to be 0,1,2,0,1,2

        Move move = this.players.get(this.lastMovedPlayerIndex) //here we are storing the move of the last moved player
                .makeMove(this.board);

        this.moves.add(move); //adding this move in the moves

        move.getCell().setSymbol(move.getSymbol());

        for (GameWinningStrategy strategy: gameWinningStrategies) { //here we are checking that whether we have some winner
            //then we will end the game
            if (strategy.checkIfWon(this.board, this.players.get(lastMovedPlayerIndex), move.getCell())) {
                gameStatus = GameStatus.ENDED;
                winner = this.players.get(lastMovedPlayerIndex);
                return;
            }
        }

        //to check is it draw or not
        if (moves.size() == this.board.getDimension() * this.board.getDimension()) {
            gameStatus = GameStatus.DRAW;
            return;
        }
    }

    //  A B C D
    //  0 1 2 3 4
    //  0

    //this function is to undo the last move
    public static Builder create() {
        return new Builder();
    }

    public boolean undo() throws EmptyMovesUndoOperationException {
        if (this.moves.size() == 0) {
            // Handle Edge Case
            throw new EmptyMovesUndoOperationException();
        }

        Move lastMove = this.moves.get(this.moves.size() - 1);
        Cell relevantCell = lastMove.getCell(); //c1 c2 c3 c4 , p1,p2,p3,p4,p5 ,  here the turn will be of 5th player
        relevantCell.clearCell();//clear the cell //c1 c2 c3 null , now the turn will be of 4th player
        this.lastMovedPlayerIndex -= 1; //reduce the index of the last moved player by 1
        this.lastMovedPlayerIndex = (this.lastMovedPlayerIndex + this.players.size()) % this.players.size(); //add the size and mod again
        this.moves.remove(lastMove);//remove the last move
        return true;
    }
    //example for above
    //  0      1      2     3
    // [Cell1 Cell2 Cell3 Cell4]
    //  0      1      2
    // [Cell1 Cell2 Cell3]

    // 0
    // [Cell1]
    // 0 - 1 = -1 % M
    // (A - B) % M = ((A % M - B %M) + M) % M

    //builder always have the same or less attributes that of its parent class for which this builder is created
    //in this case its the game class on the basis of the requirements
    public static class Builder {
        //here we will only need the required parameters from its parent class
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;
        private int dimension; //from the client we will not ask for the board instead we will ask the dimension of the board

        Builder() {
            this.players = new ArrayList<>();
            this.gameWinningStrategies = new ArrayList<>();
        }

        //In builder generally we just define the getters and setters for the parameters but here since the
        //parameters are in the form of list we will allow to add the player one by one
        //example
        // Game.BUilder.setPlayers({})
        // Game game = Game.Builder.addPlayer(new HumanPlayer()) -> this is better option then the above one
        //                         .addPlayer(new Bot())
        //                         .build();
        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }

        //this is just as above the only difference is that here we will direcly add players in a list
        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);

            return this;
        }

        public Builder setDimenston(int dimension) { //instead of adddimension it should be setdimension
            this.dimension = dimension;
            return this;
        }


        public Builder addGameWinningStrategy(GameWinningStrategy strategy) {
            this.gameWinningStrategies.add(strategy);
            return this;
        }

        public Builder addGameWinningStrategies(List<GameWinningStrategy> strategies) {
            this.gameWinningStrategies.addAll(strategies);
            return this;
        }

        private boolean checkIfSingleBotMax() { //This is to check that there should be only a single bot
            int count = 0;

            for (Player player: players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    count += 1;
                }
            }

            return count <= 1;
        }
        public Game build() throws MultipleBotsException {
            if (!checkIfSingleBotMax()) {
                throw new MultipleBotsException();
            }

//            if (players.size() < 2) {
//                //
//            }
//
//            if (gameWinningStrategies.size() < 1) {
//                //
//            }
//
//            if (dimension < 3) {
//
//            }

            Game game = new Game();
            game.players.addAll(this.players);
            game.gameWinningStrategies.addAll(this.gameWinningStrategies);
            game.board = new Board(dimension);

            return game;
        }
    }
}}