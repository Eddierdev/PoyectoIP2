// --- view/QuestionDialog.java ---
package view;

import model.Question;

import javax.swing.*;
import java.awt.*;

public class QuestionDialog {
    private JDialog dialog;
    private Integer selectedAnswer;

    public QuestionDialog(JFrame parent, Question question) {
        dialog = new JDialog(parent, "Pregunta", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        JTextArea questionArea = new JTextArea(question.getText());
        questionArea.setWrapStyleWord(true);
        questionArea.setLineWrap(true);
        questionArea.setEditable(false);
        questionArea.setBackground(null);
        questionArea.setFont(new Font("Arial", Font.BOLD, 16));
        dialog.add(questionArea, BorderLayout.NORTH);

        ButtonGroup group = new ButtonGroup();
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new BoxLayout(optionsPanel, BoxLayout.Y_AXIS));

        JRadioButton[] optionButtons = new JRadioButton[question.getOptions().length];
        for (int i = 0; i < question.getOptions().length; i++) {
            optionButtons[i] = new JRadioButton(question.getOptions()[i]);
            optionButtons[i].setActionCommand(String.valueOf(i));
            group.add(optionButtons[i]);
            optionsPanel.add(optionButtons[i]);
        }

        dialog.add(optionsPanel, BorderLayout.CENTER);

        JButton submitButton = new JButton("Responder");
        submitButton.addActionListener(e -> {
            for (int i = 0; i < optionButtons.length; i++) {
                if (optionButtons[i].isSelected()) {
                    selectedAnswer = i;
                    break;
                }
            }
            dialog.dispose();
        });

        dialog.add(submitButton, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }

    public Integer getSelectedAnswer() {
        return selectedAnswer;
    }
}
