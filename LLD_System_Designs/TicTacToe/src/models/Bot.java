package models;
public class Bot extends Player {
    //botPlayingStrategy -> this is just defining the difficulty level i.e. either easy, medium or hard but it is
    //not defining the strategy in which the bot will make its move

    //this botplayingstrategy is just a variable of BotPlayingStrategy type whos defination is defined in its
    // constructor below
    private BotPlayingStrategy botPlayingStrategy;

    //BotPlayingStrategy basically defines the strategy how the bot will play
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(Symbol symbol, BotDifficultyLevel botDifficultyLevel) {
        //here we are calling the parent and setting its type and symbol and the name
        super(PlayerType.BOT, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        //BotPlayingStrategyFactory will contain all the strategies based on the difficulty levels
        //in this we will create a bot's playing strategy on the basis of the difficulty level
        //so botplaying strategy will get the strategy from the factory based on its difficulty level
        this.botPlayingStrategy = new BotPlayingStrategyFactory().createBotPlayingStrategyForDifficultyLevel(
                botDifficultyLevel
        );
    }

    @Override
    public Move makeMove(Board board) {
        return this.botPlayingStrategy.makeNextMove(board, this);
    }
}
