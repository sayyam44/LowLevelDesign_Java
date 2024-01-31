package strategies.botplayingstrategies.gamewinningstrategies;

public interface GameWinningStrategy {

    boolean checkIfWon(Board board, Player player, Cell moveCell);
}

//****Why we have not created a factory for game winning strategy because the game winning strategies
//will be defined by the client itself so In the Game class itself we have created the builder
//for game winning strategies so that while creating a game the user or the client will definitely
//gonna decide the winning strategies as well in the Builder one by one.

//In other words we can say that we dont need an instance of the game winning strategy as we needed
//for the botplayingstrategy to define the bot playing strategy on its difficulty level.

//the client could have created an instance of the game on the basis of builder for botplayingstrategy
//as well but the client just knew the difficulty level of the bot not exactly what is the strategy
//being followed behind that particular strategy level.

