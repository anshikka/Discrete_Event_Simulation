import java.util.ArrayList;

public class Bus {
    private ArrayList<Passenger> passengers;
    private int capacity;
    private int busNumber;
    private int numPax;
    private int MPG;
    private int trips;
    private boolean direction;
    private int totalNumPaxOverTime;


    public Bus(int busNumber, int capacity, boolean direction, int MPG){
        this.busNumber = busNumber;
        this.capacity = capacity;
        this.direction = direction;
        this.MPG = MPG;
        totalNumPaxOverTime = 0;
        trips = 0;
        passengers = new ArrayList<>(capacity);
    }

    public ArrayList<Passenger> removePassengersAtStop(int stop){
        ArrayList<Passenger> temp = new ArrayList<>();
        for(Passenger p: passengers){
            if (p.getDestination() == stop) {
                temp.add(p);

            }
        }
        for (Passenger t : temp){
            passengers.remove(t);
        }
        return temp;
    }

    public int getMPG(){
        return MPG;
    }

    public boolean getDirection(){
        return direction;
    }

    public String getDirectionName(){
        if(direction == true){
            return "Westbound";
        } else {
            return "Eastbound";
        }
    }

    public int getNumPax(){
        numPax = passengers.size();
        return numPax;
    }

    public int getBusNumber(){
        return busNumber;
    }

    public void reverseDirection(){
        if (direction == false){ // east switch to west
            direction = true;
        } else { // west switch to east
            direction = false;
        }
    }

    public void addTrip(){
        trips++;
    }

    public double getAverageOccupancy(){
        return totalNumPaxOverTime/trips;
    }

    public double getPMPG(){
        return getAverageOccupancy() * MPG;
    }


    public void addPassenger (Passenger p){
        passengers.add(p);
        totalNumPaxOverTime++;
    }

    public int getTotalNumPaxOverTime(){
        return totalNumPaxOverTime;
    }

    public boolean isFull(){
        return passengers.size() == capacity;
    }

    public String toString(){
        return "Bus #" + busNumber + " with " + getNumPax() + " passengers going " + getDirectionName();
    }

    public String busStats(){
        return "Bus #" + busNumber + " carrying " + getNumPax() + " passengers";
    }


}
