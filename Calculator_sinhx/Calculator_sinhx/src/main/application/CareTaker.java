package main.application;

import java.util.ArrayList;
import java.util.List;
/**
 * This class object is responsible to restore object state from Memento.
 * @author Harsh
 *
 */

public class CareTaker {
  public List<Memento> mementoList = new ArrayList<Memento>();

  /**
   * This method adds memento state into mementolist.
   * @param state memento state
   */
  public void add(Memento state) {
    System.out.println("in add memento savestatetomomento");
    mementoList.add(state);
  }

  /**
   * This method gets the memento from list.
   * @param index index of mementolist
   * @return the memento depending on index
   */
  public Memento get(int index) {
    System.out.println("in get memento");
    return mementoList.get(index);
  }
}
