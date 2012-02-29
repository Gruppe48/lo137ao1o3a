
package oblig1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Manager extends JFrame {
  JTextField textSSN, textCompanyName, textOwnerName, textOwnerAddress;
  JTextField textVehicleRegNumber, textVehicleMake, textVehicleModel, textVehicleRegistrationYear;
  JButton buttonRegisterPerson,buttonRegisterCompany, buttonDeleteVehicle, buttonRegisterPersonalOwner, buttonRegisterCompanyOwner, buttonDeleteOwner, buttonChangeOwner, buttonShowAll, buttonShowOwner;
  JTextArea display;
  
  OwnerList registry = new OwnerList();
  
  public Manager() {
    super("BilPark");
    
    // Create Textfields
    textSSN      = new JTextField(10);
    textCompanyName     = new JTextField(10);
    textOwnerName    = new JTextField(10);
    textOwnerAddress    = new JTextField(10);
    
    textVehicleRegNumber = new JTextField(10);
    textVehicleMake  = new JTextField(10);
    textVehicleModel = new JTextField(10);
    textVehicleRegistrationYear    = new JTextField(4);
    
    // Create Buttons
    buttonRegisterPerson = new JButton("Reg priv. bil");
    buttonRegisterCompany    = new JButton("Reg firmabil");
    buttonDeleteVehicle      = new JButton("Slett bil");
    buttonRegisterPersonalOwner   = new JButton("Reg priv.eier");
    buttonRegisterCompanyOwner   = new JButton("Reg firmaeier");
    buttonDeleteOwner    = new JButton("Slett eier");
    buttonChangeOwner = new JButton("Skift eier");
    buttonShowOwner   = new JButton("Vis eier");
    buttonShowAll     = new JButton("Vis alle");
    
    // Create Display area
    display = new JTextArea(15, 45);
    display.setEditable(false);
    JScrollPane scroll = new JScrollPane(display);
    
    // Add ActionListeners
    BtnListener listener = new BtnListener();
    buttonRegisterPerson.addActionListener(listener);
    buttonRegisterCompany.addActionListener(listener);
    buttonDeleteVehicle.addActionListener(listener);
    buttonRegisterPersonalOwner.addActionListener(listener);
    buttonRegisterCompanyOwner.addActionListener(listener);
    buttonDeleteOwner.addActionListener(listener);
    buttonChangeOwner.addActionListener(listener);
    buttonShowOwner.addActionListener(listener);
    buttonShowAll.addActionListener(listener);
    
    
    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    
    // Add TextFields
    c.add(new JLabel("PersonNr:"));
    c.add(textSSN);
    c.add(new JLabel("FirmaID:"));
    c.add(textCompanyName);
    c.add(new JLabel("Eier Navn:"));
    c.add(textOwnerName);
    c.add(new JLabel("Eier Adresse:"));
    c.add(textOwnerAddress);
    c.add(new JLabel("RegistreringsNr:"));
    c.add(textVehicleRegNumber);
    c.add(new JLabel("Bilmerke:"));
    c.add(textVehicleMake);
    c.add(new JLabel("Bilmodell:"));
    c.add(textVehicleModel);
    c.add(new JLabel("Registreringsår"));
    c.add(textVehicleRegistrationYear);
    
    // Add Buttons
    c.add(buttonRegisterPerson);
    c.add(buttonRegisterCompany);
    c.add(buttonDeleteVehicle);
    c.add(buttonRegisterPersonalOwner);
    c.add(buttonRegisterCompanyOwner);
    c.add(buttonDeleteOwner);
    c.add(buttonChangeOwner);
    c.add(buttonShowOwner);
    c.add(buttonShowAll);
    
    // Add Display Area
    c.add(scroll);
    
    setSize(870, 400);
    setVisible(true);
  }
  
  private class BtnListener implements ActionListener { 
    @Override
    public void actionPerformed(ActionEvent e) {
      
      if(e.getSource() == buttonRegisterPerson)
        registerVehiclePrivate();
      else if (e.getSource() == buttonRegisterCompany)
        registerVehicleCompany();
      else if (e.getSource() == buttonDeleteVehicle)
        deleteVehicle();
      else if (e.getSource() == buttonRegisterPersonalOwner)
        registerPerson();
      else if (e.getSource() == buttonRegisterCompanyOwner)
        registerCompany();
      else if (e.getSource() == buttonDeleteOwner)
        deleteOwner();
      else if (e.getSource() == buttonChangeOwner)
        changeOwner();
      else if (e.getSource() == buttonShowOwner)
        showOwner();
      else if (e.getSource() == buttonShowAll)
        showAll();
    }
  }
  
  public void registerVehiclePrivate() {
    try {
      String regNumber = textVehicleRegNumber.getText();
      String make = textVehicleMake.getText();
      String model = textVehicleModel.getText();
      int regYear = Integer.parseInt(textVehicleRegistrationYear.getText());
      int ssn = Integer.parseInt(textSSN.getText());
      
      Vehicle v = new Vehicle(regNumber,make,model,regYear);
      registry.registerVehicle(ssn, v);
      
    } catch (NumberFormatException e) {
    }

  }
  
  public void registerVehicleCompany() {
    try {
      String regNumber = textVehicleRegNumber.getText();
      String make = textVehicleMake.getText();
      String model = textVehicleModel.getText();
      int regYear = Integer.parseInt(textVehicleRegistrationYear.getText());
      int firmID = Integer.parseInt(textCompanyName.getText());
      
      Vehicle v = new Vehicle(regNumber,make,model,regYear);
      registry.registerVehicle(firmID, v);
      
    } catch (NumberFormatException e) {
    }

  }
  
  public void deleteVehicle() {
    String regNr = textVehicleRegNumber.getText();
    
    if(registry.removeVehicle(regNr))
      display.setText("Bilen: " + regNr + " er nå slettet\n");
    else
      display.setText("Bilen: " + regNr + " kan ikke slettes."
              + "Enten finnes den ikke, eller så er det noen som eier den");
  }
  
  // * Register private owner
  public void registerPerson() {
    try {
      int ssn = Integer.parseInt(textSSN.getText());
      Person pOwner = new Person(textOwnerName.getText(), textOwnerAddress.getText(), null, ssn);
      
      registry.addOwner(pOwner);
    } catch (NumberFormatException e) {
      
    }
  }
  
  // * Register company owner
  public void registerCompany() {
    try {
      int firmID = Integer.parseInt(textCompanyName.getText());
      Company owner = new Company (textOwnerName.getText(), textOwnerAddress.getText(), null, firmID);
      
      registry.addOwner(owner);
    } catch (NumberFormatException e) {
      
    }
  }
  
  public void deleteOwner() {
    try {
    int ssn = Integer.parseInt(textSSN.getText());
    registry.removeOwner(ssn);
    }
    
    catch (NumberFormatException e) {
      
    }
  }
  
  public void changeOwner() {
    try {
      String regNr = textVehicleRegNumber.getText();
      int Ssn = Integer.parseInt(textSSN.getText());
    
    registry.changeOwner(regNr,Ssn);
    }
    
    catch (NumberFormatException e) {
      
    }
  }
  
  public void showOwner() {
    String owner = registry.findOwner(textVehicleRegNumber.getText());
    display.setText(owner);
  }
  
  public void showAll() {
    display.setText(registry.printRegistry());
  }
  
}
