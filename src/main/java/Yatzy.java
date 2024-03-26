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
     */
    public static int scoreChance(DiceRoll diceRoll) {
        return diceRoll.sum();
    }

    /**
     * Calculates the score for Yatzy.
     * Yatzy scores 50 points if all dice have the same number.
     */
    public static int scoreYatzy(DiceRoll diceRoll) {
        if (diceRoll.countDistinct() == 1) {
            return YATZY_SCORE;
        }
        return ZERO_SCORE;
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read one.
     */
    public static int scoreOnes(DiceRoll diceRoll) {
        return diceRoll.countDice(1);
    }

    /**
     * Calculates the score for twos.
     * The player scores the sum of the dice that read two.
     */
    public static int scoreTwos(DiceRoll diceRoll) {
        return diceRoll.countDice(2);
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read three.
     */
    public static int scoreThrees(DiceRoll diceRoll) {
        return diceRoll.countDice(3);
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read four.
     */
    public static int scoreFours(DiceRoll diceRoll) {
        return diceRoll.countDice(4);
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read five.
     */
    public static int scoreFives(DiceRoll diceRoll) {
        return diceRoll.countDice(5);
    }

    /**
     * Calculates the score for ones.
     * The player scores the sum of the dice that read six.
     */
    public static int scoreSixes(DiceRoll diceRoll) {
        return diceRoll.countDice(6);
    }

    /**
     * Calculates the score for pair.
     * The player scores the sum of the two highest matching dice.
     */
    public static int scorePair(DiceRoll diceRoll) {
        int pairValue = diceRoll.countOccurrences().entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(Map.Entry::getKey)
            .max()
            .orElse(0);
        return pairValue >= 2 ? pairValue * 2 : ZERO_SCORE;
    }

    /**
     * Calculates the score for two pairs.
     * If there are two pairs of dice with the same number, the player scores the sum of these dice.
     */
    public static int scoreTwoPairs(DiceRoll diceRoll) {
        int numPairs = 0;
        int score = 0;
        for (int i = 1; i <= 6; i++) {
            if (diceRoll.countOccurrences().getOrDefault(i, 0) >= 2) {
                numPairs++;
                score += i * 2;
            }
        }
        return numPairs == 2 ? score : ZERO_SCORE;
    }

    /**
     * Calculates the score for three of a kind.
     * If there are three dice with the same number, the player scores the sum of these dice.
     */
    public static int scoreThreeOfAKind(DiceRoll diceRoll) {
        return diceRoll.calculateKindScore(3);
    }

    /**
     * Calculates the score for four of a kind.
     * If there are four dice with the same number, the player scores the sum of these dice.
     */
    public static int scoreFourOfAKind(DiceRoll diceRoll) {
        return diceRoll.calculateKindScore(4);
    }


    /**
     * Calculates the score for large straight.
     * When placed on "large straight", if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     */
    public static int scoreSmallStraight(DiceRoll diceRoll) {
        return diceRoll.calculateStraight(SMALL_STRAIGHT_LIST, SMALL_STRAIGHT_SCORE);
    }

    /**
     * Calculates the score for large straight.
     * When placed on "large straight", if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     */
    public static int scoreLargeStraight(DiceRoll diceRoll) {
        return diceRoll.calculateStraight(LARGE_STRAIGHT_LIST, LARGE_STRAIGHT_SCORE);
    }

    /**
     * Calculates the score for full house.
     * If the dice are two of a kind and three of a kind, the player scores the sum of all the dice.
     */
    public static int scoreFullHouse(DiceRoll diceRoll) {
        return scorePair(diceRoll) != ZERO_SCORE
            && scoreThreeOfAKind(diceRoll) != ZERO_SCORE
            && scoreYatzy(diceRoll) == ZERO_SCORE  ? scoreChance(diceRoll) : ZERO_SCORE;
    }
}



