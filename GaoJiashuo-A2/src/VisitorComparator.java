import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 首先根据姓名进行比较
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }

        // 如果姓名相同，再根据年龄进行比较
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}
