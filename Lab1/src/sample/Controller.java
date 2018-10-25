package sample;
import sample.*;
import java.net.URL;
import javafx.scene.control.TextArea;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) { }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane createTrain;

    @FXML
    private ComboBox trainList;

    @FXML
    private ComboBox wagonList;

    @FXML
    private MenuItem addWagon, addSeat;

    @FXML
    private Pane infoTable;

    @FXML
    private TextArea infoArea;

    @FXML
    private TextField WagonNumber;

    @FXML
    private TextField trainNumber;

    @FXML
    private Pane createWagon;

    @FXML
    private Pane createSeat;

    @FXML
    private Label infoWindow;

    @FXML
    private TextField numberOfSeat;

    @FXML
    private TextField seatNumber;

    private ArrayList<Train> trains = new ArrayList<>();

    //Функция для открытия слоя с созданием поезда
    @FXML
    void createTrainMenu(ActionEvent event)
    {
        hidePanes(false, true, true, true);
        infoWindow.setText("Создание поезда");
    }

    //Функция для кнопки "Создать поезд"
    @FXML
    void createTrainButton(ActionEvent event)
    {
        //Проверка на корректность введенных данных
        boolean error = true;
        if (trainNumber.getText().equals(""))
        {
            infoWindow.setText("Пожалуйста, введите номер поезда!");
            error = false;
        }
        if (error)
        {
            for (int i = 0; i < trains.size(); i++)
            {
                if (trains.get(i).getTrainNumber().equals(trainNumber))
                {
                    infoWindow.setText("Поезд с таким номером уже существует!");
                    error = false;
                    break;
                }
            }
        }
        if (error)
        {
            //Добавление поезда в класс Train
            trains.add(new Train(trainNumber.getText()));
            infoWindow.setText("Информация успешно сохранена!");
            addWagon.setDisable(false);
            hidePanes(true, true, true, true);
            trainNumber.clear();
        }
    }

    //Функция открытия слоя с созданием вагона
    @FXML
    void createWagonMenu(ActionEvent event)
    {
        hidePanes(true, false, true, true);
        infoWindow.setText("Добавление вагона");
        trainList.getItems().clear();
        for (int i = 0; i < trains.size(); i++)
        {
            trainList.getItems().addAll(trains.get(i).getTrainNumber());
        }
        trainList.setValue(trains.get(0).getTrainNumber());
    }

    @FXML
    void createWagonButton(ActionEvent event) {
        boolean error = true;
        int wagonNumber = 0, seatNumber1 = 0;
        try
        {
            wagonNumber = Integer.parseInt(WagonNumber.getText());
            System.out.println(wagonNumber);
            seatNumber1 = Integer.parseInt(numberOfSeat.getText());
            System.out.println(seatNumber1);
        }
        catch (Exception e)
        {
            infoWindow.setText("Error!");
            error = false;
        }
        if (error)
        {
            for (int i = 0; i < trains.size(); i++)
            {
                System.out.println(trains.size());                                                  //Для примера
                if (trains.get(i).getTrainNumber().equals(trainList.getValue().toString()))
                {
                    System.out.println("Добавление вагона");
                    trains.get(i).addWagon(new Wagon(wagonNumber, seatNumber1));    //Добавление вагона в коллекцию вагонов в классе Train
                    System.out.println("" + trains.get(i).getWagones().size());   //Для примерв
                    break;
                }
            }
            infoWindow.setText("Успешно!");
            addSeat.setDisable(false);
            hidePanes(true, true, true, true);
            numberOfSeat.clear();
            WagonNumber.clear();
        }
    }

    @FXML
    void createSeatMenu(ActionEvent event)
    {
        hidePanes(true, true, false, true);
        wagonList.getItems().clear();
        infoWindow.setText("Создание места");
        for (int j = 0; j < trains.size(); j++)
        {
            for (int k = 0; k < trains.get(j).getWagones().size(); k++)
            {
                //wagonList.getItems().addAll(wagons.get(i).getWagonNumber() + " (" +  wagons.get(i).getTrain().getTrainNumber()+ ") ");
                wagonList.getItems().addAll(trains.get(j).getWagones().get(k).getWagonNumber() + " (" + trains.get(j).getTrainNumber() + ") ");
            }
            //wagonList.setValue(wagons.get(0).getWagonNumber() + " (" +  wagons.get(0).getTrain().getTrainNumber()+ ") ");
        }
        wagonList.setValue(trains.get(0).getWagones().get(0).getWagonNumber() + " (" + trains.get(0).getTrainNumber() + ") ");
    }

    @FXML
    void createSeatButton(ActionEvent event)
    {
        //String index = wagonList.getValue().toString();
        //int index1 = Integer.parseInt(index);
        int bracket = wagonList.getValue().toString().indexOf(" (");
        int clBracket = wagonList.getValue().toString().indexOf(")");
        int seatNumber1 = 0;
        int wagon = Integer.parseInt(wagonList.getValue().toString().substring(0, bracket));
        String train = wagonList.getValue().toString().substring(bracket + 2, clBracket);
        int train1 = Integer.parseInt(train);
        boolean error = true;
        try
        {
            seatNumber1 = Integer.parseInt(seatNumber.getText());
        }
        catch (Exception e)
        {
            infoWindow.setText("Некорректное значение!");
            error = false;
        }
        if (error) {
            for (int j = 0; j < trains.size(); j++) {
                for (int i = 0; i < trains.get(j).getWagones().size(); i++) {
                    if (seatNumber1 < 1 || seatNumber1 > 54 || seatNumber1 > trains.get(j).getWagones().get(i).getNumberOfSeats())
                    {
                        infoWindow.setText("Некорректное значение!");
                        error = false;
                        break;
                    }
                }
            }
        }
        if (error)
        {
            for (int j = 0; j < trains.size(); j++)
            {
                for (int i = 0; i < trains.get(j).getWagones().size(); i++)
                {
                    System.out.println("Добавление места");
                    if ((trains.get(j).getWagones().get(i).getWagonNumber() == wagon) && trains.get(j).getTrainNumber().equals(train))
                    {
                        trains.get(j).getWagones().get(i).addSeat(new Seat(seatNumber1));
                        System.out.println("Добавление места");
                        break;
                    }
                }
            }
            infoWindow.setText("Успешно!");
            hidePanes(true, true, true, true);
            seatNumber.clear();
        }
    }

    @FXML
    void showInfo(ActionEvent event)
    {
        hidePanes(true, true, true, false);
        infoArea.clear();
        for (int i = 0; i < trains.size(); i++) {
            for (int j = 0; j < trains.get(i).getWagones().size(); j++) {
                for (int k = 0; k < trains.get(i).getWagones().get(j).getSeat().size(); k++) {
                    infoArea.appendText("= = = = = = = = = = = = = = = = = = = = = =\n");
                    infoArea.appendText("Место:\n");
                    infoArea.appendText("   Номер места: " + trains.get(i).getWagones().get(j).getSeat().get(k).getSeatNumver() + "\n");
                    infoArea.appendText("Вагон:\n");
                    infoArea.appendText("   Номер вагона: " + trains.get(i).getWagones().get(j).getWagonNumber() + "\n");
                    infoArea.appendText("   Кол-во мест в вагоне: " + trains.get(i).getWagones().get(j).getNumberOfSeats() + "\n");
                    infoArea.appendText("Поезд:\n");
                    infoArea.appendText("   Номер поезда: " + trains.get(i).getTrainNumber() + "\n");
                    infoArea.appendText("= = = = = = = = = = = = = = = = = = = = = =\n");
                }
            }
        }
    }

    @FXML
    void initialize()
    {
        assert createTrain != null : "fx:id=\"createTrain\" was not injected: check your FXML file 'sample.fxml'.";
        assert trainList != null : "fx:id=\"trainList\" was not injected: check your FXML file 'sample.fxml'.";
        assert wagonList != null : "fx:id=\"wagonList\" was not injected: check your FXML file 'sample.fxml'.";
        assert infoTable != null : "fx:id=\"infoTable\" was not injected: check your FXML file 'sample.fxml'.";
        assert WagonNumber != null : "fx:id=\"WagonNumber\" was not injected: check your FXML file 'sample.fxml'.";
        assert trainNumber != null : "fx:id=\"trainNumber\" was not injected: check your FXML file 'sample.fxml'.";
        assert createWagon != null : "fx:id=\"createWagon\" was not injected: check your FXML file 'sample.fxml'.";
        assert createSeat != null : "fx:id=\"createSeat\" was not injected: check your FXML file 'sample.fxml'.";
        assert infoWindow != null : "fx:id=\"infoWindow\" was not injected: check your FXML file 'sample.fxml'.";
        assert seatNumber != null : "fx:id=\"seatNumber\" was not injected: check your FXML file 'sample.fxml'.";

    }

    //Функция скрытия слоев
    public void hidePanes(boolean createTrain, boolean createWagon, boolean createSeat, boolean infoTable)
    {
        if (createTrain)
        {
            this.createTrain.setVisible(false);
        }
        else
        {
            this.createTrain.setVisible(true);
        }
        if (createWagon)
        {
            this.createWagon.setVisible(false);
        }
        else
        {
            this.createWagon.setVisible(true);
        }
        if (createSeat)
        {
            this.createSeat.setVisible(false);
        }
        else
        {
            this.createSeat.setVisible(true);
        }
        if (infoTable)
        {
            this.infoTable.setVisible(false);
        }
        else
        {
            this.infoTable.setVisible(true);
        }
    }

}

