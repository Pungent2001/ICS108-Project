import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class View extends Project{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 525, 500);
    Integer index = 0;
    Button btnMenu = new Button("Main menu");
    Button btnCheck = new Button("Check answer");
    Button btnNext = new Button("Next");
    Button btnPrev = new Button("Previous");

    // Question stuff
    Text questionText = new Text("Sample Text"); // 420 MLG no scope blaze it
    RadioButton a1 = new RadioButton("One");
    RadioButton a2 = new RadioButton("Two");
    RadioButton a3 = new RadioButton("Three");
    RadioButton a4 = new RadioButton("Four");
    
    ToggleGroup answerGroup = new ToggleGroup();
    VBox radioGroup = new VBox(5);
    VBox questionGroup = new VBox(10);

    // Grouping next and previous buttons
    HBox prevNext = new HBox(10);

    public View() {
    	questionText.setText((questions.get(1).getQuestionText()));
		a1.setText((questions.get(1).getAnswers())[0]);
		a2.setText((questions.get(1).getAnswers())[1]);
		a3.setText((questions.get(1).getAnswers())[2]);
		a4.setText((questions.get(1).getAnswers())[3]);
    	btnNext.setPrefSize(100, 35);
    	btnPrev.setPrefSize(100, 35);
    	
        // Grouping radio buttons
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);
        radioGroup.getChildren().addAll(a1, a2, a3, a4);

        questionGroup.getChildren().addAll(questionText, radioGroup);
        prevNext.getChildren().addAll(btnPrev, btnNext);

        pane.setTop(btnMenu);
        btnMenu.setAlignment(Pos.CENTER);

        pane.setRight(btnCheck);
        btnCheck.setAlignment(Pos.BOTTOM_LEFT);

        pane.setBottom(prevNext);
        prevNext.setAlignment(Pos.BOTTOM_CENTER);
        prevNext.setTranslateY(-25);

        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);
		btnNext.setOnAction(e -> {
			if (questions.size()>1) {
				if (index < questions.size() - 1) {
					index++;
					questionText.setText((questions.get(index).getQuestionText()));
					a1.setText((questions.get(index).getAnswers())[0]);
					a2.setText((questions.get(index).getAnswers())[1]);
					a3.setText((questions.get(index).getAnswers())[2]);
					a4.setText((questions.get(index).getAnswers())[3]);
				} else {
					index = 1;
					questionText.setText((questions.get(index).getQuestionText()));
					a1.setText((questions.get(index).getAnswers())[0]);
					a2.setText((questions.get(index).getAnswers())[1]);
					a3.setText((questions.get(index).getAnswers())[2]);
					a4.setText((questions.get(index).getAnswers())[3]);
				}
			}
			
		});
		btnPrev.setOnAction(e -> {
			if (questions.size()>1) {
				if (index == 1) {
					index = questions.size() - 1 ;
					questionText.setText((questions.get(index).getQuestionText()));
					a1.setText((questions.get(index).getAnswers())[0]);
					a2.setText((questions.get(index).getAnswers())[1]);
					a3.setText((questions.get(index).getAnswers())[2]);
					a4.setText((questions.get(index).getAnswers())[3]);
				} else {
					index--;
					questionText.setText((questions.get(index).getQuestionText()));
					a1.setText((questions.get(index).getAnswers())[0]);
					a2.setText((questions.get(index).getAnswers())[1]);
					a3.setText((questions.get(index).getAnswers())[2]);
					a4.setText((questions.get(index).getAnswers())[3]);
				}
			}
		});
    }
}
