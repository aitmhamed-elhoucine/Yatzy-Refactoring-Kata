package services;

import entities.Player;

public interface IGameService {

    long playYatzyGame(Player player, ICategoryService categoryService);
}
