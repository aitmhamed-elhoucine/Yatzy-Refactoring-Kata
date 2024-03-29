import entities.DiceRoll;
import entities.Player;
import entities.Side;
import exceptions.AlreadyPlayedCategoryException;
import exceptions.ExceededCategoriesException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Impl.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
    }


    @Test
    public void scoreChance_Should_SumAllDice() {
        assertEquals(15, gameService.playYatzyGame(new Player(1, new DiceRoll(2,3,4,5,1)), new ChanceCategory()));
        assertEquals(16, gameService.playYatzyGame(new Player(1,new DiceRoll(3,3,4,5,1)), new ChanceCategory()));
    }

    @Test
    public void scoreYatzy_Should_Return50_When_AllDiceHaveTheSameNumber() {
        assertEquals(50, gameService.playYatzyGame(new Player(1, new DiceRoll(4,4,4,4,4)), new YatzyCategory()));
        assertEquals(50, gameService.playYatzyGame(new Player(1, new DiceRoll(6,6,6,6,6)), new YatzyCategory()));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(6,6,6,6,3)), new YatzyCategory()));
        assertEquals(50, gameService.playYatzyGame(new Player(1, new DiceRoll(1,1,1,1,1)), new YatzyCategory()));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(1,1,1,2,1)), new YatzyCategory()));
    }

    @Test
    public void scoreOnes_Should_ReturnSumOfOnes() {
        int one = Side.ONE.getValue();
        assertEquals(1, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,3,4,5)),new SideCategory(one)));
        assertEquals(2, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,1,4,5)),new SideCategory(one)));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(6,2,2,4,5)),new SideCategory(one)));
        assertEquals(4, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,1,1,1)),new SideCategory(one)));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,4,5)),new SideCategory(one)));
    }

    @Test
    public void scoreTwos_Should_ReturnSumOfTwos() {
        int two = Side.TWO.getValue();
        assertEquals(4, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,3,2,6)),new SideCategory(two)));
        assertEquals(10, gameService.playYatzyGame(new Player(1, new DiceRoll(2,2,2,2,2)),new SideCategory(two)));
        assertEquals(4, gameService.playYatzyGame(new Player(1, new DiceRoll(2,3,2,5,1)),new SideCategory(two)));
    }

    @Test
    public void scoreThrees_Should_ReturnSumOfThrees() {
        int three = Side.THREE.getValue();
        assertEquals(6, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,3,2,3)),new SideCategory(three)));
        assertEquals(12, gameService.playYatzyGame(new Player(1, new DiceRoll(2,3,3,3,3)),new SideCategory(three)));
    }

    @Test
    public void scoreFours_Should_ReturnSumOfFours() {
        int four = Side.FOUR.getValue();
        assertEquals(12, gameService.playYatzyGame(new Player(1, new DiceRoll(4,4,4,5,5)), new SideCategory(four)));
        assertEquals(8, gameService.playYatzyGame(new Player(2, new DiceRoll(4,4,5,5,5)), new SideCategory(four)));
        assertEquals(4, gameService.playYatzyGame(new Player(3, new DiceRoll(4,5,5,5,5)), new SideCategory(four)));
        assertEquals(8, gameService.playYatzyGame(new Player(4, new DiceRoll(1,1,2,4,4)), new SideCategory(four)));
    }

    @Test
    public void scoreFives_Should_ReturnSumOfFives() {
        int five = Side.FIVE.getValue();
        assertEquals(10, gameService.playYatzyGame(new Player(1, new DiceRoll(4,4,4,5,5)), new SideCategory(five)));
        assertEquals(15, gameService.playYatzyGame(new Player(2, new DiceRoll(4,4,5,5,5)), new SideCategory(five)));
        assertEquals(20, gameService.playYatzyGame(new Player(3, new DiceRoll(4,5,5,5,5)), new SideCategory(five)));
    }

    @Test
    public void scoreSixes_Should_ReturnSumOfSixes() {
        int six = Side.SIX.getValue();
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(4,4,4,5,5)), new SideCategory(six)));
        assertEquals(6, gameService.playYatzyGame(new Player(2, new DiceRoll(4,4,6,5,5)), new SideCategory(six)));
        assertEquals(18, gameService.playYatzyGame(new Player(3, new DiceRoll(6,5,6,6,5)), new SideCategory(six)));
    }

    @Test
    public void scorePair_Should_ReturnTheSumOfTheTwoHighestMatchingDice() {
        assertEquals(6, gameService.playYatzyGame(new Player(1, new DiceRoll(3,4,3,5,6)), new PairCategory()));
        assertEquals(10, gameService.playYatzyGame(new Player(2, new DiceRoll(5,3,3,3,5)), new PairCategory()));
        assertEquals(12, gameService.playYatzyGame(new Player(3, new DiceRoll(5,3,6,6,5)), new PairCategory()));
        assertEquals(0, gameService.playYatzyGame(new Player(14, new DiceRoll(1,2,3,4,5)), new PairCategory()));
        assertEquals(8, gameService.playYatzyGame(new Player(5, new DiceRoll(3,3,3,4,4)), new PairCategory()));
        assertEquals(12, gameService.playYatzyGame(new Player(6, new DiceRoll(1,1,6,2,6)), new PairCategory()));
        assertEquals(6, gameService.playYatzyGame(new Player(7, new DiceRoll(3,3,3,4,1)), new PairCategory()));
        assertEquals(6, gameService.playYatzyGame(new Player(8, new DiceRoll(3,3,3,3,1)), new PairCategory()));
    }

    @Test
    public void scoreTwoPairs_Should_ReturnSumOfParis_When_TwoPairsOfTheSameNumber() {
        assertEquals(16, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,5,4,5)), new TwoPairsCategory()));
        assertEquals(16, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,5,5,5)), new TwoPairsCategory()));
        assertEquals(8, gameService.playYatzyGame(new Player(1, new DiceRoll(1,1,2,3,3)), new TwoPairsCategory()));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(1,1,2,3,4)), new TwoPairsCategory()));
        assertEquals(6, gameService.playYatzyGame(new Player(1, new DiceRoll(1,1,2,2,2)), new TwoPairsCategory()));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,3,1)), new TwoPairsCategory()));
    }

    @Test
    public void scoreThreeOfAKind_ShouldReturnSumOfThreeDice_WhenThreeDiceWithSameNumber() {
        assertEquals(9, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,4,5)), new NumberOfAKindCategory(3)));
        assertEquals(15, gameService.playYatzyGame(new Player(1, new DiceRoll(5,3,5,4,5)), new NumberOfAKindCategory(3)));
        assertEquals(9, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,3,5)), new NumberOfAKindCategory(3)));
        assertEquals(9, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,3,3)), new NumberOfAKindCategory(3)));
        assertEquals(9, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,4,5)), new NumberOfAKindCategory(3)));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,4,5,6)), new NumberOfAKindCategory(3)));
        assertEquals(9, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,3,1)), new NumberOfAKindCategory(3)));
    }

    @Test
    public void scoreFourOfAKind_ShouldReturnSumOfFourDice_WhenFourDiceWithSameNumber() {
        assertEquals(12, gameService.playYatzyGame(new Player(1, new DiceRoll(3,3,3,3,5)), new NumberOfAKindCategory(4)));
        assertEquals(20, gameService.playYatzyGame(new Player(1, new DiceRoll(5,5,5,4,5)), new NumberOfAKindCategory(4)));
        assertEquals(8, gameService.playYatzyGame(new Player(1, new DiceRoll(2,2,2,2,5)), new NumberOfAKindCategory(4)));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(2,2,2,5,5)), new NumberOfAKindCategory(4)));
        assertEquals(8, gameService.playYatzyGame(new Player(1, new DiceRoll(2,2,2,2,2)), new NumberOfAKindCategory(4)));
    }

    @Test
    public void scoreSmallStraight_Should_Return15_When_SmallStraightIsProvided() {
        assertEquals(15, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,3,4,5)), new SmallStraightCategory()));
        assertEquals(15, gameService.playYatzyGame(new Player(1, new DiceRoll(2,3,4,5,1)), new SmallStraightCategory()));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,2,4,5)), new SmallStraightCategory()));
    }

    @Test
    public void scoreLargeStraight_Should_Return20_When_largeStraightIsProvided() {
        assertEquals(20, gameService.playYatzyGame(new Player(1, new DiceRoll(6,2,3,4,5)), new LargeStraightCategory()));
        assertEquals(20, gameService.playYatzyGame(new Player(1, new DiceRoll(2,3,4,5,6)), new LargeStraightCategory()));
        assertEquals(0, gameService.playYatzyGame(new Player(1, new DiceRoll(1,2,2,4,5)), new LargeStraightCategory()));
    }

    @Test
    public void scoreFullHouse_Should_SumPairAndThreeOfAKind() {
        assertEquals(18,  gameService.playYatzyGame(new Player(1, new DiceRoll(6,2,2,2,6)), new FullHouseCategory()));
        assertEquals(0,  gameService.playYatzyGame(new Player(1, new DiceRoll(2,3,4,5,6)), new FullHouseCategory()));
        assertEquals(8,  gameService.playYatzyGame(new Player(1, new DiceRoll(1,1,2,2,2)), new FullHouseCategory()));
        assertEquals(0,  gameService.playYatzyGame(new Player(1, new DiceRoll(2,2,3,3,4)), new FullHouseCategory()));
        assertEquals(0,  gameService.playYatzyGame(new Player(1, new DiceRoll(4,4,4,4,4)), new FullHouseCategory()));
    }

    @Test
    public void should_throw_ExceededCategoriesException() {

        Player player = new Player(1, new DiceRoll(5,1,1,1,1));

        GameService gameService = new GameService();
        gameService.playYatzyGame(player,new ChanceCategory());
        gameService.playYatzyGame(player,new YatzyCategory());
        gameService.playYatzyGame(player,new SideCategory(1));
        gameService.playYatzyGame(player,new SideCategory(2));
        gameService.playYatzyGame(player,new SideCategory(3));
        gameService.playYatzyGame(player,new SideCategory(4));
        gameService.playYatzyGame(player,new SideCategory(5));
        gameService.playYatzyGame(player,new SideCategory(6));
        gameService.playYatzyGame(player,new PairCategory());
        gameService.playYatzyGame(player,new TwoPairsCategory());
        gameService.playYatzyGame(player,new NumberOfAKindCategory(3));
        gameService.playYatzyGame(player,new NumberOfAKindCategory(4));
        gameService.playYatzyGame(player,new SmallStraightCategory());
        gameService.playYatzyGame(player,new LargeStraightCategory());
        gameService.playYatzyGame(player,new FullHouseCategory());

        Assertions.assertThrows( ExceededCategoriesException.class,()-> gameService.playYatzyGame(player,new ChanceCategory()));
    }

    @Test
    public void should_throw_AlreadyPlayedCategoryException() {

        Player player = new Player(1, new DiceRoll(5,1,1,1,1));

        GameService gameService = new GameService();
        gameService.playYatzyGame(player,new ChanceCategory());
        gameService.playYatzyGame(player,new SideCategory(1));
        gameService.playYatzyGame(player,new SideCategory(2));
        gameService.playYatzyGame(player,new SideCategory(3));
        gameService.playYatzyGame(player,new SideCategory(4));
        gameService.playYatzyGame(player,new SideCategory(5));
        gameService.playYatzyGame(player,new SideCategory(6));

        Assertions.assertThrows( AlreadyPlayedCategoryException.class,()-> gameService.playYatzyGame(player,new ChanceCategory()));
    }

}
