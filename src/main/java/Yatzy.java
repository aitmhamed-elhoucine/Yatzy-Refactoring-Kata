import java.util.*;

public class Yatzy {

    private static final int YATZY_SCORE = 50;
    private static final int SMALL_STRAIGHT_SCORE = 15;
    private static final int LARGE_STRAIGHT_SCORE = 20;
    protected static final int ZERO_SCORE = 0;
    private static final List<Integer> LARGE_STRAIGHT_LIST = List.of(2,3,4,5,6);
    private static final List<Integer> SMALL_STRAIGHT_LIST = List.of(1,2,3,4,5);


    /**
     * The player scores the sum of all dice, no matter what they read
     * @param sixSidedDiceRoll
     * @return the sum of all dice
     */

    public static int scoreChance(SixSidedDiceRoll sixSidedDiceRoll) {
        return sixSidedDiceRoll.sum();
    }

    /**
     * Calculates the score for Yatzy.
     * Yatzy scores 50 points if all dice have the same number.
     * @param sixSidedDiceRoll
     * @return 50 or 0
     */
    public static int scoreYatzy(SixSidedDiceRoll sixSidedDiceRoll) {
        if (sixSidedDiceRoll.countDistinct() == 1) {
            return YATZY_SCORE;
        }
        return ZERO_SCORE;
    }

    /**
     * Calculates the score for given side.
     * The player scores the sum of the dice that read the given side.
     * the given value must be greater or equal one and less or equal the number of edges
     * @param sixSidedDiceRoll
     * @param sideNumber
     * @return the sum of the dice that read the given side
     */
    public static int scoreSide(SixSidedDiceRoll sixSidedDiceRoll, int sideNumber) {
        return sixSidedDiceRoll.scoreSide(sideNumber);
    }


    /**
     * Calculates the score for pair.
     * The player scores the sum of the two highest matching dice.
     * @param sixSidedDiceRoll
     * @return the sum of the two highest matching dice
     */
    public static int scorePair(SixSidedDiceRoll sixSidedDiceRoll) {
        int pairValue = sixSidedDiceRoll.countOccurrences().entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(Map.Entry::getKey)
            .max()
            .orElse(0);
        return pairValue >= 2 ? pairValue * 2 : ZERO_SCORE;
    }

    /**
     * Calculates the score for two pairs.
     * If there are two pairs of dice with the same number, the player scores the sum of these dice.
     * @param sixSidedDiceRoll
     * @return the score for two pairs.
     */
    public static int scoreTwoPairs(SixSidedDiceRoll sixSidedDiceRoll) {
        int numPairs = 0;
        int score = 0;
        for (int i = 1; i <= 6; i++) {
            if (sixSidedDiceRoll.countOccurrences().getOrDefault(i, 0L) >= 2) {
                numPairs++;
                score += i * 2;
            }
        }
        return numPairs == 2 ? score : ZERO_SCORE;
    }

    /**
     * Calculates the score for three of a kind.
     * If there are three dice with the same number, the player scores the sum of these dice.
     * @param sixSidedDiceRoll
     * @return the score for three of a kind.
     */
    public static int scoreThreeOfAKind(SixSidedDiceRoll sixSidedDiceRoll) {
        return sixSidedDiceRoll.calculateKindScore(3);
    }

    /**
     * Calculates the score for four of a kind.
     * If there are four dice with the same number, the player scores the sum of these dice.
     * @param sixSidedDiceRoll
     * @return the score for four of a kind.
     */
    public static int scoreFourOfAKind(SixSidedDiceRoll sixSidedDiceRoll) {
        return sixSidedDiceRoll.calculateKindScore(4);
    }


    /**
     * Calculates the score for large straight.
     * When placed on "small straight", if the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice).
     * @param sixSidedDiceRoll
     * @return 15 or 0
     */
    public static int scoreSmallStraight(SixSidedDiceRoll sixSidedDiceRoll) {
        return sixSidedDiceRoll.calculateStraight(SMALL_STRAIGHT_LIST, SMALL_STRAIGHT_SCORE);
    }

    /**
     * Calculates the score for large straight.
     * When placed on "large straight", if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     * @param sixSidedDiceRoll
     * @return 20 or 0
     */
    public static int scoreLargeStraight(SixSidedDiceRoll sixSidedDiceRoll) {
        return sixSidedDiceRoll.calculateStraight(LARGE_STRAIGHT_LIST, LARGE_STRAIGHT_SCORE);
    }

    /**
     * Calculates the score for full house.
     * If the dice are two of a kind and three of a kind, the player scores the sum of all the dice.
     * @param sixSidedDiceRoll
     * @return the score for full house
     */
    public static int scoreFullHouse(SixSidedDiceRoll sixSidedDiceRoll) {
        return scorePair(sixSidedDiceRoll) != ZERO_SCORE
            && scoreThreeOfAKind(sixSidedDiceRoll) != ZERO_SCORE
            && scoreYatzy(sixSidedDiceRoll) == ZERO_SCORE  ? scoreChance(sixSidedDiceRoll) : ZERO_SCORE;
    }
}



