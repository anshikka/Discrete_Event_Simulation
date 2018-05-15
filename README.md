# Discrete Event Simulation: Bus Simulation

## Author Information
|Name | x500|
|--|--|
|Ansh Sikka| sikka008  |
|Jared Mowery|mower010 |






# Instructions

 1. Make sure you are using a machine with a running JVM 7 or later.
 2. Unzip all the files into a folder and import it as a project in your preferred IDE (IntelliJ IDEA recommended).
 3. Run the main method in BusSim.java
 4. Time can be changed by modifying the variable `public static int runtime` at the top of the file.
 5. To change bus sizes, scroll down to where the `busses.add(new Bus(...);` statements are. Change the `capacity` (second argument) to suit the given criteria. 
 6. Re-Run the main class with the newly set arguments!

# Project Hierarchy

The project contains a number of files that are vital to the operation of the simulation program. They include: 

 - `Bus.java`
	 - Capacity
	 - Bus Number
	 - Number of Passengers
	 - MPG
	 - Number of Trips
	 - Direction
	 - Total Number of Passengers over all Time
 - `Stop.java`
	 - Eastbound Queue
	 - Westbound Queue
	 - Stop Name
	 - Stop Number
 - `Passenger.java`
	 - Departure Point
	 - Destination
	 - Waiting Time
	 - Starting Time
	 - Direction
	 - Total Passengers Generated (Static)
	 - Total Waiting Time for all Passengers (Static)
 - `BusEvent.java`
	 - Current Stop Bus is At
	 - Current Bus
 - `PassengerArrivalEvent.java`
	 - Generated Departure Point Based on Distribution
	 - Generated Destination Based on Distribution
	 - Time Distribution 
 - `BusSim.java`(MAIN CLASS)
	 - All Busses
	 - All BusEvents
	 - All PassengerArrivalEvents
 - `Statistics.java`
	 - Total Time
	 - Average Waiting Time for Passenger
	 - Average Queue Length
	 - Average Travel Time
	 - Bus Statistics
		 - Passengers (Average)
		 - PMPG
 - `Event.java` (INTERFACE)
 - `IQ.java` (INTERFACE)
 - `Q.java` 
	 - Queue Data Structure
 - `PQInterface.java` (INTERFACE)
 - `PQ.java`
	 - Priority Queue Data Structure
 - `Segment.java`
	 - Timing Class

# Data Structures Used

 - **Queues**: Since in the real world, passengers stand behind each other in line to use a service (first come, first-served), a queue was the best way to handle passengers at the bus stop. 
 - **Priority Queues**: Timing is a major part of a simulation. Different events have different priorities. In real life, it works the same way. Using priority queues to set up an agenda to run the simulation in a set order can help simulate the real-world scenario.

# Main Algorithms Used

 - `randomInterval(int low, int high)`: Used for calculating a random index within a distribution of arrays including a distribution of selective stops and passenger arrival timings. Using one method that calculates this made all random generation simple.
 - `setMaxWaitingTime(Passenger passenger)`: Updated the maximum waiting time by comparing the newest passenger's waiting time to the one before it. If it is larger, the new waiting time is the maximum waiting time. The maximum waiting time is very important in determining worst-case secnarios. 


# Issues/Bugs

 - Busses occasionally clump, leaving some busses to be full and others to be rather empty.
 - Sometimes the stop queues get unrealistically long over a long time
 - The timing can be off at times.
 - Statistics will sometimes calculate the opposite of what's right. (Decreasing busses dereases wait time.) 







### Credits

 - CSCI 1933 Moodle Site
	 - `randomInterval(int low, int high)`
	 - `Q.java`
	 - `IQ.java`
	 - `PQ.java`
	 - `PQInterface.java`
	 - `Segment.java`
	 - `Event.java`
