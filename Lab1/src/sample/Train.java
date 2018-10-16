package sample;


import java.util.ArrayList;

public class Train
{
    private String trainNumber;
    private ArrayList<Wagon> wagons;

    public Train(String trainNumber)
    {
        this.trainNumber = trainNumber;
        wagons = new ArrayList<>();
    }

    public String getTrainNumber()
    {
        return trainNumber;
    }

    public ArrayList<Wagon> getWagones()
    {
        return wagons;
    }

    public void addWagon (Wagon wagon)
    {
        wagons.add(wagon);
    }
}
