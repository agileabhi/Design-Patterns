import Observer.Publisher.Editor;
import Observer.Subscriber.EmailNotificationListener;
import Observer.Subscriber.Employee;
import Observer.Subscriber.LogOpenListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));
        List<Employee> eList = new ArrayList<>(Arrays.asList(new Employee(100D),new Employee(2000d),new Employee(1900d)));
        eList.stream().filter(e->e.getSalary()<1000).
                forEach(e->e.setSalary(e.getSalary()+2000));
        System.out.println(eList);
        for(int i=eList.size()-1;i>=0;i--){
            if(i%2==0){
                eList.remove(i);
            }
        }
        System.out.println(eList);

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Hello world!");
        //iteratorTest(new int[] {1,2,3});
    }

    public static void iteratorTest(Iterator<Integer> itr){
       // int size = itr.
    }
}