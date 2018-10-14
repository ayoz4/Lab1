package sample;
        import sample.Wagon;

public class Seat
{
    private int seatNumber;         //Номер места
    Wagon wagon;                    //В каком вагоне место

    public Seat(int seatNumber, Wagon wagon)
    {
        this.seatNumber = seatNumber;
        this.wagon = wagon;
    }

    public int getSeatNumver()
    {
        return seatNumber;
    }

    public  Wagon getWagon()
    {
        return wagon;
    }
}
