import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Project extends Application implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 352190495009038584L;
	public static ArrayList<Question> questions;
	public void start(Stage primaryStage) {
        //
        // Window set-up
        //
		try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("QuestionBank.dat"));
            String[] ee = {"1","2","3","4"};
            questions.add(new Question("ass",ee,"hello"));
            writer.writeObject(questions);
            writer.close();
        }catch(Exception e) {
        }    
		primaryStage.setOnShowing(e -> readBinary());
		
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
        
        //Creating nodes
        Label errorTxt = new Label();

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
        options.getChildren().addAll(btnView, btnEdit, btnAdd, btnDelete, errorTxt);

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
        btnDelete.setOnAction(e -> {
        	if (questions.size() == 0) {
        	primaryStage.setScene(objDelete.scene);}
        	else {
        		errorTxt.setText("There are no questions to delete.");
        	}
        	});
        
        primaryStage.setOnCloseRequest(e -> {
        	writeBinary();
        });
        
       
    }
	
    public void readBinary() {
        try {
             FileInputStream fileInputStream = new FileInputStream("QuestionBank.dat");
             ObjectInputStream objStream = new ObjectInputStream(fileInputStream);
             questions = (ArrayList<Question>) objStream.readObject();
             objStream.close();
            
        }catch(Exception e) {
        }

        

    }
    public void writeBinary() {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("QuestionBank.dat"));
            writer.writeObject(questions);
            writer.close();
        }catch(Exception e) {
        }    
    }
	    
    public static void main(String[] args) {
        System.out.println("Launching...");
        if (new File("QuestionBank.dat").exists()) {
        	launch(args);
        } else{
        	System.out.println("Launch failed, no .dat files\nCreating new files...");
        	File file = new File("QuestionBank.dat");
        	try{
        		file.createNewFile();
        	}catch(Exception e) {
        		
        	}
        	launch(args);
        }
    }
}
