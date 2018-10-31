package blackjack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class Blackjack extends Application {

    private Image imageBackground = new Image("background/Glowei_Worgen_Greymane.jpg");
    private Image cardImage = new Image("background/200px-Darius_Crowley(89369)_Gold.png");
    private FlowPane cards = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);

        ImageView img = new ImageView(cardImage);
        cards.getChildren().add(img);

        grid.add(cards, 0, 0, 3, 1);

        Scene scene = new Scene(grid, imageBackground.getWidth(), 900, Color.BLACK);

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}