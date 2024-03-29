package entities;

import services.ICategoryService;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private  long id;

    private DiceRoll diceRoll;

    private long score;

    public long getId() {
        return id;
    }

    public DiceRoll getDiceRoll() {
        return diceRoll;
    }

    private List<ICategoryService> playerCategories  ;

    public Player(int id, DiceRoll diceRoll) {
        this.id = id;
        this.diceRoll = diceRoll;
        this.score = 0;
        this.playerCategories = new ArrayList<>(ICategoryService.getAvailableCategories());//devensive copy
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public List<ICategoryService> getPlayerCategories() {
        return playerCategories;
    }


    @Override
    public String toString() {
        return "Player{" +
            "id=" + id +
            ", diceRoll=" + diceRoll +
            ", score=" + score +
            ", playerCategories=" + playerCategories +
            '}';
    }

}
