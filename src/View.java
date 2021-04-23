import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View extends Project {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 525, 500);
    Integer index = 0;
    Button btnMenu = new Button("< Back to menu");
    Button btnCheck = new Button("Check answer");
    Button btnNext = new Button("Next");
    Button btnPrev = new Button("Previous");

    // Question nodes
    Label questionText = new Label("Press next to continue");
    RadioButton a1 = new RadioButton("");
    RadioButton a2 = new RadioButton("");
    RadioButton a3 = new RadioButton("");
    RadioButton a4 = new RadioButton("");
    Label answerStatus= new Label("");
    
    ToggleGroup answerGroup = new ToggleGroup();
    VBox radioGroup = new VBox(20);
    VBox questionGroup = new VBox(20);
    HBox options = new HBox(10);

    public View() {
    	questionText.setStyle("-fx-font-size: 18px;");
    	
    	if (questions.size() > 1) {
    		questionText.setText((questions.get(1).getQuestionText()));
    		a1.setText((questions.get(0).getAnswers())[0]);
    		a2.setText((questions.get(0).getAnswers())[1]);
    		a3.setText((questions.get(0).getAnswers())[2]);
    		a4.setText((questions.get(0).getAnswers())[3]);
    	}
    	btnNext.setPrefSize(100, 35);
    	btnPrev.setPrefSize(100, 35);
    	btnCheck.setPrefSize(150, 35);
    	
        // Grouping radio buttons
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);
        radioGroup.getChildren().addAll(a1, a2, a3, a4);

        questionGroup.getChildren().addAll(questionText, radioGroup, answerStatus);
        options.getChildren().addAll(btnPrev, btnCheck, btnNext);

        pane.setTop(btnMenu);
        btnMenu.setAlignment(Pos.TOP_LEFT);

        pane.setBottom(options);
        options.setAlignment(Pos.BOTTOM_CENTER);
        options.setTranslateY(-25);

        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);
        
        
        btnCheck.setOnAction(e -> {
        	Boolean status;
        	
        	if (a1.isSelected() || a2.isSelected() || a3.isSelected() || a4.isSelected()) {
            	if (a1.isSelected()) {
            		status = (questions.get(index).checkAnswer(a1.getText()));
            	} else if (a2.isSelected()){
            		status = (questions.get(index).checkAnswer(a2.getText()));
            	} else if (a3.isSelected()){
            		status = (questions.get(index).checkAnswer(a3.getText()));
            	} else if (a4.isSelected()){
            		status = (questions.get(index).checkAnswer(a4.getText()));
            	} else {
            		status = false;
            	}
            	if (status) {
            		answerStatus.setText("The answer is correct");
            		answerStatus.setTextFill(Color.GREEN);
            	} else {
            		answerStatus.setText("The answer is Incorrect");
            		answerStatus.setTextFill(Color.RED);
            	}
            	
        	}
        	else {
        		answerStatus.setText("Please select an answer to check");
        		answerStatus.setTextFill(Color.RED);
        	}
        });
        
		btnNext.setOnAction(e -> {
			if (questions.size() > 0) {
				if (index < questions.size() - 1) {
					index++;
				} else {
					index = 0;
				}
				
				questionText.setText((questions.get(index).getQuestionText()));
				a1.setText((questions.get(index).getAnswers())[0]);
				a2.setText((questions.get(index).getAnswers())[1]);
				a3.setText((questions.get(index).getAnswers())[2]);
				a4.setText((questions.get(index).getAnswers())[3]);
				
				answerStatus.setText("");
				a1.setSelected(false);
				a2.setSelected(false);
				a3.setSelected(false);
				a4.setSelected(false);
			}
			
			
		});
		
		btnPrev.setOnAction(e -> {
			if (questions.size() > 0) {
				if (index == 0) {
					index = questions.size() - 1 ;
				} else {
					index--;
				}
				
				questionText.setText((questions.get(index).getQuestionText()));
				a1.setText((questions.get(index).getAnswers())[0]);
				a2.setText((questions.get(index).getAnswers())[1]);
				a3.setText((questions.get(index).getAnswers())[2]);
				a4.setText((questions.get(index).getAnswers())[3]);
				
				answerStatus.setText("");
				a1.setSelected(false);
				a2.setSelected(false);
				a3.setSelected(false);
				a4.setSelected(false);
			}
			
		});
    }
}
