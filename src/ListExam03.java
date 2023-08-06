import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListExam03 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("kim");
        collection.add("lee");

        Iterator<String> iter = collection.iterator();
        while(iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }
    }
}
