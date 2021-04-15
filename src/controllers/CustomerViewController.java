package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Customer;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.SelectionMode.MULTIPLE;

public class CustomerViewController {

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
    private Label InfoLabel;

    @FXML
    private void createNewCustomers(){
        if (fieldsArePopulated())
        {
            try {
                Customer customer = new Customer(firstNameTextField.getText(),
                        lastNameTextField.getText(),
                        addressTextField.getText(),
                        genderTextField.getText(),
                        birthdayDatePicker.getValue());
                       //infoLabel.setText(customer.toString());

                //int studentNum = DBUtility.insertStudentIntoDB(newStudent);
                //customer.setStudentNum(studentNum);

            }catch(IllegalArgumentException e)
            {
                //infoLabel.setText(e.getMessage());
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
        //infoLabel.setText(errMsg.substring(0, errMsg.length()-2));
        return false;
    }
    @FXML
    private void changeToDashboard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/DashboardViewController.fxml","Food Ordering");
    }
}



