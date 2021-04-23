import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Add extends Project {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 525, 500);
    Button btnMenu = new Button("< Back to menu");
    Button btnAdd = new Button("Add question");
    Label lblAddNotice = new Label();

    TextField questionText = new TextField();
    TextField t1 = new TextField();
    TextField t2 = new TextField();
    TextField t3 = new TextField();
    TextField t4 = new TextField();

    RadioButton a1 = new RadioButton();
    RadioButton a2 = new RadioButton();
    RadioButton a3 = new RadioButton();
    RadioButton a4 = new RadioButton();

    ToggleGroup answerGroup = new ToggleGroup();
    HBox b1 = new HBox(5);
    HBox b2 = new HBox(5);
    HBox b3 = new HBox(5);
    HBox b4 = new HBox(5);
    HBox addGroup = new HBox();
    VBox questionGroup = new VBox(20);

    public Add() {
    	questionText.setPrefWidth(400);
    	t1.setPrefWidth(400);
    	t2.setPrefWidth(400);
    	t3.setPrefWidth(400);
    	t4.setPrefWidth(400);
    	
        pane.setTop(btnMenu);
        
        btnAdd.setPrefSize(150, 35);

        // Grouping radio buttons
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);

        b1.getChildren().addAll(a1, t1);
        b2.getChildren().addAll(a2, t2);
        b3.getChildren().addAll(a3, t3);
        b4.getChildren().addAll(a4, t4);

        questionGroup.getChildren().addAll(questionText, b1, b2, b3, b4, lblAddNotice);
        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);

        addGroup.getChildren().add(btnAdd);
        pane.setBottom(addGroup);
        addGroup.setAlignment(Pos.BOTTOM_CENTER);
        btnAdd.setTranslateY(-25);
        
        btnAdd.setOnAction(e->{
        	boolean questionIsEmpty = clean(questionText).equals("") || clean(t1).equals("") || clean(t2).equals("") || clean(t3).equals("") || clean(t4).equals("");
        	
        	if (!(answerGroup.getSelectedToggle() == null) && !questionIsEmpty) {
            	String question = questionText.getText();
            	String answer = "";
            	questionText.setText("");
            	String[] choices = {
            			t1.getText(), 
            			t2.getText(), 
            			t3.getText(), 
            			t4.getText()
            			};
            	if (a1.isSelected()) {
            		answer = t1.getText();
            	} else if(a2.isSelected()){
            		answer = t2.getText();
            	} else if(a3.isSelected()) {
            		answer = t3.getText();
            	} else if(a4.isSelected()) {
            		answer = t4.getText();
            	}
            	answerGroup.getSelectedToggle().setSelected(false);
            	t1.setText("");
            	t2.setText("");
            	t3.setText("");
            	t4.setText("");
            	questions.add(new Question(question, choices, answer));
            	lblAddNotice.setText("Question added!");
            	lblAddNotice.setTextFill(Color.GREEN);
        	}
        	else {
        		lblAddNotice.setText("Please check your question contents!");
        		lblAddNotice.setTextFill(Color.RED);
        	}
		});
        
    }
}
