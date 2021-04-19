import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Project extends Application {
    public void start(Stage primaryStage) {

        //
        // Window set-up
        //
        BorderPane mainPane = new BorderPane();
        Scene mainScene = new Scene(mainPane, 525, 500); // Change the size later
        primaryStage.setTitle("ICS108 Project");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Buttons
        Button btnNext = new Button("Next");
        Button btnPrev = new Button("Previous");

        // Grouping - THIS IS NOT WORKING
        HBox nextPrev = new HBox(5);
        nextPrev.getChildren().addAll(btnPrev, btnNext);
        nextPrev.setAlignment(Pos.BOTTOM_CENTER);

        mainPane.getChildren().addAll(nextPrev);
    }

    public static void main(String[] args) {
        System.out.println("Launching...");
        launch(args);
    }
}
