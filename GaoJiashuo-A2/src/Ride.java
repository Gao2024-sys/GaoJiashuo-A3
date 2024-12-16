import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Ride implements RideInterface {
    private String rideName;
    private Employee operator;
    private int maxRiders;
    private int numOfCycles;  // Number of times the ride has been run
    private Queue<Visitor> queue;  // Queue to manage waiting visitors
    private LinkedList<Visitor> rideHistory;  // LinkedList to store ride history

    // Default constructor
    public Ride() {
        this.rideName = "";
        this.operator = null;
        this.maxRiders = 1;
        this.numOfCycles = 0;
        this.queue = new LinkedList<>();  // Initialize the queue using LinkedList
        this.rideHistory = new LinkedList<>();  // Initialize the ride history
    }

    // Constructor with parameters
    public Ride(String rideName, Employee operator, int maxRiders) {
        this.rideName = rideName;
        this.operator = operator;
        this.maxRiders = maxRiders;
        this.numOfCycles = 0;
        this.queue = new LinkedList<>();  // Initialize the queue using LinkedList
        this.rideHistory = new LinkedList<>();  // Initialize the ride history
    }

    // Implementing methods from RideInterface

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (!queue.contains(visitor)) {  // 检查游客是否已经在队列中
            queue.add(visitor);  // 如果不在队列中，则添加
            System.out.println(visitor.getName() + " has been added to the queue.");
        } else {
            System.out.println(visitor.getName() + " is already in the queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println(visitor.getName() + " is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Visitors in the queue:");
            for (Visitor visitor : queue) {
                System.out.println(visitor.getName());
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned. Cannot run the ride.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue. Cannot run the ride.");
            return;
        }

        int ridersThisCycle = Math.min(maxRiders, queue.size());
        for (int i = 0; i < ridersThisCycle; i++) {
            Visitor visitor = queue.poll();  // 移除队列中的第一个游客
            if (!rideHistory.contains(visitor)) {  // 检查游客是否已经在历史中
                rideHistory.add(visitor);  // 如果不在历史中，则添加
                System.out.println(visitor.getName() + " is now on the " + rideName);
            } else {
                System.out.println(visitor.getName() + " is already in the ride history.");
            }
        }
        numOfCycles++;  // 增加周期计数
        System.out.println("Ride cycle completed. Total cycles: " + numOfCycles);
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }

    // 将乘坐历史导出到文件
    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Visitors who have taken the ride:\n");
            writer.write("Name, Age, ID\n");
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + ", " + visitor.getAge() + ", " + visitor.getId() + "\n");
            }
            System.out.println("Ride history has been successfully exported to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    // 从文件导入乘坐历史
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();  // 跳过 "Visitors who have taken the ride:"
            reader.readLine();  // 跳过 "Name, Age, ID"

            // 逐行读取文件并创建游客对象
            while ((line = reader.readLine()) != null) {
                String[] visitorData = line.split(", ");
                if (visitorData.length == 3) {
                    String name = visitorData[0];
                    int age = Integer.parseInt(visitorData[1]);
                    String id = visitorData[2];
                    Visitor visitor = new Visitor(name, age, id);
                    rideHistory.add(visitor);
                    System.out.println(visitor.getName() + " has been added to the ride history.");
                }
            }
            System.out.println("Ride history has been successfully imported from " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in file: " + e.getMessage());
        }
    }

    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    public int numberOfVisitors() {
        return rideHistory.size();
    }

    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
        } else {
            System.out.println("Visitors who have taken the ride:");
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getName());
            }
        }
    }

    // Getter for rideHistory
    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history sorted by name and age.");
    }

    public void clearRideHistory() {
        rideHistory.clear();  // Clears all visitors from the ride history
        System.out.println("Ride history has been cleared.");
    }
}







