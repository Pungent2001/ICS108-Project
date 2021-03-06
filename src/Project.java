// ICS108-02 Project - Created by: Ahmad Al-Ahmad (201969490) and Mohammed Al-Mohammedi (201971510)

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Project extends Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 352190495009038584L;
	public static ArrayList<Question> questions;
	public void start(Stage primaryStage) {
        //
        // Window set-up
        //
		if (questions == null) {
			questions = new ArrayList<Question>();
		}
		primaryStage.setOnShown(e -> readBinary());
        BorderPane mainPane = new BorderPane();
        Scene mainScene = new Scene(mainPane, 525, 500);
        primaryStage.setTitle("ICS108-02 Project");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        // Creating Objects
        View objView = new View();
        Edit objEdit = new Edit();
        Add objAdd = new Add();
        Delete objDelete = new Delete();
        
        //Creating nodes
        Label projectInfo = new Label("ICS108-02 Project\n Created by:\n Ahmad Al-Ahmad (201969490)\n Mohammed Al-Mohammedi (201971510)");
        Label errorTxt = new Label();
        projectInfo.setTextAlignment(TextAlignment.CENTER);

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
        options.getChildren().addAll(projectInfo, btnView, btnEdit, btnAdd, btnDelete, errorTxt);

        mainPane.setCenter(options);
        options.setAlignment(Pos.CENTER);

        // Main menu button handler for each object's menu button
        (objView.btnMenu).setOnAction(e -> {
        	primaryStage.setScene(mainScene);
			objView.answerStatus.setText("");
			
			objView.a1.setSelected(false);
			objView.a2.setSelected(false);
			objView.a3.setSelected(false);
			objView.a4.setSelected(false);
        	
        });
        (objEdit.btnMenu).setOnAction(e -> {
        	primaryStage.setScene(mainScene);
			objEdit.lblEditNotice.setText("");
			
			// Review this please
			objEdit.a1.setSelected(false);
			objEdit.a2.setSelected(false);
			objEdit.a3.setSelected(false);
			objEdit.a4.setSelected(false);
        });
        (objAdd.btnMenu).setOnAction(e -> {
        	primaryStage.setScene(mainScene);
        	objAdd.lblAddNotice.setText("");
        	
        	objAdd.questionText.setText(null);
        	objAdd.t1.setText(null);
        	objAdd.t2.setText(null);
        	objAdd.t3.setText(null);
        	objAdd.t4.setText(null);
        	
			objAdd.a1.setSelected(false);
			objAdd.a2.setSelected(false);
			objAdd.a3.setSelected(false);
			objAdd.a4.setSelected(false);
        });
        
        (objDelete.btnMenu).setOnAction(e -> {
        	primaryStage.setScene(mainScene);
        });

        // Handling mainScene buttons
        btnAdd.setOnAction(e -> primaryStage.setScene(objAdd.scene));
        
        btnView.setOnAction(e -> {
        	if (questions.size() > 0) {
        		primaryStage.setScene(objView.scene);
        	}else {
        		errorTxt.setText("There are no questions to delete.\nplease Add a new question.");
        		}
        });
        
        btnEdit.setOnAction(e -> {
        	if (questions.size() > 0) {
        		primaryStage.setScene(objEdit.scene);
        	}else {
    		errorTxt.setText("There are no questions to delete.\nplease Add a new question.");
    			}
        });
        
        btnDelete.setOnAction(e -> {
        	if (questions.size() > 0) {
        		primaryStage.setScene(objDelete.scene);
        	}else {
        		errorTxt.setText("There are no questions to delete.\nplease Add a new question.");
        		}
        	});
        
        primaryStage.setOnCloseRequest(e -> {
        	writeBinary();
        });
       
    }
	
    @SuppressWarnings("unchecked")
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
    
    public String clean(TextField tf) {
    	return tf.getText().replace(" ", "");
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
