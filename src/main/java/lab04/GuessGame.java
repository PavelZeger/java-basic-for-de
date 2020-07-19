package lab04;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Pavel Zeger
 */
public class GuessGame {

    private int bestResult = Integer.MAX_VALUE;
    private ArrayList<Integer> results = new ArrayList<>();

    public void play(int max) {
        Random random = new Random();
        int x = random.nextInt(max);
        int numberOfTries = 0;

        for (int i = 0; i < max; i++) {
            int answer = Integer.parseInt(JOptionPane.showInputDialog("What is your number?"));
            if (answer == x) {
                JOptionPane.showMessageDialog(null, "You won!");
                numberOfTries++;
            } else if (answer < x) {
                answer = Integer.parseInt(JOptionPane.showInputDialog("The number is too small, try again!"));
                numberOfTries++;
            } else if (answer > x) {
                answer = Integer.parseInt(JOptionPane.showInputDialog("The number is too big, try again!"));
                numberOfTries++;
            }
        }

        results.add(numberOfTries);

    }

    public int getBestResult() {
        return Collections.min(results);
    }

    public void printBestScore() {
        System.out.println("The best result: " + String.valueOf(getBestResult()));
    }
}
