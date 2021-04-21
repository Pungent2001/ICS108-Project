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

        // Creating Objects
        View objView = new View();
        Edit objEdit = new Edit();
        Add objAdd = new Add();

        // Buttons
        Button btnMenu = new Button("Main Menu");
        Button btnNext = new Button("Next");
        Button btnPrev = new Button("Previous");
        Button btnView = new Button("View a question");
        Button btnEdit = new Button("Edit a question");
        Button btnAdd = new Button("Add a new question");
        Button btnDelete = new Button("Delete a question");
        btnView.setPrefWidth(200);
        btnEdit.setPrefWidth(200);
        btnAdd.setPrefWidth(200);
        btnDelete.setPrefWidth(200);

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
        options.getChildren().addAll(btnView, btnEdit, btnAdd, btnDelete);

        VBox questionGroup = new VBox(10);
        questionGroup.getChildren().addAll(questionText);

        VBox radioGroup = new VBox(5);
        radioGroup.getChildren().addAll(a1, a2, a3, a4);

        mainPane.setCenter(options);
//        mainPane.setBottom(nextPrev);
//        mainPane.setLeft(questionGroup);
//        mainPane.setTop(radioGroup);

        // Ignore these.
        nextPrev.setAlignment(Pos.BOTTOM_CENTER);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        options.setAlignment(Pos.CENTER);

        // Main menu button handler for each object's menu button
        (objView.btnMenu).setOnAction(e -> primaryStage.setScene(mainScene));
        (objEdit.btnMenu).setOnAction(e -> primaryStage.setScene(mainScene));

        // Handling mainScene buttons
        btnView.setOnAction(e -> {
            primaryStage.setScene(objView.scene);
        });

        btnEdit.setOnAction(e -> {
            primaryStage.setScene(objEdit.scene); // Note to self: Change eScene to scene.
        });

        btnAdd.setOnAction(e -> {
            primaryStage.setScene(objAdd.scene); // Note to self: Read the previous not to self.
        });

    }

    public static void main(String[] args) {
        System.out.println("Launching...");
        launch(args);
    }
}
