import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class Edit {
    BorderPane pane = new BorderPane();
    Scene scene = new Scene(pane, 525, 500);
    Button btnMenu = new Button("Main menu");
    public Edit() {
        pane.setBottom(btnMenu);
    }

}
