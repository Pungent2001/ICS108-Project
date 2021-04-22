import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Delete {
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
		btnMenu.setAlignment(Pos.TOP_LEFT);
		
        pane.setBottom(prevNext);
        prevNext.setAlignment(Pos.BOTTOM_CENTER);
        prevNext.setTranslateY(-25);
        
        pane.setLeft(questionGroup);
        questionGroup.setAlignment(Pos.CENTER_LEFT);
        questionGroup.setTranslateX(50);
	}
}