package com.champlain.oop2a1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.time.LocalDate;

/**
 * Controller class for handling user interactions in the Person View GUI.
 * This class manages the input, display, and interaction logic for a {@link Person} object,
 * including saving data, loading example data, and purchasing a parking pass.
 */
public class PersonViewController {
    /** Label to display parking pass status. */
    @FXML
    private Label aParkingPassLabel;

    /** Text field to input the person's name. */
    @FXML
    private TextField aNameTextField;

    /** Date picker to input the person's date of birth. */
    @FXML
    private DatePicker aDOBDatePicker;

    /** Text field to input the person's email address. */
    @FXML
    private TextField aEmailAddressTextField;

    /** The person object being created or modified through the GUI. */
    private Person aPerson;

    /**
     * Called when the "Save" button is clicked.
     * Validates and saves the entered person data into the {@link Person} object.
     * If successful, displays a confirmation dialog.
     * If validation fails, displays an error alert.
     */
    @FXML
    protected void onSaveButtonClick() {
        try {
            this.aPerson = new Person(aNameTextField.getText(), aDOBDatePicker.getValue(), aEmailAddressTextField.getText());
        } catch (IllegalArgumentException e) {
            handleInputError(e);
            return;
        }

        this.displayPerson(this.aPerson);
        Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION, this.aPerson.toString() + " saved successfully!");
        successAlert.showAndWait();
    }

    /**
     * Called when the "Load Example" button is clicked.
     * Loads a sample {@link Person} with pre-defined values and displays it in the form.
     * If setting sample data fails (which should not normally happen), shows an error.
     */
    @FXML
    protected void onLoadExampleButtonClick() {

        try {
            this.aPerson = new Person("John Doe", LocalDate.of(2000, 1, 1), "john@gmail.com");
        } catch (IllegalArgumentException e) {
            handleInputError(e);
        }

        this.displayPerson(this.aPerson);
    }

    /**
     * Called when the "Buy Pass" button is clicked.
     * Attempts to purchase a parking pass for the {@link Person}.
     * If already owned, displays an error alert.
     */
    @FXML
    protected void onBuyPassButtonClick() {
        // Making sure there is a Person object to work with.
        if (this.aPerson == null) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "No person has been saved yet.");
            errorAlert.showAndWait();
        } else {
            // Changing the value and displaying it.
            boolean purchaseResult = this.aPerson.purchaseParkingPass();
            this.displayPerson(this.aPerson);
            if (!purchaseResult) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "This person already had a parking pass! Don't waste my money!");
                errorAlert.showAndWait();
            }
        }
    }

    /**
     * Updates the GUI form fields with the data from the given {@link Person} object.
     * Also updates the parking pass label with appropriate message and color.
     *
     * @param pPerson The person object whose data is to be displayed.
     */
    private void displayPerson(Person pPerson) {
        aNameTextField.setText(aPerson.getName());
        aDOBDatePicker.setValue(aPerson.getDOB());
        aEmailAddressTextField.setText(aPerson.getEmailAddress());
        if (pPerson.isPurchasedParkingPass()) {
            aParkingPassLabel.setText("This person has a parking pass!");
            aParkingPassLabel.setTextFill(Color.color(0, 1, 0));
        } else {
            aParkingPassLabel.setText("This person does not have a parking pass!");
            aParkingPassLabel.setTextFill(Color.color(1, 0, 0));
        }
    }

    /**
     * Displays an error alert dialog with a message derived from the given exception.
     *
     * @param pException The {@link IllegalArgumentException} that occurred due to invalid input.
     */
    private void handleInputError(IllegalArgumentException pException) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Entered data invalid: " + pException.getMessage());
        errorAlert.showAndWait();
    }
}