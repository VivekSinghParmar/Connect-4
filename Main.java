import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

import java.lang.ModuleLayer.Controller;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(args);
    }
    private Controlling controller ;

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("connecting.fxml"));
        GridPane rootGridPane = loader.load();
        controller = loader.getController();
        controller.createPlayGround();
        MenuBar menuBar = createMenu();
        // The below line is written because initially the menu bar was not covering
        // the whole space of its gride and after this line of code it cover whole space
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    private MenuBar createMenu(){
        Menu file = new Menu("File");

        MenuItem newGame = new MenuItem("New game");
        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset game");
        resetGame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem exitGame = new MenuItem("Exit game");
        exitGame.setOnAction(event -> exitGame());

        file.getItems().addAll(newGame,resetGame,separatorMenuItem,exitGame);


        Menu help = new Menu("Help");

        MenuItem aboutConnect = new MenuItem("About Connect 4");
        aboutConnect.setOnAction(event -> aboutConnect4());

        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        help.getItems().addAll(aboutConnect,separatorMenuItem,aboutMe);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file,help);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Vivek Singh Parmar");
        alert.setContentText("Hello Everyone, I am trying to give you a good experience with the help of my coding skill. " +
                "This is the first project of my journey as a developer, So keep on play and keep on enjoying the game of Connect Four");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect 4");
        alert.setHeaderText("How to Play?");
        alert.getDialogPane().setPrefSize(350, 300);
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color " +
                "and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. " +
                "The pieces fall straight down, occupying the next available space within the column. The objective of the game " +
                "is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a " +
                "solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
        System.out.println("Stopped");
    }

    private void resetGame() {

    }
}