public class Visitor extends Person {
    private boolean isVIP;
    private int rideCount;

    // Default constructor
    public Visitor(String alice, int i, String v001) {
        super(); // 调用父类 Person 的默认构造函数
        this.isVIP = false;
        this.rideCount = 0;
    }

    // Constructor with parameters
    public Visitor(String name, int age, String id, boolean isVIP, int rideCount) {
        super(name, age, id);  // 调用父类 Person 的构造函数，初始化 name, age 和 id
        this.isVIP = isVIP;
        this.rideCount = rideCount;
    }

    // Getters and Setters for Visitor class
    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }

    public int getRideCount() {
        return rideCount;
    }

    public void setRideCount(int rideCount) {
        this.rideCount = rideCount;
    }

    public void getGender() {
    }

    // Getters inherited from Person (for age and id)
    // Age and ID are already managed by the Person class, so no need to redefine them in the Visitor class.
}
