import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Delete extends Project{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer index = 0;
	BorderPane pane = new BorderPane();
	Scene scene = new Scene(pane, 525, 500);
	
	Button btnMenu = new Button("Main menu");
    Button btnDelete = new Button("Delete question");
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
	
	public Delete() {
		if (questions.size()>1) {
		questionText.setText((questions.get(0).getQuestionText()));
		a1.setText((questions.get(0).getAnswers())[0]);
		a2.setText((questions.get(0).getAnswers())[1]);
		a3.setText((questions.get(0).getAnswers())[2]);
		a4.setText((questions.get(0).getAnswers())[3]);
		}
    	btnNext.setPrefSize(100, 35);
    	btnPrev.setPrefSize(100, 35);
		
        // Grouping radio buttons
        a1.setToggleGroup(answerGroup);
        a2.setToggleGroup(answerGroup);
        a3.setToggleGroup(answerGroup);
        a4.setToggleGroup(answerGroup);
        radioGroup.getChildren().addAll(a1, a2, a3, a4);

        questionGroup.getChildren().addAll(questionText, radioGroup);
        prevNext.getChildren().addAll(btnPrev, btnDelete,  btnNext);
		
		pane.setTop(btnMenu);
		btnMenu.setAlignment(Pos.TOP_LEFT);
		btnNext.setOnAction(e -> {
			if (questions.size()>0) {
				if (index < questions.size() - 1) {
					index++;
					questionText.setText((questions.get(index).getQuestionText()));
					a1.setText((questions.get(index).getAnswers())[0]);
					a2.setText((questions.get(index).getAnswers())[1]);
					a3.setText((questions.get(index).getAnswers())[2]);
					a4.setText((questions.get(index).getAnswers())[3]);
				} else {
					index = 0;
					questionText.setText((questions.get(index).getQuestionText()));
					a1.setText((questions.get(index).getAnswers())[0]);
					a2.setText((questions.get(index).getAnswers())[1]);
					a3.setText((questions.get(index).getAnswers())[2]);
					a4.setText((questions.get(index).getAnswers())[3]);
				}
			}
			
		});
		btnPrev.setOnAction(e -> {
			if (questions.size()>0) {
				if (index == 0) {
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
		btnDelete.setOnAction(e -> {
			if (questions.size()>1) {
				if(questions.size()==2) {
					questionText.setText("there are no questions, please return to the main menu");
					a1.setText("removed");
					a2.setText("removed");
					a3.setText("removed");
					a4.setText("removed");
					questions.remove((questions.get(1)));
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
		
        pane.setBottom(prevNext);
        prevNext.setAlignment(Pos.BOTTOM_CENTER);
        prevNext.setTranslateY(-25);
        
        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);
	}
}
