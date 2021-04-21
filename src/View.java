import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class View {
BorderPane pane;
Scene scene;

Button btnMenu = new Button("Main menu");


    public View() {
        pane = new BorderPane();
        scene = new Scene(pane, 525, 500);
        pane.setBottom(btnMenu);
    }
}
