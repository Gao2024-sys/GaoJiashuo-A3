// RideInterface.java
public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);  // Add visitor to queue
    void removeVisitorFromQueue(Visitor visitor);  // Remove visitor from queue
    void printQueue();  // Print all visitors in queue
    void runOneCycle();  // Run the ride for one cycle
    void addVisitorToHistory(Visitor visitor);  // Add visitor to ride history
    boolean checkVisitorFromHistory(Visitor visitor);  // Check if visitor is in history
    int numberOfVisitors();  // Return the number of visitors in history
    void printRideHistory();  // Print all visitors who took the ride
}
