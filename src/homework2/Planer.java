package homework2;

import java.util.ArrayList;
import java.util.List;

public class Planer {
    private Planer() {

    }
    private static final List<Task> tasks = new ArrayList<>();

    public static void addTask(Task task) {
        tasks.add(task);
    }

    public static List<Task> getTasks() {
        return tasks;
    }

    public static void printPlan(){
        for (Task el: tasks
             ) {
            System.out.println(el);
        }
    }
}
