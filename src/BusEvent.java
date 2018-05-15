import java.util.ArrayList;

public class BusEvent implements Event {
    private int curStop;
    private Bus bus;

    public BusEvent(int curStop, Bus bus){
        this.curStop = curStop;
        this.bus = bus;
    }
    @Override
    public void run() {
        deboard();
        board();
        travel();
        BusSim.agenda.add(this, Statistics.totalTime);
    }

    public void travel(){
        Statistics.updateTime(BusSim.agenda.getCurrentTime()+15.0); // time spent waiting at current stop
        checkDirection(); // checks if it has reached end of route and reverses direction
        if (bus.getDirection() == false){ // eastbound
            curStop += 1;
        } else {
            curStop -= 1;
        }
        bus.addTrip();
        Statistics.updateTime(BusSim.agenda.getCurrentTime()+180);


    }

    public void deboard(){
        ArrayList<Passenger> removed = bus.removePassengersAtStop(curStop);
        int count = removed.size();
        Statistics.updateTime(BusSim.agenda.getCurrentTime() +(2 * count)); // 2 seconds for each passenger to get off
        //System.out.println(bus.toString() + " de-boarded " + count + " passengers at " + BusSim.stops.get(curStop).getStopName() + " at time " + Statistics.totalTime);
    }

    public void board(){
        while(!bus.isFull() && !BusSim.stops.get(curStop).queueEmpty(bus.getDirection())){
            Passenger newPassenger = BusSim.stops.get(curStop).getPaxFromQueue(bus.getDirection());
            newPassenger.setPickedUp();
            //System.out.println("PAX WAITING TIME: " + newPassenger.getWaitingTime());
            Statistics.setMaxWaitingTime(newPassenger);
            bus.addPassenger(newPassenger);
            Statistics.updateTime(BusSim.agenda.getCurrentTime()+3);
        }

    }

    public void checkDirection(){
        if (curStop + 1 > 9 || curStop - 1 < 0){
            bus.reverseDirection();
        }
    }

}
