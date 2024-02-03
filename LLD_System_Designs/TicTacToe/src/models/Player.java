package models;
//Player is an abstract class because we dont need to create an instance of the player class we would just need
//the instance of the type of player(i.e. either the given player or the bot)
public abstract class Player {
    private Symbol symbol;
    private PlayerType playerType;
    private String name;

    Player(PlayerType type, Symbol symbol) {
        this.playerType = type;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    //So after creating the game through builder class this is the second step that player will make a move
    //and this is of abstract type so that both the human player and the bot player can implement this method
    //abstract method means till now we dont have the definition of this method but
    // we need to define this method in its child classes necessarily
    //now after this we will go in player class to implement this method there
    public abstract Move makeMove(Board board); //since the move is based on the board
}

// StartGame
// NumberOfPlayers
// Human email name phone_number symbol
// Bot strategyType
// DimensionOfBoard (n)
// WinningStrategies
// This will lead to creation of Game object
// => Builder to be used for game
// Game(int n, List<Player>, Strategy, int dimension,)