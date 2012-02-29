
package oblig1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Manager extends JFrame {
  JTextField txtSsn, txtFirm, txtOName, txtOAddr;
  JTextField txtCarRegNr, txtCarMake, txtCarModel, txtCarRegYear;
  JButton regCPrivate,regCFirm, delCar, regPOwner, regFOwner, delOwner, changeOwner, showAll, showOwner;
  JTextArea display;
  
  OwnerList registry = new OwnerList();
  
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
    txtCarRegYear    = new JTextField(4);
    
    // Create Buttons
    regCPrivate = new JButton("Reg priv. bil");
    regCFirm    = new JButton("Reg firmabil");
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
    regCPrivate.addActionListener(listener);
    regCFirm.addActionListener(listener);
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
    c.add(txtCarRegYear);
    
    // Add Buttons
    c.add(regCPrivate);
    c.add(regCFirm);
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
      
      if(e.getSource() == regCPrivate)
        registerVehiclePrivate();
      else if (e.getSource() == regCFirm)
        registerVehicleCompany();
      else if (e.getSource() == delCar)
        deleteVehicle();
      else if (e.getSource() == regPOwner)
        registerPerson();
      else if (e.getSource() == regFOwner)
        registerCompany();
      else if (e.getSource() == delOwner)
        deleteOwner();
      else if (e.getSource() == changeOwner)
        changeOwner();
      else if (e.getSource() == showOwner)
        showOwner();
      else if (e.getSource() == showAll)
        showAll();
    }
  }
  
  public void registerVehiclePrivate() {
    try {
      String regNumber = txtCarRegNr.getText();
      String make = txtCarMake.getText();
      String model = txtCarModel.getText();
      int regYear = Integer.parseInt(txtCarRegYear.getText());
      int ssn = Integer.parseInt(txtSsn.getText());
      
      Vehicle v = new Vehicle(regNumber,make,model,regYear);
      registry.registerVehicle(ssn, v);
      
    } catch (NumberFormatException e) {
    }

  }
  
  public void registerVehicleCompany() {
    try {
      String regNumber = txtCarRegNr.getText();
      String make = txtCarMake.getText();
      String model = txtCarModel.getText();
      int regYear = Integer.parseInt(txtCarRegYear.getText());
      int firmID = Integer.parseInt(txtFirm.getText());
      
      Vehicle v = new Vehicle(regNumber,make,model,regYear);
      registry.registerVehicle(ssn, v);
      
    } catch (NumberFormatException e) {
    }

  }
  
  public void deleteVehicle() {
    String regNr = txtCarRegNr.getText();
    
    if(registry.removeVehicle(regNr))
      display.setText("Bilen: " + regNr + " er nå slettet\n");
    else
      display.setText("Bilen: " + regNr + " kan ikke slettes."
              + "Enten finnes den ikke, eller så er det noen som eier den");
  }
  
  // * Register private owner
  public void registerPerson() {
    try {
      int ssn = Integer.parseInt(txtSsn.getText());
      Person pOwner = new Person(txtOName.getText(), txtOAddr.getText(), null, ssn);
      
      registry.addOwner(pOwner);
    } catch (NumberFormatException e) {
      
    }
  }
  
  // * Register company owner
  public void registerCompany() {
    try {
      int firmID = Integer.parseInt(txtFirm.getText());
      Company fOwner = new Company (txtOName.getText(), txtOAddr.getText(), null, firmID);
      
      registry.addOwner(fOwner);
    } catch (NumberFormatException e) {
      
    }
  }
  
  public void deleteOwner() {
    try {
    int ssn = Integer.parseInt(txtSsn.getText());
    registry.removeOwner(ssn);
    }
    
    catch (NumberFormatException e) {
      
    }
  }
  
  public void changeOwner() {
    try {
      String regNr = txtCarRegNr.getText();
      int Ssn = Integer.parseInt(txtSsn.getText());
    
    registry.changeOwner(regNr,Ssn);
    }
    
    catch (NumberFormatException e) {
      
    }
  }
  
  public void showOwner() {
    display.setText(registry.findOwner(txtCarRegNr.getText()));
  }
  
  public void showAll() {
    display.setText(registry.printRegistry());
  }
  
}
