import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Project extends Application {
    public void start(Stage primaryStage) {

        //
        // Window set-up
        //
        BorderPane mainPane = new BorderPane();
        Scene mainScene = new Scene(mainPane);
        primaryStage.setTitle("ICS108 Project");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Buttons
        Button btnNext = new Button("Next");
        Button btnPrev = new Button("Previous");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
