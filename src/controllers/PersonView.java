package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import models.Person;

import java.sql.SQLException;

public class PersonView {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField genderTextField;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML

    private Label infoLabel;
    private void Person(){
        if (fieldsArePopulated())
        {
            try {
                Person newPerson = new Person(firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        addressTextField.getText(),
                        genderTextField.getText(),
                        birthdayDatePicker.getValue());

                //newPerson.setStudentNum(studentNum);
                infoLabel.setText(newPerson.toString());
            }catch(IllegalArgumentException e)
            {
                infoLabel.setText(e.getMessage());
            }
        }
    }

    private boolean fieldsArePopulated()
    {
        String errMsg = "The following fields are empty: ";
        if (firstNameTextField.getText().isEmpty())
            errMsg += "first name, ";

        if (lastNameTextField.getText().isEmpty())
            errMsg += "last name, ";

        if (addressTextField.getText().isEmpty())
            errMsg += "address, ";

        if (birthdayDatePicker.getValue()==null)
            errMsg += "birthday, ";

        if (errMsg.equals("The following fields are empty: "))
            return true;

        //there was at least 1 empty field
        infoLabel.setText(errMsg.substring(0, errMsg.length()-2));
        return false;
    }

}
