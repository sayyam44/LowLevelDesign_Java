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

    public abstract Move makeMove(Board board);
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