import java.util.ArrayList;

public class BusSim {
    public static PQ agenda = new PQ();
    public static int runtime = 10000; //INPUT TIME HERE
    public static ArrayList<Stop> stops = new ArrayList<>();
    public static ArrayList<PassengerArrivalEvent> events = new ArrayList<>();
    public static ArrayList<Bus> busses = new ArrayList<>();
    public static ArrayList<BusEvent> busEvents = new ArrayList<>();
    //public static int[] busSizes;


    public static void main(String[] args){
        init();
        while(agenda.getCurrentTime() <= runtime) {
            agenda.remove().run();
            //System.out.println(Statistics.getStopStats());
            //
        }
        System.out.println(Statistics.getBusAverages());
        System.out.println(Statistics.getPassengerStats());
        System.out.println(Statistics.getStopStats());
   }

    public static void init(){ // initialize all stops
        stops.add(new Stop("University Ave and 27th Street SE", 1));
        stops.add(new Stop("Raymond Ave Station", 2));
        stops.add(new Stop("University Ave and Fairview Ave", 3));
        stops.add(new Stop("University Ave and Snelling Ave", 4));
        stops.add(new Stop("University Ave and Lexington Parkway", 5));
        stops.add(new Stop("University Ave and Dale Street", 6));
        stops.add(new Stop("University Ave and Marion Street", 7));
        stops.add(new Stop("Cedar Street and 5th Street", 8));
        stops.add(new Stop("Minnesota Street and 4th Street", 9));
        stops.add(new Stop("Union Depot", 10));

        //add busses to simulation
        busses.add(new Bus(1, 40, true, 6));
        busses.add(new Bus(2, 40, false, 6));
        busses.add(new Bus(3, 40, true, 6));
        busses.add(new Bus(4, 40, false, 6));
        busses.add(new Bus(5, 40, true, 6));
        busses.add(new Bus(6, 40, false, 6));
        busses.add(new Bus(7, 40, true, 6));
        busses.add(new Bus(8, 40, false, 6));
        busses.add(new Bus(9, 40, true, 6));
        busses.add(new Bus(10, 40, false, 6));
        busses.add(new Bus(11, 40, true, 6));
        busses.add(new Bus(12, 40, false, 6));
        busses.add(new Bus(13, 40, true, 6));
        busses.add(new Bus(14, 40, false, 6));
        busses.add(new Bus(15, 40, true,6));
        busses.add(new Bus(16, 40, false, 6));
        busses.add(new Bus(17, 40, true, 6));
        busses.add(new Bus(18, 40, true, 6));
        busses.add(new Bus(19, 40, false, 6));
        busses.add(new Bus(20, 40, true, 6));
        busses.add(new Bus(21, 40, false, 6));
        busses.add(new Bus(22, 40, true,6));
        busses.add(new Bus(23, 40, false, 6));
        busses.add(new Bus(24, 40, true, 6));



        for(int i = 0; i < 500; i++){

            events.add(new PassengerArrivalEvent());
            events.get(i).run();
        }

        //start running busses
        busEvents.add(new BusEvent(0, busses.get(0)));
        busEvents.add(new BusEvent(1, busses.get(1)));
        busEvents.add(new BusEvent(1, busses.get(2)));
        busEvents.add(new BusEvent(2, busses.get(3)));
        busEvents.add(new BusEvent(2, busses.get(4)));
        busEvents.add(new BusEvent(3, busses.get(5)));
        busEvents.add(new BusEvent(3, busses.get(6)));
        busEvents.add(new BusEvent(4, busses.get(7)));
        busEvents.add(new BusEvent(4, busses.get(8)));
        busEvents.add(new BusEvent(5, busses.get(9)));
        busEvents.add(new BusEvent(5, busses.get(10)));
        busEvents.add(new BusEvent(6, busses.get(11)));
        busEvents.add(new BusEvent(6, busses.get(12)));
        busEvents.add(new BusEvent(7, busses.get(13)));
        busEvents.add(new BusEvent(7, busses.get(14)));
        busEvents.add(new BusEvent(8, busses.get(15)));
        busEvents.add(new BusEvent(8, busses.get(16)));
        busEvents.add(new BusEvent(9, busses.get(17)));
        busEvents.add(new BusEvent(9, busses.get(18)));
        busEvents.add(new BusEvent(1, busses.get(19)));
        busEvents.add(new BusEvent(2, busses.get(20)));
        busEvents.add(new BusEvent(3, busses.get(21)));
        busEvents.add(new BusEvent(4, busses.get(22)));
        busEvents.add(new BusEvent(5, busses.get(23)));

        for(int j = 0; j < busEvents.size(); j++){ //run all busses
            busEvents.get(j).run();
        }
    }

}