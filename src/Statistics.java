import java.util.ArrayList;

public class Statistics {

    public static double totalTime = 0;
    public static double maxWaitingTime = 0;

    public static void updateTime(double time){
        totalTime+=(time-totalTime);
    }
    public static void setMaxWaitingTime(Passenger passenger){
        double waitingTime = passenger.getWaitingTime();
        if (waitingTime > maxWaitingTime) {
            maxWaitingTime = waitingTime;
        }
    }

    public static String getBusAverages(){
        String val = "--------------------BUS AVERAGES--------------------\n";
        for(Bus b: BusSim.busses){
            val+="Bus #" + b.getBusNumber() + " AVERAGE OCCUPANCY: " + b.getAverageOccupancy() +  "  | PMPG: " + b.getPMPG() +"\n";
        }
        return val;
    }

    public static String getAverageOccupancy(){
        String val = "";
        for(Bus b: BusSim.busses){
            val+="Bus #" + b.getBusNumber() + " AVERAGE OCCUPANCY: " + b.getAverageOccupancy() + "\n";
        }
        return val;
    }

    public static String numPaxPerBus(){
        String val = "";
        for (Bus b: BusSim.busses){
            val+= b.busStats() + "\n";
        }
        return val;
    }


    public static String getStopStats(){
        String val = "--------------------STOP AVERAGES--------------------\n";
        for(Stop stop: BusSim.stops){
            val += "STOP #" + (BusSim.stops.indexOf(stop) + 1) + "\n" + "AVERAGE WESTBOUND QUEUE LENGTH: " + (stop.getWestboundQueueLength()) + "\nAVERAGE EASTBOUND QUEUE LENGTH: " + (stop.getEastboundQueueLength()) + "\n_______________________________________________________________________________________\n";
        }
        return val;
    }


    public static String getBusStats(){
        return "Bus Statistics at time " + totalTime + "\n" + "__________________" + "\n"  + numPaxPerBus();
    }

    public static String getPassengerStats(){
        return "Max waiting time for a passenger so far: " + maxWaitingTime + " seconds \n" + "Average waiting time for passengers " + Passenger.getAverageWaitingTime() + " seconds \n";
    }
}
