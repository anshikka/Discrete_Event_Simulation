import java.util.ArrayList;

public class Stop {
    private Q<Passenger> eastbound = new Q<>();
    private Q<Passenger> westbound = new Q<>();
    private String stopName;
    private int stopNumber;

    public Stop(String stopName, int stopNumber){
        this.stopName = stopName;
        this.stopNumber = stopNumber;
    }

    public void addPaxToQueue(Passenger p){
        if (p.getDirection() == true){
            westbound.add(p);
        } else
            eastbound.add(p);
    }

    public Passenger getPaxFromQueue(boolean direction){
        if(direction == true){ // switch easbound to westbound
            return westbound.remove();
        } else { // switch westbound to eastbound
            return eastbound.remove();
        }
    }

    public boolean queueEmpty(boolean direction){
        if (direction == true){
            return westbound.length() == 0;
        } else {
            return eastbound.length() == 0;
        }
    }

    public int getWestboundQueueLength(){
        return westbound.length();
    }

    public int getEastboundQueueLength(){
        return eastbound.length();
    }

    public String getStopName(){
        return stopName;
    }

}
