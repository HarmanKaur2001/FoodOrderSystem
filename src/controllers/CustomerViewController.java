package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Customer;
import utilities.DButilities;
import utilities.SceneChanger;

import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.SelectionMode.MULTIPLE;

public class CustomerViewController{

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
    void infoCustomersButton(ActionEvent event) {
        try {
            Customer customer = new Customer(firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    addressTextField.getText(),
                    genderTextField.getText(),
                    birthdayDatePicker.getValue());
            DButilities.addCustomer(customer);

        }catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    private void changeToDashboard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/DashboardViewController.fxml", "Food Ordering");
    }



}



