import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Delete extends Project {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer index = 0;
	BorderPane pane = new BorderPane();
	Scene scene = new Scene(pane, 450, 500);
	
	Button btnMenu = new Button("< Go back menu");
    Button btnDelete = new Button("Delete question");
    Button btnNext = new Button("Next");
    Button btnPrev = new Button("Previous");
	
    // Question stuff
    Label questionText = new Label("Press next to continue"); // 420 MLG no scope blaze it
    RadioButton a1 = new RadioButton("");
    RadioButton a2 = new RadioButton("");
    RadioButton a3 = new RadioButton("");
    RadioButton a4 = new RadioButton("");

    ToggleGroup answerGroup = new ToggleGroup();
    VBox radioGroup = new VBox(5);
    VBox questionGroup = new VBox(10);
    
    // Grouping next and previous buttons
    HBox options = new HBox(10);
	
	public Delete() {
		questionText.setStyle("-fx-font-size: 18;");
		
		a1.setDisable(true);
		a2.setDisable(true);
		a3.setDisable(true);
		a4.setDisable(true);
		
		if (questions.size() > 1) {
		questionText.setText((questions.get(0).getQuestionText()));
		a1.setText((questions.get(0).getAnswers())[0]);
		a2.setText((questions.get(0).getAnswers())[1]);
		a3.setText((questions.get(0).getAnswers())[2]);
		a4.setText((questions.get(0).getAnswers())[3]);
		}
		
    	btnNext.setPrefSize(100, 35);
    	btnPrev.setPrefSize(100, 35);
    	btnDelete.setPrefSize(150, 35);
		
        // Grouping radio buttons
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);
        radioGroup.getChildren().addAll(a1, a2, a3, a4);

        questionGroup.getChildren().addAll(questionText, radioGroup);
        options.getChildren().addAll(btnPrev, btnDelete,  btnNext);
		
		pane.setTop(btnMenu);
		btnMenu.setAlignment(Pos.TOP_LEFT);
		btnNext.setOnAction(e -> {
			if (questions.size()>0) {
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
			}
			
		});
		
		btnPrev.setOnAction(e -> {
			if (questions.size()>0) {
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
			}
		});
		
		btnDelete.setOnAction(e -> {
			if (questions.size()>0) {
				if(questions.size()==1) {
					questionText.setText("there are no questions, please return to the main menu");
					a1.setText("removed");
					a2.setText("removed");
					a3.setText("removed");
					a4.setText("removed");
					questions.remove((questions.get(0)));
					System.out.println(questions);
					System.out.println(questions.size());
				
				}else {
					questions.remove((questions.get(index)));
					index = 0;
					questionText.setText((questions.get(index).getQuestionText()));
					a1.setText((questions.get(index).getAnswers())[0]);
					a2.setText((questions.get(index).getAnswers())[1]);
					a3.setText((questions.get(index).getAnswers())[2]);
					a4.setText((questions.get(index).getAnswers())[3]);
					System.out.println(questions);
					System.out.println(questions.size());
				}
			}
		});
		
        pane.setBottom(options);
        options.setAlignment(Pos.BOTTOM_CENTER);
        options.setTranslateY(-25);
        
        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);
	}
}
