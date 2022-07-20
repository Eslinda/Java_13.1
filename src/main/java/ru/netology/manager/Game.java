package ru.netology.manager;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<String, Player> players;

    public Game() {
        this.players = new HashMap<>();
    }


    public void register(Player player) {
        players.put(player.getName(), player);

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
        if (players.containsKey(name)) {
            return players.get(name);
        }
        return null;
    }

}
