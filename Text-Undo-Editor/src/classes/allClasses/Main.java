package classes.allClasses;

 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
    public void start(Stage primaryStage) {
        // Initialize the UndoManager
        UndoManager undoManager = new UndoManager();

     // Create the TextArea and set its initial text
 		/*
 		 * TextArea declaration 
 		 */
 		//
 		TextArea textArea = new TextArea();
 		textArea.setText("Delete me and Enter your text.To undo your text press cntrl+z");

 		/*
 		 * Checks for undo keystroke and performs undo 
 		 */
 		
 		textArea.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
 			 // Check if the Ctrl key is pressed and the pressed key is Z
             if (event.isControlDown() && event.getCode() == KeyCode.Z) {
            	 // Attempt to undo the last action and get the previous state
                 String prevState = undoManager.undo();
                 // Check if there is a previous state available
                 if (prevState != null) {
                	 // Set the text in the TextArea to the previous state
                     textArea.setText(prevState);
                     
                 }
                 //event.consume(); 
             }
         });

		// Set an undo action on Ctrl+Z press
		/*
		 * Checks for redo keystroke and performs redo 
		 */
		
		// Create a stack to keep track of redo states
		final Stack<String> redoStack = new Stack<>();
		// Set an event filter for key presses in the TextArea
		textArea.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
		    if (event.isControlDown() && event.getCode() == KeyCode.Y) {
		        // Check if there is a redo state available
		        if (!redoStack.isEmpty()) {
		            // Record the current state for undo
		            undoManager.record(textArea.getText());
		            
		            // Set the text in the TextArea to the redo state
		            textArea.setText(redoStack.pop());
		        }
		        event.consume();
		    }
		});

		/*
		 * GUI setup and show 
		 */
 		
 		StackPane root = new StackPane();
 		root.getChildren().add(textArea);
 		Scene scene = new Scene(root, 400, 300);
 		primaryStage.setTitle("Text Editor");
 		primaryStage.setScene(scene);
 		primaryStage.show();

 		// Record the initial state
 		undoManager.record(textArea.getText());

 	}

 	public static void main(String[] args) {
 		launch(args);
 	}
 }
