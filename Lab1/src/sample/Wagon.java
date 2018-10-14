package sample;
import sample.Train;

public class Wagon
{
    private String wagonNumber;            //Номер вагона
    private String numberOfSeats;          //Кол-во мест в вагоне
    private Train train;                //Вагон какого поезда


    public Wagon(String wagonNumber, String numberOfSeats, Train train)
    {
        this.wagonNumber = wagonNumber;
        this.numberOfSeats = numberOfSeats;
        this.train = train;
    }

    public String getWagonNumber()
    {
        return wagonNumber;
    }

    public String getNumberOfSeats()
    {
        return numberOfSeats;
    }

    public Train getTrain()
    {
        return train;
    }
}
