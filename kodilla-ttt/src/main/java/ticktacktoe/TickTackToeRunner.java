package ticktacktoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;


public class TickTackToeRunner extends Application {

    private static final double SCREEN_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
    private static final double SCREEN_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();

    private static final Image IMAGE_FOR_BACKGROUND = new Image("Graphics/background.jpg");
    private static final Image IMAGE_FOR_GAME_BOARD = new Image("Graphics/board.jpg");
    private static final Image IMAGE_FOR_X = new Image("Graphics/cross.png");
    private static final Image IMAGE_FOR_O = new Image("Graphics/circle.png");
    private static final Image ANIMATION_FOR_X = new Image("Graphics/Draw_X_Anim.gif");
    private static final Image ANIMATION_FOR_O = new Image("Graphics/Draw_O_Anim.gif");
    private static final Image IMAGE_FOR_CURSOR = new Image("Graphics/cursorIcon.png");
    private static final Image IMAGE_FOR_EMPTY_FIELD = new Image("Graphics/transparent.png");

    private Button exitButton, newGameButton;
    private VBox buttons;

    private ImageView cellImage11;
    private ImageView cellImage12;
    private ImageView cellImage13;
    private ImageView cellImage21;
    private ImageView cellImage22;
    private ImageView cellImage23;
    private ImageView cellImage31;
    private ImageView cellImage32;
    private ImageView cellImage33;
    private List<ImageView> gameCellsList;

    public void handleButtonClick(MouseEvent event){

        if(event.getSource().equals(exitButton)){
            System.exit(0);
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

    private HBox topScoreBoard;
    private Text playerOneName, playerOneScore, playerTwoName, playerTwoScore;


    @Override
    public void start(Stage primaryStage) throws Exception {

        gameCellsList = new ArrayList<>();

        exitButton = new Button("Exit");
        exitButton.setOnMouseClicked(e->handleButtonClick(e));

        newGameButton = new Button("New game");
        exitButton.setOnMouseClicked(e->handleButtonClick(e));

        buttons = new VBox(exitButton, newGameButton);
        buttons.setSpacing(50);

        playerOneName = new Text("Player One: ");
        playerOneName.setFont(Font.font("Verdana", 45));
        playerOneName.setFill(Color.AQUA);

        playerOneScore = new Text("0");
        playerOneScore.setFont(Font.font("Verdana", 45));
        playerOneScore.setFill(Color.AQUA);

        playerTwoName = new Text("Computer: ");
        playerTwoName.setFont(Font.font("Verdana", 45));
        playerTwoName.setFill(Color.AQUA);

        playerTwoScore = new Text("0");
        playerTwoScore.setFont(Font.font("Verdana", 45));
        playerTwoScore.setFill(Color.AQUA);

        topScoreBoard = new HBox(playerOneName, playerOneScore, playerTwoName, playerTwoScore);
        topScoreBoard.setSpacing(15);


        BackgroundSize backgroundSize = new BackgroundSize(SCREEN_WIDTH*0.6,SCREEN_HEIGHT*0.6, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(IMAGE_FOR_BACKGROUND, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        BackgroundSize boardBackgroundSize = new BackgroundSize(IMAGE_FOR_GAME_BOARD.getWidth(), IMAGE_FOR_BACKGROUND.getHeight(), true, true, true, false);
        BackgroundImage boardBackgroundImage = new BackgroundImage(IMAGE_FOR_GAME_BOARD, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardBackgroundSize);
        Background boardBackground = new Background(boardBackgroundImage);

        GridPane gameBoardPane = new GridPane();
        gameBoardPane.setCursor(new ImageCursor(IMAGE_FOR_CURSOR));
        gameBoardPane.setMaxSize(409, 409);
        gameBoardPane.setAlignment(Pos.CENTER);
        gameBoardPane.setBackground(boardBackground);
        gameBoardPane.setPadding(new Insets(10, 10, 10, 10));
        gameBoardPane.setHgap(5);
        gameBoardPane.setVgap(5);

        cellImage11 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage11);
        gameBoardPane.add(cellImage11, 1,1);
        cellImage11.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage11.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage12 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage12);
        gameBoardPane.add(cellImage12, 2,1);
        cellImage12.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage12.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage13 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage13);
        gameBoardPane.add(cellImage13, 3,1);
        cellImage13.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage13.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage21 = new ImageView(IMAGE_FOR_O);
        gameCellsList.add(cellImage21);
        gameBoardPane.add(cellImage21, 1,2);
        cellImage21.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage21.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage22 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage22);
        gameBoardPane.add(cellImage22, 2,2);
        cellImage22.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage22.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage23 = new ImageView(IMAGE_FOR_O);
        gameCellsList.add(cellImage23);
        gameBoardPane.add(cellImage23, 3,2);
        cellImage23.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage23.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage31 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage31);
        gameBoardPane.add(cellImage31, 1,3);
        cellImage31.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage31.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage32 = new ImageView(IMAGE_FOR_O);
        gameCellsList.add(cellImage32);
        gameBoardPane.add(cellImage32, 2,3);
        cellImage32.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage32.setOnMouseExited(e->handleMouseExitsCell(e));

        cellImage33 = new ImageView(IMAGE_FOR_EMPTY_FIELD);
        gameCellsList.add(cellImage33);
        gameBoardPane.add(cellImage33, 3,3);
        cellImage33.setOnMouseEntered(e->handleMouseEntersCell(e));
        cellImage33.setOnMouseExited(e->handleMouseExitsCell(e));

        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background);
        borderPane.setCenter(gameBoardPane);
        borderPane.setLeft(buttons);
        borderPane.setTop(topScoreBoard);
        topScoreBoard.setAlignment(Pos.CENTER);

        Scene scene = new Scene(borderPane, IMAGE_FOR_BACKGROUND.getWidth(), IMAGE_FOR_BACKGROUND.getHeight(), Color.BLACK);


        primaryStage.setTitle("Tick Tack Toe");
        primaryStage.setResizable(false);

        primaryStage.setX(0);
        primaryStage.setY(0);

        primaryStage.initStyle(StageStyle.UNIFIED);

        primaryStage.setOpacity(1);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }

}
