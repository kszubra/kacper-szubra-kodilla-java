package tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import tictactoe.enumerics.CellStatus;
import tictactoe.mechanics.Game;
import tictactoe.mechanics.Rules;
import tictactoe.popupboxes.ConfirmationBox;
import tictactoe.popupboxes.MessageBox;
import tictactoe.popupboxes.NewGameBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TicTacToeRunner extends Application {

    private static final double SCREEN_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
    private static final double SCREEN_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();

    public static final Image IMAGE_FOR_BACKGROUND = new Image("Graphics/background.jpg");
    public static final Image IMAGE_FOR_GAME_BOARD = new Image("Graphics/board.jpg");
    public static final Image IMAGE_FOR_X = new Image("Graphics/cross.png");
    public static final Image IMAGE_FOR_O = new Image("Graphics/circle.png");
    public static final Image ANIMATION_FOR_X = new Image("Graphics/Draw_X_Anim.gif");
    public static final Image ANIMATION_FOR_O = new Image("Graphics/Draw_O_Anim.gif");
    public static final Image IMAGE_FOR_CURSOR = new Image("Graphics/cursorIcon.png");
    public static final Image IMAGE_FOR_EMPTY_FIELD = new Image("Graphics/transparent.png");

    private Button exitButton, newGameButton;
    private VBox buttons;

    GridPane gameBoardPane;

    private ImageView cellImage00;
    private ImageView cellImage01;
    private ImageView cellImage02;
    private ImageView cellImage10;
    private ImageView cellImage11;
    private ImageView cellImage12;
    private ImageView cellImage20;
    private ImageView cellImage21;
    private ImageView cellImage22;
    private List<ImageView> gameCellsList;

    private Game currentGame;

    public void newGame() {

        for (ImageView image : gameCellsList){
            image.setImage(IMAGE_FOR_EMPTY_FIELD);
        }
        currentGame = new Game(NewGameBox.getUserPreference());

        if(!currentGame.getHumanStarts()){ // computer's opening move
            messageBoard.setText("Computer's turn");
            currentGame.setHumanTurn(false);
            currentGame.makeComputerMove();
            int[] chosenByComputer = {currentGame.getComputerChoiceRow(), currentGame.getComputerChoiceColumn()};
            if (chosenByComputer[0] == 0 && chosenByComputer[1] == 0){
                cellImage00.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 0 && chosenByComputer[1] == 1){
                cellImage01.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 0 && chosenByComputer[1] == 2){
                cellImage02.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 1 && chosenByComputer[1] == 0){
                cellImage10.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 1 && chosenByComputer[1] == 1){
                cellImage11.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 1 && chosenByComputer[1] == 2){
                cellImage12.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 2 && chosenByComputer[1] == 0){
                cellImage20.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 2 && chosenByComputer[1] == 1){
                cellImage21.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 2 && chosenByComputer[1] == 2){
                cellImage22.setImage(IMAGE_FOR_O);
            }
        } else {
            currentGame.setHumanTurn(true);
            messageBoard.setText(currentGame.getHumanPlayerName() + "'s turn");
        }
    }



    public void handleMouseEntersCell(MouseEvent event){

        ImageView eventObject = (ImageView) event.getSource();

        if(gameCellsList.contains(eventObject) && eventObject.getImage().equals(IMAGE_FOR_EMPTY_FIELD)){
            eventObject.setImage(ANIMATION_FOR_X);
        }
    }

    public void handleMouseExitsCell(MouseEvent event){

        ImageView eventObject = (ImageView) event.getSource();

        if(gameCellsList.contains(eventObject) && eventObject.getImage().equals(ANIMATION_FOR_X)){
            eventObject.setImage(IMAGE_FOR_EMPTY_FIELD);
        }
    }

    public void handleMouseClickCell(MouseEvent event){

        ImageView eventObject = (ImageView) event.getSource();


        if(!(currentGame.getHumanTurn())){
            MessageBox.displayMessage("Wrong turn","It's not your turn now. Please wait");
        } else if((currentGame.getHumanTurn()) && !(eventObject.getImage().equals(ANIMATION_FOR_X))){
            MessageBox.displayMessage("Cell taken","This cell is already taken. Please choose different one");

        } else if((currentGame.getHumanTurn()) && (eventObject.getImage().equals(ANIMATION_FOR_X))){
            eventObject.setImage(IMAGE_FOR_X);
            int rowIndex = GridPane.getRowIndex(eventObject);
            int columnIndex = GridPane.getColumnIndex(eventObject);
            System.out.println("Row: " + rowIndex + ", Column: " + columnIndex);
            currentGame.setGameMatrixValue(rowIndex, columnIndex, CellStatus.CROSS);
            currentGame.setHumanTurn(false);

            // COMPUTER MOVE HERE
            currentGame.makeComputerMove();
            // make image on board change
            int[] chosenByComputer = {currentGame.getComputerChoiceRow(), currentGame.getComputerChoiceColumn()};
            if (chosenByComputer[0] == 0 && chosenByComputer[1] == 0){
                cellImage00.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 0 && chosenByComputer[1] == 1){
                cellImage01.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 0 && chosenByComputer[1] == 2){
                cellImage02.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 1 && chosenByComputer[1] == 0){
                cellImage10.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 1 && chosenByComputer[1] == 1){
                cellImage11.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 1 && chosenByComputer[1] == 2){
                cellImage12.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 2 && chosenByComputer[1] == 0){
                cellImage20.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 2 && chosenByComputer[1] == 1){
                cellImage21.setImage(IMAGE_FOR_O);
            }
            if (chosenByComputer[0] == 2 && chosenByComputer[1] == 2){
                cellImage22.setImage(IMAGE_FOR_O);
            }

            /**
            for(Node node : gameBoardPane.getChildren()) {
                if((GridPane.getRowIndex(node).equals(currentGame.getComputerChoiceRow())) && (GridPane.getColumnIndex(node).equals(currentGame.getComputerChoiceColumn()))){
                    (ImageView)node.get
                }
            }

            chosenByComputer = (ImageView) gameBoardPane.getChildren().stream()
                    .filter(e -> (GridPane.getColumnIndex(e).equals(currentGame.getComputerChoiceColumn())))
                    .filter(e -> (GridPane.getRowIndex(e).equals(currentGame.getComputerChoiceRow())))
                    .findAny().get();

            chosenByComputer.setImage(IMAGE_FOR_O);

             */


            currentGame.setWinner(Rules.checkGameMatrixForWinner(currentGame.getGameMatrix()));
            List<CellStatus> gameMatrixElements = Arrays.stream(currentGame.getGameMatrix())
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toList());

            if(currentGame.getWinner().equals(CellStatus.CROSS)){

                MessageBox.displayMessage("Round finished",currentGame.getHumanPlayerName()+ " won!");

            } else if(currentGame.getWinner().equals(CellStatus.CIRCLE)){

                MessageBox.displayMessage("Round finished","Computer won!");

            } else if((!gameMatrixElements.contains(CellStatus.EMPTY)) && (currentGame.getWinner().equals(CellStatus.EMPTY))){

                MessageBox.displayMessage("Round finished","Draw!");

            }
        }

     }

    private HBox topScoreBoard;
    private Text messageBoard;


    @Override
    public void start(Stage primaryStage) throws Exception {

        gameCellsList = new ArrayList<>();

        Media soundFile = new Media("file:///D:/Programowanie_Java/kodilla-course/kodilla-ttt/src/main/resources/Sounds/Darsilon.mp3");
        MediaPlayer player = new MediaPlayer(soundFile);
        player.play();

        exitButton = new Button("Exit");
        exitButton.setMinSize(200, 50);
        exitButton.setOnMouseClicked(e->{
            if(ConfirmationBox.getDecision("Quit game","Are you sure you want to quit?")){System.exit(0);}
        });

        newGameButton = new Button("New game");
        newGameButton.setMinSize(200, 50);
        newGameButton.setOnMouseClicked(e->{
            if(ConfirmationBox.getDecision("New game","Are you sure you want to start a new game?")){
                newGame();
            }
        });

        buttons = new VBox(exitButton, newGameButton);
        buttons.setSpacing(50);

        messageBoard = new Text();
        messageBoard.setFont(Font.font("Verdana", 45));
        messageBoard.setFill(Color.AQUA);

        topScoreBoard = new HBox(messageBoard);
        topScoreBoard.setSpacing(15);


        BackgroundSize backgroundSize = new BackgroundSize(SCREEN_WIDTH*0.6,SCREEN_HEIGHT*0.6, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(IMAGE_FOR_BACKGROUND, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        BackgroundSize boardBackgroundSize = new BackgroundSize(IMAGE_FOR_GAME_BOARD.getWidth(), IMAGE_FOR_BACKGROUND.getHeight(), true, true, true, false);
        BackgroundImage boardBackgroundImage = new BackgroundImage(IMAGE_FOR_GAME_BOARD, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardBackgroundSize);
        Background boardBackground = new Background(boardBackgroundImage);

        gameBoardPane = new GridPane();
        gameBoardPane.setGridLinesVisible(true);
        gameBoardPane.setCursor(new ImageCursor(IMAGE_FOR_CURSOR));
        gameBoardPane.setMaxSize(409, 409);
        gameBoardPane.setAlignment(Pos.CENTER);
        gameBoardPane.setBackground(boardBackground);
        gameBoardPane.setPadding(new Insets(10, 10, 10, 10));
        gameBoardPane.setHgap(5);
        gameBoardPane.setVgap(5);

        cellImage00 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage00);
        gameBoardPane.add(cellImage00, 0,0);
        cellImage00.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage00.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage00.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage01 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage01);
        gameBoardPane.add(cellImage01, 1,0);
        cellImage01.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage01.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage01.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage02 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage02);
        gameBoardPane.add(cellImage02, 2,0);
        cellImage02.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage02.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage02.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage10 = new ImageView(IMAGE_FOR_O);
        gameCellsList.add(cellImage10);
        gameBoardPane.add(cellImage10, 0,1);
        cellImage10.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage10.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage10.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage11 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage11);
        gameBoardPane.add(cellImage11, 1,1);
        cellImage11.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage11.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage11.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage12 = new ImageView(IMAGE_FOR_O);
        gameCellsList.add(cellImage12);
        gameBoardPane.add(cellImage12, 2,1);
        cellImage12.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage12.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage12.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage20 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage20);
        gameBoardPane.add(cellImage20, 0,2);
        cellImage20.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage20.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage20.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage21 = new ImageView(IMAGE_FOR_O);
        gameCellsList.add(cellImage21);
        gameBoardPane.add(cellImage21, 1,2);
        cellImage21.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage21.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage21.setOnMouseClicked(e->handleMouseClickCell(e));

        cellImage22 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage22);
        gameBoardPane.add(cellImage22, 2,2);
        cellImage22.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage22.setOnMouseExited(e->handleMouseExitsCell(e));
        cellImage22.setOnMouseClicked(e->handleMouseClickCell(e));

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background);
        borderPane.setCenter(gameBoardPane);
        borderPane.setLeft(buttons);
        borderPane.setTop(topScoreBoard);
        topScoreBoard.setAlignment(Pos.CENTER);

        Scene scene = new Scene(borderPane, IMAGE_FOR_BACKGROUND.getWidth(), IMAGE_FOR_BACKGROUND.getHeight(), Color.BLACK);

        primaryStage.setTitle("Tick Tack Toe");
        primaryStage.setResizable(false);

        primaryStage.initStyle(StageStyle.UNIFIED);

        primaryStage.setOpacity(1);

        primaryStage.setScene(scene);
        primaryStage.show();

        newGame();


        }

    public static void main(String[] args) {
        launch(args);

    }

}
