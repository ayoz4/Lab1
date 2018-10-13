package sample;
import sample.Train;

public class Wagon
{
    private int wagonNumber;            //Номер вагона
    private int numberOfSeats;          //Кол-во мест в вагоне
    private Train train;                //Вагон какого поезда


    public Wagon(int wagonNumber, int numberOfSeats, Train train)
    {
        this.wagonNumber = wagonNumber;
        this.numberOfSeats = numberOfSeats;
        this.train = train;
    }

    public int getWagonNumber()
    {
        return wagonNumber;
    }

    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }
}
