package com.test.fingerguessing;

import java.util.Random;

/**
 * Created by dell on 2016/12/13.
 */
public class AI {
    static private String playerHist;
    static private String aiHist;

    static {
        playerHist = "";
        aiHist = "";
    }

    /**
     * guessing the next move using machine learning method if there's
     * history information of user and ai
     * @return
     */
    static public String intelligentGuess() {
        if (playerHist.length()  == 0) {
            return randomGuess();
        }

        PredictionEngine engine = PredictionEngine.getInstance();
        System.out.println(playerHist);
        System.out.println(aiHist);
        char move = engine.determineOptimalMove(playerHist, aiHist);

        switch (move) {
            case 'R':
                return PlayActivity.Rock;
            case 'S':
                return PlayActivity.Scissors;
            case 'P':
                return PlayActivity.Paper;
            default:
                return PlayActivity.Rock;
        }
    }

    /**
     * guess the next move by randomly generate a number
     * @return
     */
    static public String randomGuess() {
        Random random = new Random();
        int no = Math.abs(random.nextInt()) % 3;
        switch (no) {
            case 0: return PlayActivity.Rock;
            case 1: return PlayActivity.Paper;
            case 2: return PlayActivity.Scissors;
            default: return PlayActivity.Rock;
        }
    }

    /**
     * update history information
     * @param playerAction
     * @param aiAction
     */
    static public void train(String playerAction, String aiAction) {
        playerHist += getMove(playerAction);
        aiHist += getMove(aiAction);
    }

    static char getMove(String move) {
        if (move.equals(PlayActivity.Rock)) {
            return 'R';
        }
        if (move.equals(PlayActivity.Scissors)){
            return 'S';
        }
        if (move.equals(PlayActivity.Paper)) {
            return 'P';
        }

        return 'R';
    }
}
