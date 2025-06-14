package controller;

import model.Player;
import view.GameView;

import java.util.List;

public class GameController {

    private List<Player> players;
    private int currentPlayerIndex;
    private GameView view;

    public GameController(List<Player> players, GameView view) {
        this.players = players;
        this.view = view;
        this.currentPlayerIndex = 0;
    }

    public void startGame() {
        view.updatePlayerPositions(players);
        updateView();
    }

    public void nextTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        int diceRoll = rollDice();
        int newPos = (currentPlayer.getPosition() + diceRoll) % 30;
        currentPlayer.setPosition(newPos);
        view.updatePlayerPositions(players);
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        updateView();
    }

    private int rollDice() {
        return (int)(Math.random() * 6) + 1;
    }

    private void updateView() {
        view.updateTurnInfo(players.get(currentPlayerIndex));
    }
}
