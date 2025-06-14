// --- util/SaveLoadManager.java ---
package util;

import model.Deck;
import model.Player;

import java.io.*;
import java.util.List;

public class SaveLoadManager {

    public static class GameState implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        public List<Player> players;
        public int currentPlayerIndex;
        public Deck deck;
        public int timeSeconds;

        public GameState(List<Player> players, int currentPlayerIndex, Deck deck, int timeSeconds) {
            this.players = players;
            this.currentPlayerIndex = currentPlayerIndex;
            this.deck = deck;
            this.timeSeconds = timeSeconds;
        }
    }

    public static void saveGame(String filename, List<Player> players, int currentPlayerIndex, Deck deck, int timeSeconds) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            GameState state = new GameState(players, currentPlayerIndex, deck, timeSeconds);
            out.writeObject(state);

        }

    }

    public static GameState loadGame(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (GameState) in.readObject();
        }
    }
}
