public class Passenger {
    private int start;
    private int destination;
    private double waitingTime;
    private double startTime;
    private boolean direction; //true if west; false if east
    private boolean pickedUp;
    public static int totalPaxGenerated;
    public static long totalWaitingTimeForAllPax;

    public Passenger(int start, int destination, boolean direction) {
        this.start = start;
        this.destination = destination;
        this.direction = direction;
        startTime = Statistics.totalTime;
        totalPaxGenerated++;
    }

    public String getDirectionName(){
        if(direction == true){
            return "Westbound";
        } else {
            return "Eastbound";
        }
    }

    private int intRandomInterval(int low, int high) { //Borrowed from CSCI 1933 Lecture Examples
        return (int) Math.floor((high - low) * Math.random() + low + 0.5);
    }

    public void setPickedUp(){
        pickedUp = true;
    }

    public double getWaitingTime(){
        waitingTime = Statistics.totalTime - startTime;
        totalWaitingTimeForAllPax+= waitingTime;
        return waitingTime;
    }



    public static double getAverageWaitingTime(){
        return totalWaitingTimeForAllPax/totalPaxGenerated;
    }

    public boolean getDirection() {
        return direction;
    }

    public int getDestination() {
        return destination;
    }

    public int getStart() {
        return start;
    }

    public String toString(){
        return "PASSENGER GENERATED || Stop #" + start + " || STOP NAME: " + BusSim.stops.get(start).getStopName() + " || DIRECTION: " + getDirectionName() + " || DESTINATION " + destination + " @ " + BusSim.stops.get(destination).getStopName();
    }
}

