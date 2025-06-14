// --- model/Deck.java ---
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Question> questions;
    private int currentIndex;

    public Deck() {
        questions = new ArrayList<>();
        currentIndex = 0;
        loadQuestions();
        Collections.shuffle(questions);
    }

    private void loadQuestions() {
        questions.add(new Question("¿Cuál es la capital de Francia?",
                new String[]{"Madrid", "Berlín", "París", "Roma"}, 2));
        questions.add(new Question("¿En qué año llegó el hombre a la luna?",
                new String[]{"1969", "1959", "1979", "1989"}, 0));
        questions.add(new Question("¿Cuál es el elemento químico con símbolo O?",
                new String[]{"Oxígeno", "Oro", "Plomo", "Helio"}, 0));
        questions.add(new Question("¿Cuál es el océano más grande del mundo?",
                new String[]{"Atlántico", "Pacífico", "Índico", "Ártico"}, 1));
        questions.add(new Question("¿Quién escribió 'Don Quijote'?",
                new String[]{"Miguel de Cervantes", "Gabriel García Márquez", "Pablo Neruda", "Federico García Lorca"}, 0));
        questions.add(new Question("Cuantos jugadores tiene un equipo de futbol",
                new String[]{"11","5","8","2"},0));
        questions.add(new Question("Cual es el oceano mas pequeño que existe?",
                new String[]{"Atlantico","Pacifico","Indico","Artico"},3));
        questions.add(new Question("Cual es el lenguaje de programacion mejor utilizado para IA",
                new String[]{"Java","Python","C++","JavaScript"},1));

    }

    public Question getNextQuestion() {
        if (questions.isEmpty()) return null;
        Question q = questions.get(currentIndex);
        currentIndex = (currentIndex + 1) % questions.size();
        return q;
    }
}
