package main.application;
    
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class sets the stage for display, adds menu bar and loads the fxml file using fxml loader. 
 * Then, it calls the MainViewController to perform operation. 
 * @author Harsh
 *
 */
public class Main extends Application {
  private Stage primaryStage;
  private AnchorPane anchorPane;
  MenuBar menuBar = new MenuBar();
  
  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    primaryStage.setResizable(false);
    primaryStage.setTitle("Calculator With Log function");
    //addMenuBar();
    mainView();
    //newView();
  }
  
  /**
   * This method adds menu bar using JAVA FXML.
   */
  public void addMenuBar() {
    Menu menu = new Menu("Menu");
    MenuItem mi = new MenuItem("Close");
    mi.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent t) {
            System.exit(0);
        }
    });
    menu.getItems().add(mi);
    menuBar.getMenus().add(menu);
    
    final String os = System.getProperty("os.name");
    if (os != null && os.startsWith("Mac")) {
      menuBar.useSystemMenuBarProperty().set(true);
    }
    BorderPane borderPane = new BorderPane();
    borderPane.setTop(menuBar);

    primaryStage.setScene(new Scene(borderPane));
    primaryStage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
  }
  
  /**
   * This method loads fxml file from resources and set scene.
   */
  public void mainView() {
    try {
      FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainView.fxml"));
      //System.out.println(loader == null);
      anchorPane = (AnchorPane) loader.load();
      MainViewController controller = loader.getController();
      controller.setMain(this);
      
      Scene scene = new Scene(anchorPane);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }   
  }
}
