package ticktacktoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;


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



    private Button exitButton, newGameButton;
    private VBox buttons;

    public void handleButtonClick(ActionEvent event){

        if(event.getSource().equals(exitButton)){
            System.exit(0);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        exitButton = new Button("Exit");
        exitButton.setOnAction(e->handleButtonClick(e));

        newGameButton = new Button("New game");
        exitButton.setOnAction(e->handleButtonClick(e));

        buttons = new VBox(exitButton, newGameButton);
        buttons.setSpacing(50);


        /** setting background */

        BackgroundSize backgroundSize = new BackgroundSize(SCREEN_WIDTH*0.6,SCREEN_HEIGHT*0.6, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(IMAGE_FOR_BACKGROUND, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        BackgroundSize boardBackgroundSize = new BackgroundSize(IMAGE_FOR_GAME_BOARD.getWidth(), IMAGE_FOR_BACKGROUND.getHeight(), true, true, true, false);
        BackgroundImage boardBackgroundImage = new BackgroundImage(IMAGE_FOR_GAME_BOARD, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, boardBackgroundSize);
        Background boardBackground = new Background(boardBackgroundImage);

        GridPane gameBoardPane = new GridPane();
        gameBoardPane.setAlignment(Pos.CENTER);
        gameBoardPane.setBackground(boardBackground);
        gameBoardPane.setPadding(new Insets(10, 10, 10, 10));
        gameBoardPane.setHgap(5);
        gameBoardPane.setVgap(5);

        ImageView cellImage11 = new ImageView(ANIMATION_FOR_O);
        gameBoardPane.add(cellImage11, 1,1);

        ImageView cellImage12 = new ImageView(ANIMATION_FOR_X);
        gameBoardPane.add(cellImage12, 2,1);

        ImageView cellImage13 = new ImageView(IMAGE_FOR_X);
        gameBoardPane.add(cellImage13, 3,1);

        ImageView cellImage21 = new ImageView(IMAGE_FOR_O);
        gameBoardPane.add(cellImage21, 1,2);

        ImageView cellImage22 = new ImageView(IMAGE_FOR_X);
        gameBoardPane.add(cellImage22, 2,2);

        ImageView cellImage23 = new ImageView(IMAGE_FOR_O);
        gameBoardPane.add(cellImage23, 3,2);

        ImageView cellImage31 = new ImageView(IMAGE_FOR_X);
        gameBoardPane.add(cellImage31, 1,3);

        ImageView cellImage32 = new ImageView(IMAGE_FOR_O);
        gameBoardPane.add(cellImage32, 2,3);

        ImageView cellImage33 = new ImageView(IMAGE_FOR_X);
        gameBoardPane.add(cellImage33, 3,3);


        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(background);
        borderPane.setCenter(gameBoardPane);
        borderPane.setLeft(buttons);

        Scene scene = new Scene(borderPane, IMAGE_FOR_BACKGROUND.getWidth(), IMAGE_FOR_BACKGROUND.getHeight(), Color.BLACK);



        /** Primary stage settings */

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
