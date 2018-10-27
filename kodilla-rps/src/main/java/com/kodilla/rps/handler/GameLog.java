package com.kodilla.rps.handler;

import com.kodilla.rps.enumerics.ChoiceOption;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameLog {
    private LocalDateTime logTime;
    private ChoiceOption humanChoice;
    private ChoiceOption computerChoice;
    private String result;

    public GameLog(LocalDateTime logTime, ChoiceOption humanChoice, ChoiceOption computerChoice, String result) {
        this.logTime = logTime;
        this.humanChoice = humanChoice;
        this.computerChoice = computerChoice;
        this.result = result;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  logTime.format(formatter) +
                ": player chose: " + humanChoice + '\'' +
                ", computer chose: " + computerChoice + '\'' +
                ", result: " + result + '\'' +
                '}';
    }
}
