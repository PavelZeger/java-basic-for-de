package lab04;

/**
 * @author Pavel Zeger
 */
public class Play {
    public static void main(String[] args) {
        GuessGame guessGame = new GuessGame();
        guessGame.play(5);
        //guessGame.play(100);
        guessGame.printBestScore();
    }
}
