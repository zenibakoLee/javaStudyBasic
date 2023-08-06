import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class ListExam02 {
    public static void main(String[] args) {
        Set<MyData> mySet = new HashSet<>();
        mySet.add(new MyData("kim",500));
        mySet.add(new MyData("kim",500));

        Iterator<MyData> iterator = mySet.iterator();
        while(iterator.hasNext()){
            MyData myData = iterator.next();
            System.out.println(myData);
        }
    }

}

class MyData{
    private String name;
    private int value;

    public MyData(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyData{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals()");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return value == myData.value && Objects.equals(name, myData.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode()");
        return Objects.hash(name, value);
    }
}
