// --- util/TimerThread.java ---
package util;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class TimerThread extends Thread {
    private JLabel timerLabel;
    private boolean running;
    private int secondsElapsed;

    public TimerThread(JLabel timerLabel) {
        this.timerLabel = timerLabel;
        this.running = true;
        this.secondsElapsed = 0;
    }

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        while (running) {
            try {
                Thread.sleep(1000);
                secondsElapsed++;
                int hrs = secondsElapsed / 3600;
                int mins = (secondsElapsed % 3600) / 60;
                int secs = secondsElapsed % 60;
                final String time = String.format("%02d:%02d:%02d", hrs, mins, secs);
                SwingUtilities.invokeLater(() -> timerLabel.setText("Tiempo: " + time));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopTimer() {
        running = false;
    }

    public int getSecondsElapsed() {
        return secondsElapsed;
    }

    public void setSecondsElapsed(int secondsElapsed) {
        this.secondsElapsed = secondsElapsed;
    }
}
