
package main.application;

import java.text.DecimalFormat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
/**
 * This class implements sinhx function, exponential function and
 * validates input values and type.
 * @author Harsh
 */

public class MainViewController {
    
  @FXML private TextArea display;
  @FXML private Button one;
  @FXML private Button two;
  @FXML private Button three;
  @FXML private Button four;
  @FXML private Button five;
  @FXML private Button six;
  @FXML private Button seven;
  @FXML private Button eight;
  @FXML private Button nine;
  @FXML private Button zero;
  @FXML private Button times;
  @FXML private Button divided;
  @FXML private Button plus;
  @FXML private Button minus;
  @FXML private Button sinhx;
  @FXML private Button buttonMemoryRead;
  @FXML private Button buttonMemoryWrite;
  @FXML private Button buttonDelete;
  
  private Boolean[] operator = new Boolean[5];
  private int operatorCount = 0;
  private static boolean flag = false;
  double[] temporary = {0, 0};
  
  private String actualText;
  
  private Main main;
  
  public static Originator originator = new Originator();
  public static CareTaker careTaker = new CareTaker();
  
  /**
   * Default constructor.
   */
  public MainViewController() {
    System.out.println("");
  }
  
  /**
   * This method sets display editable.
   * @param main object
   */
  public void setMain(Main main) {
    this.main = main;
    display.setEditable(false);
    
    display.setText("0");
    for (int i = 0; i < 5; i++) {
      operator[i] = false;
    }
  }
  
  
  
  /**
   * This method calculates e raised to x.
   * @param a value of exponent
   * @return e raised to a
   */
  public double calculateExponential(double a) {
    //return e raised to a
    double p = 1;
    for (int i = 100; i > 0; --i) {
      p = 1 + a * p / i;
    }
    return p; 
  }
  
 
  
  /**
   * This method calculates sinh(x) using exponential. e.g. sinh(x) = ( e(X) - e(-X) ) / 2
   * @param x input value
   * @return sinhx value of X
   */
  public double calculateSinhx(double x) {
    double value = calculateExponential(x);
    double base = calculateExponential(-x);
    double result = (value-base)/2;
    return result; 
  }
  
  /**
   * This method validates the input value x.
   * @param value x
   * @return true if it is properly defined otherwise returns false
   */
  public boolean validateValue1(String value) {
    Alert alert = new Alert(AlertType.INFORMATION);
    try {  
       double temp=Double.parseDouble(value);
       return true;
    } catch (NumberFormatException e) {  
      alert.setTitle("Alert !!!");
      alert.setContentText("Input type is not properly defined, it should be number !!");
      alert.showAndWait();
      return false;      
    }
  }
  
  
  /**
   * This method handle the all the button and set the display according to button Id given in fxml.
   * @param event FXML event
   */
  @FXML
  public void handleClick(Event event) {
    actualText = display.getText();
    if (display.getText().equals("0") || display.getText() == "0") {
      buttonDelete.setText("C");
      display.setText("");
      System.out.println("actualText: " + actualText);
      actualText = "";      
    }
    Button btn = (Button) event.getSource();
    switch (btn.getId()) {
      case "zero" :
        display.appendText("0");
        break;
      case "one" :
        display.appendText("1");
        break;
      case "two" :
        display.appendText("2");
        break;
      case "three" :
        display.appendText("3");
        break;
      case "four" :
        display.appendText("4");
        break;
      case "five" :
        display.appendText("5");
        break;
      case "six" :
        display.appendText("6");
        break;
      case "seven" :
        display.appendText("7");
        break;
      case "eight" :
        display.appendText("8");
        break;
      case "nine" :
        display.appendText("9");
        break;
      case "comma" :
        display.appendText(".");
        break;
      default:
    }
  }
  
  
  /**
   * This method clears text area.
   * @param event FXML event
   */
  @FXML public void delete(Event event) {
    buttonDelete.setText("AC");
    display.setText("0");
    careTaker.mementoList.clear();
    for (int i = 0; i < 2; i++) {
      temporary[i] = 0;
    }
    for (int i = 0; i < 5; i++) {
      operator[i] = false;
    }  
  }
  
  /**
   * This method stores the final result into memory using momento pattern.
   * @param event FXML event
   */
  @FXML public void memoryWrite(Event event) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText("State is stored in memory !!!!");
    alert.showAndWait();
    System.out.println("in memory write");
    if (display.getText().split(":").length > 1) {
      String []s = display.getText().split(":");
      originator.setState(s[1]);
    } else {
      originator.setState(display.getText());
    }
    careTaker.add(originator.saveStateToMemento());
  }
  
  /**
   * This method retrieves the state from memory using momento pattern.  
   * @param event FXML Event
   */
  @FXML public void memoryRead(Event event) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText("Stored state from memory is shown on display !!!!");
    alert.showAndWait();
    System.out.println("in memory read");
    originator.getStateFromMemento(careTaker.get(0));
    display.setText(originator.getState());
  }
  
  
  /**
   * This method performs the action according to user input.
   * @param event FXML event
   */
  @FXML public void operation(Event event) {
    operatorCount++;
    System.out.println("operatorCount: " + operatorCount);
    if (display.getText() != "") {
      actualText = display.getText();
    }
    
    Button btn = (Button) event.getSource();
    String operation = btn.getId();
    switch (operation) {
      case "plus":
        operator[0] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "minus":
        operator[1] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "times":
        operator[2] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "divided":
        operator[3] = true;
        temporary[0] = Double.parseDouble(display.getText());
        display.setText("");
        break;
      case "sinhx":
        operator[4] = true;
        flag = true;
        
        TextInputDialog td = new TextInputDialog(); 
        td.setHeaderText("Enter Value X :");
        td.showAndWait();
        TextField t1 = td.getEditor();
       // System.out.println(t1.getText());
        while (!(validateValue1(t1.getText()))) {
          td = new TextInputDialog(); 
          td.setHeaderText("Enter Value X :");
          td.showAndWait();
          t1 = td.getEditor();
          System.out.println(t1.getText());
        }
        temporary[0] = Double.parseDouble(t1.getText());
        System.out.println("Value 1 : " + temporary[0]);
        
       
        
        display.setText("Value X : " + t1.getText());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Press Ans to generate result !");
        alert.showAndWait();
        break;
      default:
    }   
  }
  

  /**
   * This method prints final result according to function.
   * @param event FXML event
   */
  @FXML public void result(Event event) {
    double result = 0;
    if (!flag) {
      temporary[1] = Double.parseDouble(display.getText());   
    }
    if (operator[0]) {
      result = temporary[0] + temporary[1];
    } else if (operator[1]) {
      result = temporary[0] - temporary[1];
    } else if (operator[2]) {
      result = temporary[0] * temporary[1];
    } else if (operator[3]) {
      result = temporary[0] / temporary[1];
    } else if (operator[4]) {
      result = calculateSinhx(temporary[0]);
      DecimalFormat df = new DecimalFormat(".#####");
      result = Double.parseDouble(df.format(result));
    }
    System.out.println("result: " + result);
    display.setText(Double.toString(result));    
  }
}