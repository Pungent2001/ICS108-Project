import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        Delete objDelete = new Delete();

        // Buttons
        Button btnView = new Button("View a question");
        Button btnEdit = new Button("Edit a question");
        Button btnAdd = new Button("Add a new question");
        Button btnDelete = new Button("Delete a question");
        btnView.setPrefWidth(200);
        btnEdit.setPrefWidth(200);
        btnAdd.setPrefWidth(200);
        btnDelete.setPrefWidth(200);

        // Grouping
        VBox options = new VBox(10);
        options.getChildren().addAll(btnView, btnEdit, btnAdd, btnDelete);

        mainPane.setCenter(options);
        options.setAlignment(Pos.CENTER);

        // Main menu button handler for each object's menu button
        (objView.btnMenu).setOnAction(e -> primaryStage.setScene(mainScene));
        (objEdit.btnMenu).setOnAction(e -> primaryStage.setScene(mainScene));
        (objAdd.btnMenu).setOnAction(e -> primaryStage.setScene(mainScene));
        (objDelete.btnMenu).setOnAction(e -> primaryStage.setScene(mainScene));

        // Handling mainScene buttons
        btnView.setOnAction(e -> primaryStage.setScene(objView.scene));
        btnEdit.setOnAction(e -> primaryStage.setScene(objEdit.scene));
        btnAdd.setOnAction(e -> primaryStage.setScene(objAdd.scene));
        btnDelete.setOnAction(e -> primaryStage.setScene(objDelete.scene));

    }
    
    public static void main(String[] args) {
        System.out.println("Launching...");
        launch(args);
    }
}
