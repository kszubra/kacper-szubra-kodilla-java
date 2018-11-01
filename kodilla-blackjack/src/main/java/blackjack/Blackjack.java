package blackjack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;


public class Blackjack extends Application {

    private Image imageBackground = new Image("background/Glowei_Worgen_Greymane.jpg");

    private Image cardImage1 = new Image("background/twisted-worgen-300x429.png");
    private Image cardImage2 = new Image("background/worgen-abomination-hd.png");
    private Image cardImage3 = new Image("background/worgen-infiltrator-300x429.png");

    private FlowPane cards = new FlowPane(Orientation.VERTICAL);

    Button button1;

    public static void main(String[] args) {
        launch(args); //launch calls Application and sets everything, then calls start()
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        button1 = new Button();
        button1.setText("Click");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); //paddin around layout and window, NOT grid cells
        grid.setHgap(5.5); // horizontal spacing
        grid.setVgap(5.5); // vertical spacing between cells
        grid.setBackground(background);

        ImageView img1 = new ImageView(cardImage1);
        ImageView img2 = new ImageView(cardImage2);
        ImageView img3 = new ImageView(cardImage3);

        cards.setPrefWrapLength(3);
        cards.getChildren().add(img1);
        cards.getChildren().add(img2);
        cards.getChildren().add(img3);


        grid.add(cards, 0, 0, 3, 1);

        Scene scene = new Scene(grid, imageBackground.getWidth(), 900, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setResizable(true);

        primaryStage.setX(0);
        primaryStage.setY(0);

        primaryStage.initStyle(StageStyle.UNIFIED);

        primaryStage.setOpacity(1);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

/*
* STAGE - whole window
* SCENE - content in window
*
*
*/