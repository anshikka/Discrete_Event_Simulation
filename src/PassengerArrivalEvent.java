public class PassengerArrivalEvent implements Event {

    private int destination;
    private int start;

    public PassengerArrivalEvent(){}


    public void run(){
        start = generateStart();
        destination = generateDestination();
        Passenger p = new Passenger(start, destination, setDirection());
        BusSim.stops.get(start).addPaxToQueue(p);
        Statistics.updateTime(BusSim.agenda.getCurrentTime()+generatePassengerArrivalDistribution());
        BusSim.agenda.add(new PassengerArrivalEvent(), Statistics.totalTime);
        //System.out.println(p.toString());
    }


    public int generatePassengerArrivalDistribution(){
        int normDist[] = {210, 210, 180, 180, 180, 144, 144, 144, 144, 120, 120, 96, 96, 96, 96, 60, 60, 60, 30, 30};
        int popDist[] = {210, 210, 180, 180, 180, 144, 144, 144, 144, 120, 120, 96, 96, 96, 96, 60, 60, 60, 60, 60, 60, 30, 30};
        if(start != 7 || start != 8 || start != 9)
            return normDist[intRandomInterval(0, normDist.length-1)];
        else
            return popDist[intRandomInterval(0, popDist.length-1)];
    }



    private int intRandomInterval(int low, int high) { //Borrowed from CSCI 1933 Lecture Examples
        return (int) Math.floor((high - low) * Math.random() + low + 0.5);
    }

    private int generateStart(){
        int dist[] = {0, 1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9};
        return dist[intRandomInterval(0, dist.length-1)];
    }

    private int generateDestination(){
        int dist[] = {0, 1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9};
        if(dist[intRandomInterval(0, dist.length-1)] != start){
            return dist[intRandomInterval(0, dist.length-1)];

        } else {
            return dist[intRandomInterval(0, dist.length-1)] + 1;
        }
    }



    private boolean setDirection(){
        if(start < destination){
            return false; //go east
        }
        else
            return true; //go west
    }




}