package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Game;

public class TournamentTest {
    Game game = new Game();
    Player player1 = new Player(1, "First", 20);
    Player player2 = new Player(2, "Second", 220);
    Player player3 = new Player(3, "Third", 220);
    Player player4 = new Player(4, "Fourth", 384);
    Player player5 = new Player(5, "Fifth", 115);


    @BeforeEach
    public void addPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
    }

    @Test
    public void shouldFirstWin() {
        int actual = game.round(player4.getName(), player2.getName());

        assertEquals(1, actual);
    }

    @Test
    public void shouldSecondWin() {
        int actual = game.round(player1.getName(), player3.getName());

        assertEquals(2, actual);
    }

    @Test
    public void shouldDraw() {
        int actual = game.round(player2.getName(), player3.getName());

        assertEquals(0, actual);
    }

    @Test
    public void shouldThrowExceptionThirstPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round(player5.getName(), player1.getName());
        });
    }

    @Test
    public void shouldThrowExceptionSecondPlayer() {
        assertThrows(NotRegisteredException.class, () -> {
            game.round(player2.getName(), player5.getName());
        });
    }

}
