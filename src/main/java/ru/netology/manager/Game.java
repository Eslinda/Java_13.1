package ru.netology.manager;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }


    public void register(Player player) {
        players.add(player);

    }

    public int round(String playerName1, String playerName2) {
        Player first = findPlayer(playerName1);
        Player second = findPlayer(playerName2);
        if (first == null)
            throw new NotRegisteredException("Игрок" + playerName1 + "не зарегистрирован.");
        if (second == null)
            throw new NotRegisteredException("Игрок" + playerName2 + "не зарегистрирован.");

        if (first.getStrength() > second.getStrength()) {
            return 1;
        }
        if (first.getStrength() < second.getStrength()) {
            return 2;
        }
        return 0;
    }

    public Player findPlayer(String name) {
        for (Player player : players) {
            if (name == player.getName()) {
                return player;
            }
        }
        return null;
    }

}
