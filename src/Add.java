import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Add extends Project{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 525, 500);
    Button btnMenu = new Button("Main menu");
    Button btnAdd = new Button("Add question");

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
    VBox questionGroup = new VBox(20);

    public Add() {
        pane.setBottom(btnMenu);

        // Grouping radio buttons
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);

        b1.getChildren().addAll(a1, t1);
        b2.getChildren().addAll(a2, t2);
        b3.getChildren().addAll(a3, t3);
        b4.getChildren().addAll(a4, t4);

        questionGroup.getChildren().addAll(questionText, b1, b2, b3, b4);
        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);

        pane.setRight(btnAdd);
        btnAdd.setAlignment(Pos.CENTER_RIGHT);
        btnAdd.setOnAction(e->{
        	String question = questionText.getText();
        	String answer = "";//Check later(if answers are bugged)
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
        	System.out.println(questions);
        	System.out.println(questions.size());
		});
        
    }
}
