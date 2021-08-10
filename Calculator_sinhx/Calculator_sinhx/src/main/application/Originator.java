package main.application;
/**
 * Originator creates and stores states in Memento objects.
 * @author Harsh
 *
 */

public class Originator {
  private String state;

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  /**
  * This method saves state in memento objects.
  * @return the memento object
  */
  public Memento saveStateToMemento() {
    System.out.println("in savestatetomemento");
    return new Memento(state);
  }

  /**
   * This method get the state from momento object.
   * @param memento object
   */
  public void getStateFromMemento(Memento memento) {
    System.out.println("in getstatetomemento");
    state = memento.getState();
  }
}
