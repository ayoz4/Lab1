package sample;
import sample.Train;

import java.util.ArrayList;

public class Wagon
{
    private int wagonNumber;            //Номер вагона
    private int numberOfSeats;          //Кол-во мест в вагоне
    private ArrayList<Seat> seats;      //Вагон какого поезда


    public Wagon(int wagonNumber, int numberOfSeats)
    {
        this.wagonNumber = wagonNumber;
        this.numberOfSeats = numberOfSeats;
        seats = new ArrayList<>();
    }

    public int getWagonNumber()
    {
        return wagonNumber;
    }

    public int getNumberOfSeats()
    {
        return numberOfSeats;
    }

    public ArrayList<Seat> getSeat()
    {
        return seats;
    }

    public void addSeat(Seat seat)
    {
        seats.add(seat);
    }
}
