import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
        Button btnEdit = new Button("Edit");
        Button btnNew = new Button("New");
        Button btnDelete = new Button("Delete");
        btnEdit.setPrefWidth(90);
        btnNew.setPrefWidth(90);
        btnDelete.setPrefWidth(90);

        // Question stuff
        Text questionText = new Text("Test");
        RadioButton a1 = new RadioButton("One");
        RadioButton a2 = new RadioButton("Two");
        RadioButton a3 = new RadioButton("Three");
        RadioButton a4 = new RadioButton("Four");

        ToggleGroup answerGroup = new ToggleGroup();
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);

        // Grouping
        HBox nextPrev = new HBox(5);
        nextPrev.getChildren().addAll(btnPrev, btnNext);

        VBox options = new VBox(10);
        options.getChildren().addAll(btnEdit, btnNew, btnDelete);

        VBox questionGroup = new VBox(10);
        questionGroup.getChildren().addAll(questionText);

        mainPane.setBottom(nextPrev);
        mainPane.setRight(options);
        mainPane.setLeft(questionGroup);
        mainPane.setTop(answerGroup);  // How tf do I get it to show up?

        nextPrev.setAlignment(Pos.BOTTOM_CENTER);
        questionGroup.setAlignment(Pos.CENTER_LEFT);

    }

    public static void main(String[] args) {
        System.out.println("Launching...");
        launch(args);
    }
}
