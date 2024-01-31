package strategies.botplayingstrategies;

public interface BotPlayingStrategy {
    Move makeNextMove(Board board, Player player);
}