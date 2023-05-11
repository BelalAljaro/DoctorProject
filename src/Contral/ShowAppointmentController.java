/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contral;

import View.ViewManger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ShowAppointmentController implements Initializable {

    @FXML
    private Button showPaBTN;
    @FXML
    private Button showApBTN;
    @FXML
    private Button bookedApBTN;
    @FXML
    private Button logoutBTN;
    @FXML
    private TableView<Appointment> tableView;
    @FXML
    private TableColumn<Appointment, Integer> idCol;
    @FXML
    private Button updateInfo;
    @FXML
    private TableColumn<Appointment, Date> appointment_date;
    @FXML
    private TableColumn<Appointment,Date> appointment_day;
    @FXML
    private TableColumn<Appointment, Date> appointment_time;
    @FXML
    private TableColumn<Appointment, String> status;
    @FXML
    private Button createA;
    @FXML
    private Button deleteA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try {
            // TODO
            Class.forName("com.mysql.cj.jdbc.Driver");
                        String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
            String usernameD = "root";
            String passwordD = "";
            Connection connection = DriverManager.getConnection(url1, usernameD, passwordD);
            Statement stat = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        appointment_date.setCellValueFactory(new PropertyValueFactory(" appointment_date"));
        appointment_day.setCellValueFactory(new PropertyValueFactory("appointment_day"));
       appointment_time.setCellValueFactory(new PropertyValueFactory("appointment_time"));
      status.setCellValueFactory(new PropertyValueFactory("status"));
       
    }    

    @FXML
    private void ShowPatient(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToShowPation();
    }

    @FXML
    private void ShowAppointment(ActionEvent event) {
                    try {
            String Sql="SELECT * FROM  appointment ";
            ResultSet rs=stat.executeQuery(Sql);
            while(rs.next()){
               Appointment appointment=new  Appointment();
               appointment.setId(rs.getInt("id"));
               appointment.setAppointment_date(rs.getDate("appointment_date"));
               appointment.setAppointment_day(rs.getDate("appointment_day"));
               appointment.setAppointment_time(rs.getDate("appointment_time"));
               appointment.setStatus(rs.getString("status"));              
                this.tableView.getItems().add(appointment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShowPatientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void BookedAppointment(ActionEvent event) {
        ViewManger.dashBorad.changeSceneToBookedAppointment();
    }

    @FXML
    private void logout(ActionEvent event) {
        ViewManger.closedashBorad();
    }

    @FXML
    private void careteAppointment(ActionEvent event) {
    }

    @FXML
    private void UpdateAppointment(ActionEvent event) {
    }

    @FXML
    private void deleteAppointment(ActionEvent event) {
    }
    
}
