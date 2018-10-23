package com.kodilla.rps;

import com.kodilla.rps.choices.ChoiceOption;
import com.kodilla.rps.handler.GameLog;
import com.kodilla.rps.handler.Rules;
import com.kodilla.rps.players.ComputerPlayer;
import com.kodilla.rps.players.HumanPlayer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private int roundsToWinTheGame;
    private ChoiceOption humanChoice;
    private ChoiceOption computerChoice;
    private boolean end;
    private List<GameLog> gameLog;
    private int roundResult;

    private void endGame(){
        this.end=true;
    }

    private ChoiceOption getHumanChoice(){
        Scanner scanner = new Scanner(System.in);
        ChoiceOption choice = null;
        char pressedKey=0;

        System.out.println("\r\nPlease give your choice");
        pressedKey = scanner.nextLine().charAt(0);

        switch (pressedKey){
            case '1':
                choice = ChoiceOption.rock;
                break;
            case '2':
                choice = ChoiceOption.paper;
                break;
            case '3':
                choice = ChoiceOption.scissors;
                break;
            case '4':
                choice = ChoiceOption.spock;
                break;
            case '5':
                choice = ChoiceOption.lizard;
                break;
            case 'x':
                System.out.println("Are you sure you want to exit? Y/N");
                char decision = scanner.next().charAt(0);
                if(decision=='y' || decision == 'Y'){endGame();}
                break;
            case 'n':
                System.out.println("Are you sure you want to start a new game? Y/N");
                decision = scanner.next().charAt(0);
                if(decision=='y' || decision == 'Y'){startNewGame();}
                break;
        }

        System.out.println("Your choice: " + choice);
        return choice;

    }

    public void startNewGame(){
        Scanner scanner = new Scanner(System.in);
        computerPlayer = new ComputerPlayer();
        gameLog = new ArrayList<GameLog>();
        System.out.println("Starting new game. Please enter your name:");
        humanPlayer = new HumanPlayer(scanner.next());
        System.out.println(humanPlayer.getName()+", till how many won rounds will the game last?");
        roundsToWinTheGame = scanner.nextInt();
        System.out.println("Thank you. Lets get the game started. You start:");

        while(!this.end){
            humanChoice = getHumanChoice();
            computerChoice = computerPlayer.getComputerChoice(humanChoice);
            roundResult = Rules.tellWinner(humanChoice, computerChoice);
            if(roundResult == 1){
                System.out.println(humanPlayer.getName() +" won!");
                humanPlayer.addWonRound();
                gameLog.add(new GameLog(LocalDateTime.now(),humanChoice, computerChoice, humanPlayer.getName()+ " won"));
                System.out.println("Rounds won by computer: " + computerPlayer.getWonRoundsNumber()+"/"+roundsToWinTheGame);
                System.out.println("Rounds won by "+humanPlayer.getName() + " : " + humanPlayer.getWonRoundsNumber()+"/"+roundsToWinTheGame);

            } if(roundResult == 2){
                System.out.println("Computer won!");
                computerPlayer.addWonRound();
                gameLog.add(new GameLog(LocalDateTime.now(),humanChoice, computerChoice, "Computer won"));
                System.out.println("Rounds won by computer: " + computerPlayer.getWonRoundsNumber()+"/"+roundsToWinTheGame);
                System.out.println("Rounds won by "+humanPlayer.getName() + " : " + humanPlayer.getWonRoundsNumber()+"/"+roundsToWinTheGame);

            } if(roundResult == 0){
                System.out.println("Draw!");
                gameLog.add(new GameLog(LocalDateTime.now(),humanChoice, computerChoice, "Draw"));
                System.out.println("Rounds won by computer: " + computerPlayer.getWonRoundsNumber()+"/"+roundsToWinTheGame);
                System.out.println("Rounds won by "+humanPlayer.getName() + " : " + humanPlayer.getWonRoundsNumber()+"/"+roundsToWinTheGame);
            }

            if (humanPlayer.getWonRoundsNumber() == roundsToWinTheGame){
                System.out.println(humanPlayer.getName()+" won the game!");
                endGame();
            } if (computerPlayer.getWonRoundsNumber() == roundsToWinTheGame){
                System.out.println("Computer won the game!");
                endGame();
            }

        }

    }
}
