package sample;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.Domain.Car;
import sample.Service.CarService;

public class Controller {
    public TableView tableViewCars;
    public TableColumn tableColumnCarId;
    public TableColumn tableColumnModel;
    public TableColumn tableColumnKm;
    public TableColumn tableColumnDays;
    public TextField txtCarId;
    public TextField txtModel;
    public TextField txtKm;
    public TextField txtDays;
    public Button btnAdd;
    public TextField txtSumKm;
    public TextField txtSumKmResult;
    public Button btnSumForCar;

    private CarService carService;
    private ObservableList<Car> cars = FXCollections.observableArrayList();

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String carId = txtCarId.getText();
            String model = txtModel.getText();
            double km = Double.parseDouble(txtKm.getText());
            double days = Double.parseDouble(txtDays.getText());
            carService.add(carId, model, km, days);

            txtCarId.clear();
            txtModel.clear();
            txtKm.clear();
            txtDays.clear();

            cars.clear();
            cars.addAll(carService.getAll());

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void setServices(CarService carService) {
        this.carService = carService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            cars.addAll(carService.getAll());
            tableViewCars.setItems(cars);
        });
    }

    public void btnSumForCarClick(ActionEvent actionEvent) {
        try {
            String carId = txtCarId.getText();
            double sumKm = carService.getCarKm(carId);
            txtSumKmResult.setText(String.valueOf(sumKm));}
        catch(RuntimeException rex){
                Common.showValidationError(rex.getMessage());
            }

        }
    }