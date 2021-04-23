import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Edit extends Project{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 525, 500);
    Button btnMenu = new Button("Main menu");
    Integer index = 0;
    Button btnEdit = new Button("Edit");

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

    public Edit() {
    	if (questions.size()>1) {
    		questionText.setText(questions.get(0).getQuestionText());
    		t1.setText((questions.get(0).getAnswers())[0]);
    		t2.setText((questions.get(0).getAnswers())[1]);
    		t3.setText((questions.get(0).getAnswers())[2]);
    		t4.setText((questions.get(0).getAnswers())[3]);
    	}
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

        pane.setRight(btnEdit);
        btnEdit.setAlignment(Pos.CENTER_RIGHT);



    }

}
