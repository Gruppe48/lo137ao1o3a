
package oblig1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Manager extends JFrame {
  JTextField txtSsn, txtFirm, txtOName, txtOAddr;
  JTextField txtCarRegNr, txtCarMake, txtCarModel, txtCarRY;
  JButton regCar, delCar, regPOwner, regFOwner, delOwner, changeOwner, showAll, showOwner;
  JTextArea display;
  
  public Manager() {
    super("BilPark");
    
    // Create Textfields
    txtSsn      = new JTextField(10);
    txtFirm     = new JTextField(10);
    txtOName    = new JTextField(10);
    txtOAddr    = new JTextField(10);
    
    txtCarRegNr = new JTextField(10);
    txtCarMake  = new JTextField(10);
    txtCarModel = new JTextField(10);
    txtCarRY    = new JTextField(4);
    
    // Create Buttons
    regCar      = new JButton("Reg bil");
    delCar      = new JButton("Slett bil");
    regPOwner   = new JButton("Reg priv.eier");
    regFOwner   = new JButton("Reg firmaeier");
    delOwner    = new JButton("Slett eier");
    changeOwner = new JButton("Skift eier");
    showOwner   = new JButton("Vis eier");
    showAll     = new JButton("Vis alle");
    
    // Create Display area
    display = new JTextArea(15, 45);
    display.setEditable(false);
    JScrollPane scroll = new JScrollPane(display);
    
    // Add ActionListeners
    BtnListener listener = new BtnListener();
    regCar.addActionListener(listener);
    delCar.addActionListener(listener);
    regPOwner.addActionListener(listener);
    regFOwner.addActionListener(listener);
    delOwner.addActionListener(listener);
    changeOwner.addActionListener(listener);
    showOwner.addActionListener(listener);
    showAll.addActionListener(listener);
    
    
    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    
    // Add TextFields
    c.add(new JLabel("PersonNr:"));
    c.add(txtSsn);
    c.add(new JLabel("FirmaID:"));
    c.add(txtFirm);
    c.add(new JLabel("Eier Navn:"));
    c.add(txtOName);
    c.add(new JLabel("Eier Adresse:"));
    c.add(txtOAddr);
    c.add(new JLabel("RegistreringsNr:"));
    c.add(txtCarRegNr);
    c.add(new JLabel("Bilmerke:"));
    c.add(txtCarMake);
    c.add(new JLabel("Bilmodell:"));
    c.add(txtCarModel);
    c.add(new JLabel("Registreringsår"));
    c.add(txtCarRY);
    
    // Add Buttons
    c.add(regCar);
    c.add(delCar);
    c.add(regPOwner);
    c.add(regFOwner);
    c.add(delOwner);
    c.add(changeOwner);
    c.add(showOwner);
    c.add(showAll);
    
    // Add Display Area
    c.add(scroll);
    
    setSize(870, 400);
    setVisible(true);
  }
  
  private class BtnListener implements ActionListener { 
    @Override
    public void actionPerformed(ActionEvent e) {
      
      if(e.getSource() == regCar)
        regCar();
      else if (e.getSource() == delCar)
        delCar();
      else if (e.getSource() == regPOwner)
        regPOwner();
      else if (e.getSource() == regFOwner)
        regFOwner();
      else if (e.getSource() == delOwner)
        delOwner();
      else if (e.getSource() == changeOwner)
        changeOwner();
      else if (e.getSource() == showOwner)
        showOwner();
      else if (e.getSource() == showAll)
        showAll();
    }
  }
  
  public void regCar() {
    
  }
  
  public void delCar() {
    
  }
  
  public void regPOwner() {
    
  }
  
  public void regFOwner() {
    
  }
  
  public void delOwner() {
    
  }
  
  public void changeOwner() {
    
  }
  
  public void showOwner() {
    
  }
  
  public void showAll() {
    
  }
  
}
