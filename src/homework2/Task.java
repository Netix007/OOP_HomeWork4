package homework2;

import java.util.Calendar;

public class Task {

    static int count = 1;

    private int id;
    private Calendar createDate;
    private String author;
    private Calendar deadline;
    private String description;
    private Priority value;

    public Task(String author, int timeForTask, String description, Priority value){
        Calendar timeNow = Calendar.getInstance();
        this.id = count;
        count++;
        this.createDate = Calendar.getInstance();
        timeNow.add(Calendar.MINUTE, timeForTask);
        this.deadline = timeNow;
        this.author = author;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public String getAuthor() {
        return author;
    }

    public Calendar getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public Priority getValue() {
        return value;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "%d %tD %s %s %tD %s".formatted(id, createDate, author, description, deadline, value);
    }
}
