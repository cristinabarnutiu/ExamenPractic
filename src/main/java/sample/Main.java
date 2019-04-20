package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Domain.Car;
import sample.Domain.IValidator;
import sample.Domain.CarValidator;
import sample.Repository.FileRepository;
import sample.Repository.IRepository;
import sample.Service.CarService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = fxmlLoader.load();

        Controller controller =  fxmlLoader.getController();

        IValidator<Car> carValidator = new CarValidator();
        IRepository<Car> carIRepository= new FileRepository<>(carValidator, "cars.json", Car[].class);

        CarService carService = new CarService(carIRepository);
        carService.add("1", "honda", 1, 20);
        carService.add("2", "opel", 2, 30);
        carService.add("3", "toyota", 3, 40);

        controller.setServices(carService);

        primaryStage.setTitle("Car manager");
        primaryStage.setScene(new Scene(root, 650, 500));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
