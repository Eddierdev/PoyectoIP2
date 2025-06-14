// --- model/Question.java ---
package model;

public class Question {
    private String text;
    private String[] options;
    private int correctAnswer;

    public Question(String text, String[] options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
