package services.Impl;

import services.ICategoryService;
import entities.Player;
import exceptions.AlreadyPlayedCategoryException;
import exceptions.ExceededCategoriesException;
import services.IGameService;

public class GameService implements IGameService {

    @Override
    public long playYatzyGame(Player player, ICategoryService categoryService) {

        if (player.getPlayerCategories().isEmpty()) {
            throw new ExceededCategoriesException("The game is done");
        }

        if (!player.getPlayerCategories().contains(categoryService)) {
            throw new AlreadyPlayedCategoryException("Already played category, choose an unplayed one");
        }

        player.getPlayerCategories().remove(categoryService);

        long score = categoryService.score(player.getDiceRoll());
        player.setScore(player.getScore() + score);

        System.out.println("Player " + player.getId() + " gotta a score of :" + player.getScore());
        return score;
    }
}
