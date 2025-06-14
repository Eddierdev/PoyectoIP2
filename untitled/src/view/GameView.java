// --- view/GameView.java ---
package view;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameView {
    private JFrame frame;
    private JPanel boardPanel;
    private JPanel playersPanel;
    private JLabel timerLabel;
    private JButton rollDiceButton;
    private JTextArea messagesArea;
    private JLabel currentPlayerLabel;

    public GameView() {
        frame = new JFrame("Juego de Preguntas - Trivia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Tablero panel (simple visual con casillas)
        boardPanel = new JPanel(new GridLayout(5, 10));
        for (int i = 0; i < 50; i++) {
            JLabel tileLabel = new JLabel("" + (i + 1), SwingConstants.CENTER);
            tileLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
            boardPanel.add(tileLabel);
        }

        frame.add(boardPanel, BorderLayout.CENTER);

        // Panel lateral con info y controles
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());

        // Info jugadores
        playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPlayers = new JScrollPane(playersPanel);
        scrollPlayers.setPreferredSize(new Dimension(200, 250));

        sidePanel.add(scrollPlayers, BorderLayout.NORTH);

        // Mensajes
        messagesArea = new JTextArea(8, 20);
        messagesArea.setEditable(false);
        JScrollPane scrollMessages = new JScrollPane(messagesArea);
        sidePanel.add(scrollMessages, BorderLayout.CENTER);

        // Controles
        JPanel controlPanel = new JPanel(new FlowLayout());

        rollDiceButton = new JButton("Tirar dado");
        controlPanel.add(rollDiceButton);

        currentPlayerLabel = new JLabel("Turno: ");
        controlPanel.add(currentPlayerLabel);

        timerLabel = new JLabel("Tiempo: 00:00:00");
        controlPanel.add(timerLabel);

        sidePanel.add(controlPanel, BorderLayout.SOUTH);

        frame.add(sidePanel, BorderLayout.EAST);

        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getRollDiceButton() {
        return rollDiceButton;
    }

    public JLabel getTimerLabel() {
        return timerLabel;
    }

    public void updatePlayersPositions(List<Player> players) {
        playersPanel.removeAll();
        for (Player p : players) {
            JLabel label = new JLabel(p.getName() + " - Casilla: " + (p.getPosition() + 1));
            label.setForeground(Color.decode(p.getColor()));
            playersPanel.add(label);
        }
        playersPanel.revalidate();
        playersPanel.repaint();
    }

    public void updateCurrentPlayer(Player player) {
        currentPlayerLabel.setText("Turno: " + player.getName());
    }

    public void showMessage(String message) {
        messagesArea.append(message + "\n");
        messagesArea.setCaretPosition(messagesArea.getDocument().getLength());
    }

    public void disableRollDice() {
        rollDiceButton.setEnabled(false);
    }

    public void enableRollDice() {
        rollDiceButton.setEnabled(true);
    }
}
