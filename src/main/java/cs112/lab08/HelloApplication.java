package cs112.lab08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application /*implements EventHandler<ActionEvent>*/ {

    //CONSTANTS
    ImageView cardImageView;
    Label messageLabel;

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };


    @Override
    public void start(Stage stage) throws IOException {
        LoteriaCard cardLogo = new LoteriaCard();

        //SETUP
        Label titleLabel = new Label("Welcome to EChALE STEM Loteria!");
        cardImageView = new ImageView(cardLogo.getImage());
        messageLabel = new Label("Click the button to randomly draw a card.");
        Button drawCardButton = new Button("Draw Random Card");

        //CUSTOMIZATION
        cardImageView.setFitWidth(300);
        cardImageView.setPreserveRatio(true);
        titleLabel.setFont(new Font(20.0));
        drawCardButton.setOnAction( //anonymous class implementation (copied from line 79-91)
                new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("Button clicked.");
                        //get random card
                        int randomInt = (int) (Math.random() * LOTERIA_CARDS.length); //generates random # from 0-3
                        LoteriaCard randomCard= LOTERIA_CARDS[randomInt];
                        //changes image to new random card
                        cardImageView.setImage(randomCard.getImage());

                        //change message
                        messageLabel.setText(randomCard.getCardName());

                    }
                }
        );

        //COMPONENTS + LAYOUT
        VBox vbox = new VBox();
        vbox.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5.0);

        //SCENE + SHOW
        Scene scene = new Scene(vbox, 350, 500);
        stage.setScene(scene);
        stage.setTitle("EChALE STEM Loteria");
        stage.show();

    }

    /*@Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Button clicked.");
        //get random card
        int randomInt = (int) (Math.random() * LOTERIA_CARDS.length); //generates random # from 0-3
        LoteriaCard randomCard= LOTERIA_CARDS[randomInt];
        //changes image to new random card
        cardImageView.setImage(randomCard.getImage());

        //change message
        messageLabel.setText(randomCard.getCardName());

    }
*/
    public static void main(String[] args) {
        launch();
    }
}