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
    Integer index = 0;
    Button btnMenu = new Button("Main menu");
    Button btnEdit = new Button("Edit");
    Button btnNext = new Button("Next");
    Button btnPrev = new Button("Previous");

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
    
    // Grouping next and previous buttons
    HBox options = new HBox(10);

    public Edit() {
    	btnNext.setPrefSize(100, 35);
    	btnPrev.setPrefSize(100, 35);
    	btnEdit.setPrefSize(200, 35);
    	
    	if (questions.size() > 1) {
    		questionText.setText(questions.get(0).getQuestionText());
    		t1.setText((questions.get(0).getAnswers())[0]);
    		t2.setText((questions.get(0).getAnswers())[1]);
    		t3.setText((questions.get(0).getAnswers())[2]);
    		t4.setText((questions.get(0).getAnswers())[3]);
    	}
        pane.setTop(btnMenu);

        // Grouping radio buttons
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);

        b1.getChildren().addAll(a1, t1);
        b2.getChildren().addAll(a2, t2);
        b3.getChildren().addAll(a3, t3);
        b4.getChildren().addAll(a4, t4);
        
        options.getChildren().addAll(btnPrev, btnEdit, btnNext);

        questionGroup.getChildren().addAll(questionText, b1, b2, b3, b4);
        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);
        
        pane.setBottom(options);
        options.setAlignment(Pos.BOTTOM_CENTER);
        options.setTranslateY(-25);
        
        btnEdit.setOnAction(e -> {
        	String[] tempAnsArray = {t1.getText(), t2.getText(), t3.getText(), t4.getText()};
        	String correctAnswer = "";
        	
        	if (a1.isSelected()) {
        		correctAnswer = t1.getText();
        	}
        	else if (a2.isSelected()) {
        		correctAnswer = t2.getText();
        	}
        	else if (a3.isSelected()) {
        		correctAnswer = t3.getText();
        	}
        	else if (a4.isSelected()) {
        		correctAnswer = t4.getText();
        	}
        	questions.get(index).edit(questionText.getText(), tempAnsArray, correctAnswer);
        });

		btnNext.setOnAction(e -> {
			if (questions.size() > 0) {
				if (index < questions.size() - 1) {
					index++;
				} else {
					index = 0;
				}
			}
			questionText.setText((questions.get(index).getQuestionText()));
			t1.setText((questions.get(index).getAnswers())[0]);
			t2.setText((questions.get(index).getAnswers())[1]);
			t3.setText((questions.get(index).getAnswers())[2]);
			t4.setText((questions.get(index).getAnswers())[3]);
		});
		
		btnPrev.setOnAction(e -> {
			if (questions.size() > 0) {
				if (index == 0) {
					index = questions.size() - 1 ;
				} else {
					index--;
				}
			}
			
			questionText.setText((questions.get(index).getQuestionText()));
			t1.setText((questions.get(index).getAnswers())[0]);
			t2.setText((questions.get(index).getAnswers())[1]);
			t3.setText((questions.get(index).getAnswers())[2]);
			t4.setText((questions.get(index).getAnswers())[3]);
		});

    }

}
