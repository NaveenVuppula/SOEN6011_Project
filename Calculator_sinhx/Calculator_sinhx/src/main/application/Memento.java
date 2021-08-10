package main.application;

/**
 * Memento contains state of an object to be restored.
 * @author Harsh
 *
 */
public class Memento {
  private String state;

  /**
   * Parameterized Constructor.
   * @param state state to be stored
   */
  public Memento(String state) {
    this.state = state;
  }

  /**
   * This is getter method.
   * @return state of an object
   */
  public String getState() {
    return state;
  }    
}
