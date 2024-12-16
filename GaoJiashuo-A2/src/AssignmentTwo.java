//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// AssignmentTwo.java
public class AssignmentTwo {
    public static void main(String[] args) {
        // Create an operator (Employee)
        Employee operator = new Employee("John", 30, "E001", "Ride Operator", 5000);

        // Create a new ride
        Ride rollerCoaster = new Ride("Roller Coaster", operator, 3);

        // Create some visitors
        Visitor v1 = new Visitor("Alice", 25, "V001", true, 3);
        Visitor v2 = new Visitor("Bob", 30, "V002", false, 1);
        Visitor v3 = new Visitor("Charlie", 22, "V003", false, 2);
        Visitor v4 = new Visitor("David", 35, "V004", false, 0);
        Visitor v5 = new Visitor("Vincent", 29, "V005", true, 3);
        Visitor v6 = new Visitor("Frank", 26, "V006", false, 1);
        Visitor v7 = new Visitor("Grace", 24, "V007", true, 2);
        Visitor v8 = new Visitor("Hannah", 31, "V008", false, 3);
        Visitor v9 = new Visitor("Isaac", 28, "V009", true, 0);
        Visitor v10 = new Visitor("Jack", 27, "V010", false, 2);

        // Call partThree to test the queue methods
        partThree(rollerCoaster, v1, v2, v3, v4, v5);
        rollerCoaster.clearRideHistory();  // Clear the ride history
        // Call partFourA to test the ride history methods
        partFourA(rollerCoaster, v1, v2, v3, v4, v5);
        rollerCoaster.clearRideHistory();  // Clear the ride history
        // Call partFourB to test sorting functionality
        partFourB(rollerCoaster, v1, v2, v3, v4, v5);
        rollerCoaster.clearRideHistory();  // Clear the ride history
        // Call partFive to test the ride cycle functionality
        partFive(rollerCoaster, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10);
        rollerCoaster.clearRideHistory();
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);
        partSix(rollerCoaster);
        rollerCoaster.clearRideHistory();
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);
        rollerCoaster.addVisitorToHistory(v4);
        rollerCoaster.addVisitorToHistory(v5);
        rollerCoaster.exportRideHistory("C:/Users/高嘉硕/IdeaProjects/GaoJiashuo-A2/ride_history.txt");
        // 调用 Part 7：从文件导入乘坐历史
        partSeven(rollerCoaster);
    }



    public static void partThree(Ride ride, Visitor v1, Visitor v2, Visitor v3, Visitor v4, Visitor v5) {
        System.out.println("\n--- Part 3: Queue Management ---");
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        // Print the queue
        ride.printQueue();

        // Remove a visitor from the queue
        ride.removeVisitorFromQueue(v3);

        // Print the updated queue
        ride.printQueue();
    }

    public static void partFourA(Ride ride, Visitor v1, Visitor v2, Visitor v3, Visitor v4, Visitor v5) {
        System.out.println("\n--- Part 4A: ");
        // Add visitors to the ride history
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        // Check if a visitor is in the history
        System.out.println("Is Alice in the ride history? " + ride.checkVisitorFromHistory(v1));

        // Print the number of visitors in the history
        System.out.println("Number of visitors in ride history: " + ride.numberOfVisitors());

        // Print all visitors in the ride history
        ride.printRideHistory();
    }

    public static void partFourB(Ride ride, Visitor v1, Visitor v2, Visitor v3, Visitor v4, Visitor v5) {
        System.out.println("\n--- Part 4B: ");
        // Add visitors to the ride history
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        // Print the visitors before sorting
        System.out.println("Before sorting:");
        ride.printRideHistory();

        // Sort the ride history
        ride.sortRideHistory();

        // Print the visitors after sorting
        System.out.println("After sorting:");
        ride.printRideHistory();
    }

    public static void partFive(Ride ride, Visitor... visitors) {
        System.out.println("\n--- Part 5: ");
        // Add visitors to the queue
        for (Visitor visitor : visitors) {
            ride.addVisitorToQueue(visitor);
        }

        // Print the queue before running the cycle
        System.out.println("Queue before cycle:");
        ride.printQueue();

        // Run the ride for one cycle
        ride.runOneCycle();

        // Print the queue after running the cycle
        System.out.println("Queue after cycle:");
        ride.printQueue();

        // Print all visitors who have taken the ride
        System.out.println("Visitors who have taken the ride:");
        ride.printRideHistory();
    }

    public static void partSix(Ride ride) {
        // 将乘坐历史导出到文件
        ride.exportRideHistory("ride_history.txt"); // 导出到 "ride_history.txt"
    }
    public static void partSeven(Ride ride) {
        // 从文件导入乘坐历史
        ride.importRideHistory("C:/Users/高嘉硕/IdeaProjects/GaoJiashuo-A2/ride_history.txt");

        // 打印乘坐历史中游客的数量以确认导入是否正确
        System.out.println("Number of visitors in ride history: " + ride.getRideHistory().size());

        // 打印所有导入的游客信息以确认导入正确
        System.out.println("Visitors in the ride history:");
        for (Visitor visitor : ride.getRideHistory()) {
            System.out.println("Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", ID: " + visitor.getId());
        }
    }

}

