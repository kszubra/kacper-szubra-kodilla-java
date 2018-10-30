package com.kodilla.rps;

import com.kodilla.rps.enumerics.ChoiceOption;
import com.kodilla.rps.enumerics.RoundResult;
import com.kodilla.rps.handler.GameLog;
import com.kodilla.rps.handler.IfNumber;
import com.kodilla.rps.handler.Rules;
import com.kodilla.rps.players.ComputerPlayer;
import com.kodilla.rps.players.HumanPlayer;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private boolean end = false;

    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private int roundsToWinTheGame;
    private ChoiceOption humanChoice;
    private ChoiceOption computerChoice;
    private List<GameLog> gameLog;
    private RoundResult roundResult;
    private String gameLogPath;
    private LocalDateTime gameStartTime;

    private void endGame(){

        System.exit(0);
    }

    private ChoiceOption getHumanChoice() {
        System.out.println("\r\nPlease give your choice");

        Scanner scanner = new Scanner(System.in);
        ChoiceOption choice = null;
        char pressedKey=scanner.nextLine().charAt(0);

        switch (pressedKey) {
            case '1':
                choice = ChoiceOption.ROCK;
                break;
            case '2':
                choice = ChoiceOption.PAPER;
                break;
            case '3':
                choice = ChoiceOption.SCISSORS;
                break;
            case '4':
                choice = ChoiceOption.SPOCK;
                break;
            case '5':
                choice = ChoiceOption.LIZARD;
                break;
            case 'x':
            case 'X':
                System.out.println("Are you sure you want to exit? Y/N");
                char decision = scanner.next().charAt(0);
                if(decision=='y' || decision == 'Y') {
                    endGame();
                }
                break;
            case 'n':
            case 'N':
                System.out.println("Are you sure you want to start a new game? Y/N");
                decision = scanner.next().charAt(0);
                if(decision=='y' || decision == 'Y') {
                    startNewGame();
                }
                break;
             default:
                 System.out.println("Wrong! Please choose between: 1,2,3,4,5,x,n");
                 return getHumanChoice();
        }

        System.out.println("Your choice: " + choice);
        return choice;
    }

    public void askRoundsToWinAmount () throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(humanPlayer.getName() + ", till how many won rounds will the game last?");
        String input = scanner.nextLine();

        if(input.equals("x") || input.equals("X")) {
            System.out.println("Are you sure you want to exit? Y/N");
            char decision = scanner.next().charAt(0);
            if(decision=='y' || decision == 'Y') {
                endGame();
            }
        }

        if(input.equals("n") || input.equals("N")) {
            System.out.println("Are you sure you want to start a new game? Y/N");
            char decision = scanner.next().charAt(0);
            if(decision=='y' || decision == 'Y') {
                startNewGame();
            }
        }

        if(IfNumber.isItInteger(input)){

            roundsToWinTheGame = Integer.parseInt(input);

        } else {
            System.out.println("This is not an integer value.");
            askRoundsToWinAmount();
        }
    }

    public void saveLogToFile(){

        FileWriter fileWriter = null;
        String dataToSave = gameLog.stream()
                .map(n->n.toString())
                .collect(Collectors.joining("\r\n"));

        try {
            fileWriter = new FileWriter(gameLogPath);
            fileWriter.write(dataToSave);

        } catch (Exception e){
            System.out.println("Exception: " + e.toString());

        } finally {

            if(fileWriter != null){
                try{
                    fileWriter.close();
                } catch (Exception e){
                    System.out.println("Exception: " + e.toString());
                }
            }
        }
    }

    public void startNewGame() {
        gameStartTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        gameLogPath = "/log_" + gameStartTime.format(formatter) + ".txt";

        Scanner scanner = new Scanner(System.in);
        boolean properRoundNumber = false;
        computerPlayer = new ComputerPlayer();
        gameLog = new ArrayList<>();

        System.out.println("Starting new game. Please enter your name:");
        humanPlayer = new HumanPlayer(scanner.next());
        if(humanPlayer.getName().equals("x") || humanPlayer.getName().equals("X")) {
            System.out.println("Are you sure you want to exit? Y/N");
            char decision = scanner.next().charAt(0);
            if(decision=='y' || decision == 'Y') {
                endGame();
            }
        }

        if(humanPlayer.getName().equals("n") || humanPlayer.getName().equals("N")) {
            System.out.println("Are you sure you want to start a new game? Y/N");
            char decision = scanner.next().charAt(0);
            if(decision=='y' || decision == 'Y') {
                startNewGame();
            }
        }

        while(!properRoundNumber){
            try{
                askRoundsToWinAmount();
                properRoundNumber = true;

            } catch(InputMismatchException e){
                System.out.println("This is not an integer value!");
            }
        }

        System.out.println("Thank you. Lets get the game started. You start:");

        while (!this.end) {
            humanChoice = getHumanChoice();
            computerChoice = computerPlayer.getComputerChoice(humanChoice);
            roundResult = Rules.tellWinner(humanChoice, computerChoice);

            if(roundResult.equals(RoundResult.HUMAN_WINS)) {
                System.out.println(humanPlayer.getName() + " won!");
                humanPlayer.addWonRound();
                gameLog.add(new GameLog(LocalDateTime.now(), humanChoice, computerChoice, humanPlayer.getName() + " won"));
                System.out.println("Rounds won by computer: " + computerPlayer.getWonRoundsNumber() + "/"+ roundsToWinTheGame);
                System.out.println("Rounds won by " + humanPlayer.getName() + " : " + humanPlayer.getWonRoundsNumber() + "/" + roundsToWinTheGame);

            }

            if(roundResult.equals(RoundResult.COMPUTER_WINS)) {
                System.out.println("Computer won!");
                computerPlayer.addWonRound();
                gameLog.add(new GameLog(LocalDateTime.now(), humanChoice, computerChoice, "Computer won"));
                System.out.println("Rounds won by computer: " + computerPlayer.getWonRoundsNumber() + "/" + roundsToWinTheGame);
                System.out.println("Rounds won by " + humanPlayer.getName() + " : " + humanPlayer.getWonRoundsNumber() + "/" + roundsToWinTheGame);

            }

            if(roundResult.equals(RoundResult.DRAW)) {
                System.out.println("Draw!");
                gameLog.add(new GameLog(LocalDateTime.now(), humanChoice, computerChoice, "Draw"));
                System.out.println("Rounds won by computer: " + computerPlayer.getWonRoundsNumber() + "/" + roundsToWinTheGame);
                System.out.println("Rounds won by " + humanPlayer.getName() + " : " + humanPlayer.getWonRoundsNumber() + "/" + roundsToWinTheGame);
            }

            if (humanPlayer.getWonRoundsNumber() == roundsToWinTheGame) {
                System.out.println(humanPlayer.getName() + " won the game!");
                saveLogToFile();
                System.out.println("Do you want to start a new game? Y/N");
                char decision = scanner.next().charAt(0);
                switch (decision){
                    case 'y':
                    case 'Y':
                        startNewGame();
                    default:
                        endGame();
                }
            }
            if (computerPlayer.getWonRoundsNumber() == roundsToWinTheGame) {
                System.out.println("Computer won the game!");
                saveLogToFile();
                System.out.println("Do you want to start a new game? Y/N");
                char decision = scanner.next().charAt(0);
                switch (decision){
                    case 'y':
                    case 'Y':
                        startNewGame();
                    default:
                        endGame();
                }
            }
        }
    }
}
