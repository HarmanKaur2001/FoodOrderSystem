package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Orders;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OrderViewController implements Initializable {

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
    private TextField orderIdTextField;

    @FXML
    private ComboBox ordersComboBox;

    @FXML
    private DatePicker orderDatePicker;

    @FXML
    private TextField priceTextField;

    @FXML
    void submitButton(ActionEvent event) throws IOException {
        if (ordersComboBox.getValue()!=null && orderDatePicker.getValue()!=null)
        {
            Orders orders = new Orders(ordersComboBox.getValue(),
                    orderIdTextField.getId(),
                    priceTextField.getText());
            //insert the course into the DB
            /*int crn = DBUtility.insertNewCourse(course);
            course.setCrn(Integer.toString(crn));

            errMsgLabel.setText(course.toString());*/
        }

    }

   /* @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //populate the course code combobox
        courseCodeComboBox.getItems().addAll(DBUtility.getAvailableCourseCodes());
    }*/





    @FXML
    private void changeToDashboard(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "../views/DashboardViewController.fxml","Food Ordering");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
