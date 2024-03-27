import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    public void scoreChance_Should_SumAllDice() {
        assertEquals(15, Yatzy.scoreChance(new SixSidedDiceRoll(2,3,4,5,1)));
        assertEquals(16, Yatzy.scoreChance(new SixSidedDiceRoll(3,3,4,5,1)));
    }

    @Test
    public void scoreYatzy_Should_Return50_When_AllDiceHaveTheSameNumber() {
        assertEquals(50, Yatzy.scoreYatzy(new SixSidedDiceRoll(4,4,4,4,4)));
        assertEquals(50, Yatzy.scoreYatzy(new SixSidedDiceRoll(6,6,6,6,6)));
        assertEquals(0, Yatzy.scoreYatzy(new SixSidedDiceRoll(6,6,6,6,3)));
        assertEquals(50, Yatzy.scoreYatzy(new SixSidedDiceRoll(1,1,1,1,1)));
        assertEquals(0, Yatzy.scoreYatzy(new SixSidedDiceRoll(1,1,1,2,1)));
    }

    @Test
    public void scoreOnes_Should_ReturnSumOfOnes() {
        int one = Side.ONE.getValue();
        assertEquals(1, Yatzy.scoreSide(new SixSidedDiceRoll(1,2,3,4,5), one));
        assertEquals(2, Yatzy.scoreSide(new SixSidedDiceRoll(1,2,1,4,5), one));
        assertEquals(0, Yatzy.scoreSide(new SixSidedDiceRoll(6,2,2,4,5), one));
        assertEquals(4, Yatzy.scoreSide(new SixSidedDiceRoll(1,2,1,1,1), one));
        assertEquals(0, Yatzy.scoreSide(new SixSidedDiceRoll(3,3,3,4,5), one));
    }

    @Test
    public void scoreTwos_Should_ReturnSumOfTwos() {
        int two = Side.TWO.getValue();
        assertEquals(4, Yatzy.scoreSide(new SixSidedDiceRoll(1,2,3,2,6), two));
        assertEquals(10, Yatzy.scoreSide(new SixSidedDiceRoll(2,2,2,2,2), two));
        assertEquals(4, Yatzy.scoreSide(new SixSidedDiceRoll(2,3,2,5,1), two));
    }

    @Test
    public void scoreThrees_Should_ReturnSumOfThrees() {
        int three = Side.THREE.getValue();
        assertEquals(6, Yatzy.scoreSide(new SixSidedDiceRoll(1,2,3,2,3), three));
        assertEquals(12, Yatzy.scoreSide(new SixSidedDiceRoll(2,3,3,3,3), three));
    }

    @Test
    public void scoreFours_Should_ReturnSumOfFours() {
        int four = Side.FOUR.getValue();
        assertEquals(12, Yatzy.scoreSide(new SixSidedDiceRoll(4,4,4,5,5), four));
        assertEquals(8, Yatzy.scoreSide(new SixSidedDiceRoll(4,4,5,5,5), four));
        assertEquals(4, Yatzy.scoreSide(new SixSidedDiceRoll(4,5,5,5,5), four));
        assertEquals(8, Yatzy.scoreSide(new SixSidedDiceRoll(1,1,2,4,4), four));
    }

    @Test
    public void scoreFives_Should_ReturnSumOfFives() {
        int five = Side.FIVE.getValue();
        assertEquals(10, Yatzy.scoreSide(new SixSidedDiceRoll(4,4,4,5,5), five));
        assertEquals(15, Yatzy.scoreSide(new SixSidedDiceRoll(4,4,5,5,5), five));
        assertEquals(20, Yatzy.scoreSide(new SixSidedDiceRoll(4,5,5,5,5), five));
    }

    @Test
    public void scoreSixes_Should_ReturnSumOfSixes() {
        int six = Side.SIX.getValue();
        assertEquals(0, Yatzy.scoreSide(new SixSidedDiceRoll(4,4,4,5,5), six));
        assertEquals(6, Yatzy.scoreSide(new SixSidedDiceRoll(4,4,6,5,5), six));
        assertEquals(18, Yatzy.scoreSide(new SixSidedDiceRoll(6,5,6,6,5), six));
    }

    @Test
    public void scorePair_Should_ReturnTheSumOfTheTwoHighestMatchingDice() {
        assertEquals(6, Yatzy.scorePair(new SixSidedDiceRoll(3,4,3,5,6)));
        assertEquals(10, Yatzy.scorePair(new SixSidedDiceRoll(5,3,3,3,5)));
        assertEquals(12, Yatzy.scorePair(new SixSidedDiceRoll(5,3,6,6,5)));
        assertEquals(0, Yatzy.scorePair(new SixSidedDiceRoll(1,2,3,4,5)));
        assertEquals(8, Yatzy.scorePair(new SixSidedDiceRoll(3,3,3,4,4)));
        assertEquals(12, Yatzy.scorePair(new SixSidedDiceRoll(1,1,6,2,6)));
        assertEquals(6, Yatzy.scorePair(new SixSidedDiceRoll(3,3,3,4,1)));
        assertEquals(6, Yatzy.scorePair(new SixSidedDiceRoll(3,3,3,3,1)));
    }

    @Test
    public void scoreTwoPairs_Should_ReturnSumOfParis_When_TwoPairsOfTheSameNumber() {
        assertEquals(16, Yatzy.scoreTwoPairs(new SixSidedDiceRoll(3,3,5,4,5)));
        assertEquals(16, Yatzy.scoreTwoPairs(new SixSidedDiceRoll(3,3,5,5,5)));
        assertEquals(8, Yatzy.scoreTwoPairs(new SixSidedDiceRoll(1,1,2,3,3)));
        assertEquals(0, Yatzy.scoreTwoPairs(new SixSidedDiceRoll(1,1,2,3,4)));
        assertEquals(6, Yatzy.scoreTwoPairs(new SixSidedDiceRoll(1,1,2,2,2)));
        assertEquals(0, Yatzy.scoreTwoPairs(new SixSidedDiceRoll(3,3,3,3,1)));
    }

    @Test
    public void scoreThreeOfAKind_ShouldReturnSumOfThreeDice_WhenThreeDiceWithSameNumber() {
        assertEquals(9, Yatzy.scoreThreeOfAKind(new SixSidedDiceRoll(3,3,3,4,5)));
        assertEquals(15, Yatzy.scoreThreeOfAKind(new SixSidedDiceRoll(5,3,5,4,5)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new SixSidedDiceRoll(3,3,3,3,5)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new SixSidedDiceRoll(3,3,3,3,3)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new SixSidedDiceRoll(3,3,3,4,5)));
        assertEquals(0, Yatzy.scoreThreeOfAKind(new SixSidedDiceRoll(3,3,4,5,6)));
        assertEquals(9, Yatzy.scoreThreeOfAKind(new SixSidedDiceRoll(3,3,3,3,1)));
    }

    @Test
    public void scoreFourOfAKind_ShouldReturnSumOfFourDice_WhenFourDiceWithSameNumber() {
        assertEquals(12, Yatzy.scoreFourOfAKind(new SixSidedDiceRoll(3,3,3,3,5)));
        assertEquals(20, Yatzy.scoreFourOfAKind(new SixSidedDiceRoll(5,5,5,4,5)));
        assertEquals(8, Yatzy.scoreFourOfAKind(new SixSidedDiceRoll(2,2,2,2,5)));
        assertEquals(0, Yatzy.scoreFourOfAKind(new SixSidedDiceRoll(2,2,2,5,5)));
        assertEquals(8, Yatzy.scoreFourOfAKind(new SixSidedDiceRoll(2,2,2,2,2)));
    }

    @Test
    public void scoreSmallStraight_Should_Return15_When_SmallStraightIsProvided() {
        assertEquals(15, Yatzy.scoreSmallStraight(new SixSidedDiceRoll(1,2,3,4,5)));
        assertEquals(15, Yatzy.scoreSmallStraight(new SixSidedDiceRoll(2,3,4,5,1)));
        assertEquals(0, Yatzy.scoreSmallStraight(new SixSidedDiceRoll(1,2,2,4,5)));
    }

    @Test
    public void scoreLargeStraight_Should_Return20_When_largeStraightIsProvided() {
        assertEquals(20, Yatzy.scoreLargeStraight(new SixSidedDiceRoll(6,2,3,4,5)));
        assertEquals(20, Yatzy.scoreLargeStraight(new SixSidedDiceRoll(2,3,4,5,6)));
        assertEquals(0, Yatzy.scoreLargeStraight(new SixSidedDiceRoll(1,2,2,4,5)));
    }

    @Test
    public void scoreFullHouse_Should_SumPairAndThreeOfAKind() {
        assertEquals(18, Yatzy.scoreFullHouse(new SixSidedDiceRoll(6,2,2,2,6)));
        assertEquals(0, Yatzy.scoreFullHouse(new SixSidedDiceRoll(2,3,4,5,6)));
        assertEquals(8, Yatzy.scoreFullHouse(new SixSidedDiceRoll(1,1,2,2,2)));
        assertEquals(0, Yatzy.scoreFullHouse(new SixSidedDiceRoll(2,2,3,3,4)));
        assertEquals(0, Yatzy.scoreFullHouse(new SixSidedDiceRoll(4,4,4,4,4)));
    }
}
