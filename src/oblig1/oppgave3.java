/*
 */
package oblig1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Kristoffer Berdal <web@flexd.net>
 */
public class oppgave3 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Manager gui = new Manager();
    gui.addWindowListener(
            new WindowAdapter() {
              public void WindowClosing(WindowEvent e) {
                System.exit(0);
              }
            });
  }
}
