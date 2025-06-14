import controller.GameController;
import model.Player;
import view.GameView;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear jugadores
        Player jugador1 = new Player("Jugador 1");
        Player jugador2 = new Player("Jugador 2");
        List<Player> players = new ArrayList<>();
        players.add(jugador1);
        players.add(jugador2);

        // Crear vista
        GameView view = new GameView();

        // Asignar íconos a los jugadores (puedes dejar vacío si no usas imágenes)
        Map<Player, ImageIcon> icons = new HashMap<>();
        icons.put(jugador1, new ImageIcon());  // Sin imagen específica
        icons.put(jugador2, new ImageIcon());
        view.setPlayerIcons(icons);

        // Crear controlador
        GameController controller = new GameController(players, view);

        // Panel de botones
        JPanel controlPanel = new JPanel(new FlowLayout());
        JButton btnLanzar = new JButton("Lanzar dado");
        controlPanel.add(btnLanzar);

        view.add(controlPanel, BorderLayout.NORTH);

        // Acción del botón
        btnLanzar.addActionListener(e -> controller.nextTurn());

        // Iniciar juego
        controller.startGame();
    }
}
