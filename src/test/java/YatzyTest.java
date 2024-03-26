import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void scoreChance_Should_SumAllDice() {
        assertEquals(15, Yatzy.scoreChance(new DiceRoll(2,3,4,5,1)));
        assertEquals(16, Yatzy.scoreChance(new DiceRoll(3,3,4,5,1)));
    }

    @Test
    public void scoreYatzy_Should_Return50_When_AllDiceHaveTheSameNumber() {
        assertEquals(50, Yatzy.scoreYatzy(new DiceRoll(4,4,4,4,4)));
        assertEquals(50, Yatzy.scoreYatzy(new DiceRoll(6,6,6,6,6)));
        assertEquals(0, Yatzy.scoreYatzy(new DiceRoll(6,6,6,6,3)));
        assertEquals(50, Yatzy.scoreYatzy(new DiceRoll(1,1,1,1,1)));
        assertEquals(0, Yatzy.scoreYatzy(new DiceRoll(1,1,1,2,1)));
    }

    @Test
    public void scoreOnes_Should_ReturnSumOfOnes() {
        assertEquals(1, Yatzy.scoreOnes(new DiceRoll(1,2,3,4,5)));
        assertEquals(2, Yatzy.scoreOnes(new DiceRoll(1,2,1,4,5)));
        assertEquals(0, Yatzy.scoreOnes(new DiceRoll(6,2,2,4,5)));
        assertEquals(4, Yatzy.scoreOnes(new DiceRoll(1,2,1,1,1)));
        assertEquals(0, Yatzy.scoreOnes(new DiceRoll(3,3,3,4,5)));
    }

    @Test
    public void scoreTwos_Should_ReturnSumOfTwos() {
        assertEquals(4, Yatzy.scoreTwos(new DiceRoll(1,2,3,2,6)));
        assertEquals(10, Yatzy.scoreTwos(new DiceRoll(2,2,2,2,2)));
        assertEquals(4, Yatzy.scoreTwos(new DiceRoll(2,3,2,5,1)));
    }

    @Test
    public void scoreThrees_Should_ReturnSumOfThrees() {
        assertEquals(6, Yatzy.scoreThrees(new DiceRoll(1,2,3,2,3)));
        assertEquals(12, Yatzy.scoreThrees(new DiceRoll(2,3,3,3,3)));
    }

    @Test
    public void scoreFours_Should_ReturnSumOfFours() {
        assertEquals(12, Yatzy.scoreFours(new DiceRoll(4,4,4,5,5)));
        assertEquals(8, Yatzy.scoreFours(new DiceRoll(4,4,5,5,5)));
        assertEquals(4, Yatzy.scoreFours(new DiceRoll(4,5,5,5,5)));
        assertEquals(8, Yatzy.scoreFours(new DiceRoll(1,1,2,4,4)));
    }

    @Test
    public void scoreFives_Should_ReturnSumOfFives() {
        assertEquals(10, Yatzy.scoreFives(new DiceRoll(4,4,4,5,5)));
        assertEquals(15, Yatzy.scoreFives(new DiceRoll(4,4,5,5,5)));
        assertEquals(20, Yatzy.scoreFives(new DiceRoll(4,5,5,5,5)));
    }

    @Test
    public void scoreSixes_Should_ReturnSumOfSixes() {
        assertEquals(0, Yatzy.scoreSixes(new DiceRoll(4,4,4,5,5)));
        assertEquals(6, Yatzy.scoreSixes(new DiceRoll(4,4,6,5,5)));
        assertEquals(18, Yatzy.scoreSixes(new DiceRoll(6,5,6,6,5)));
    }

    @Test
    public void scorePair_Should_ReturnTheSumOfTheTwoHighestMatchingDice() {
        assertEquals(6, Yatzy.scorePair(new DiceRoll(3,4,3,5,6)));
        assertEquals(10, Yatzy.scorePair(new DiceRoll(5,3,3,3,5)));
        assertEquals(12, Yatzy.scorePair(new DiceRoll(5,3,6,6,5)));
        assertEquals(0, Yatzy.scorePair(new DiceRoll(1,2,3,4,5)));
        assertEquals(8, Yatzy.scorePair(new DiceRoll(3,3,3,4,4)));
        assertEquals(12, Yatzy.scorePair(new DiceRoll(1,1,6,2,6)));
        assertEquals(6, Yatzy.scorePair(new DiceRoll(3,3,3,4,1)));
        assertEquals(6, Yatzy.scorePair(new DiceRoll(3,3,3,3,1)));
    }

    @Test
    public void scoreTwoPairs_Should_ReturnSumOfParis_When_TwoPairsOfTheSameNumber() {
        assertEquals(16, Yatzy.scoreTwoPairs(new DiceRoll(3,3,5,4,5)));
        assertEquals(16, Yatzy.scoreTwoPairs(new DiceRoll(3,3,5,5,5)));
        assertEquals(8, Yatzy.scoreTwoPairs(new DiceRoll(1,1,2,3,3)));
        assertEquals(0, Yatzy.scoreTwoPairs(new DiceRoll(1,1,2,3,4)));
        assertEquals(6, Yatzy.scoreTwoPairs(new DiceRoll(1,1,2,2,2)));
        assertEquals(0, Yatzy.scoreTwoPairs(new DiceRoll(3,3,3,3,1)));
    }

    @Test
    public void scoreThreeOfAKind_ShouldReturnSumOfThreeDice_WhenThreeDiceWithSameNumber() {
        assertEquals(9, Yatzy.scoreThreeOfAKind(new DiceRoll(3,3,3,4,5)));
        assertEquals(15, Yatzy.scoreThreeOfAKind(new DiceRoll(5,3,5,4,5)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new DiceRoll(3,3,3,3,5)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new DiceRoll(3,3,3,3,3)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new DiceRoll(3,3,3,4,5)));
        assertEquals(0, Yatzy.scoreThreeOfAKind(new DiceRoll(3,3,4,5,6)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new DiceRoll(3,3,3,3,1)));
    }

    @Test
    public void scoreFourOfAKind_ShouldReturnSumOfFourDice_WhenFourDiceWithSameNumber() {
        assertEquals(12, Yatzy.scoreFourOfAKind(new DiceRoll(3,3,3,3,5)));
        assertEquals(20, Yatzy.scoreFourOfAKind(new DiceRoll(5,5,5,4,5)));
        assertEquals(8, Yatzy.scoreFourOfAKind(new DiceRoll(2,2,2,2,5)));
        assertEquals(0, Yatzy.scoreFourOfAKind(new DiceRoll(2,2,2,5,5)));
        assertEquals(8, Yatzy.scoreFourOfAKind(new DiceRoll(2,2,2,2,2)));
    }

    @Test
    public void scoreSmallStraight_Should_Return15_When_SmallStraightIsProvided() {
        assertEquals(15, Yatzy.scoreSmallStraight(new DiceRoll(1,2,3,4,5)));
        assertEquals(15, Yatzy.scoreSmallStraight(new DiceRoll(2,3,4,5,1)));
        assertEquals(0, Yatzy.scoreSmallStraight(new DiceRoll(1,2,2,4,5)));
    }

    @Test
    public void scoreLargeStraight_Should_Return20_When_largeStraightIsProvided() {
        assertEquals(20, Yatzy.scoreLargeStraight(new DiceRoll(6,2,3,4,5)));
        assertEquals(20, Yatzy.scoreLargeStraight(new DiceRoll(2,3,4,5,6)));
        assertEquals(0, Yatzy.scoreLargeStraight(new DiceRoll(1,2,2,4,5)));
    }

    @Test
    public void scoreFullHouse_Should_SumPairAndThreeOfAKind() {
        assertEquals(18, Yatzy.scoreFullHouse(new DiceRoll(6,2,2,2,6)));
        assertEquals(0, Yatzy.scoreFullHouse(new DiceRoll(2,3,4,5,6)));
        assertEquals(8, Yatzy.scoreFullHouse(new DiceRoll(1,1,2,2,2)));
        assertEquals(0, Yatzy.scoreFullHouse(new DiceRoll(2,2,3,3,4)));
        assertEquals(0, Yatzy.scoreFullHouse(new DiceRoll(4,4,4,4,4)));
    }
}
