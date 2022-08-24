package homework2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

public class CsvDocuments extends Document{
    //private List<String> tasks;
    //private String name;

    @Override
    public void saveData(String name){
        name = name + ".csv";
        try(FileWriter writer = new FileWriter(name, false))
        {
            for (Task el: Planer.getTasks()) {
                String temp = String.format("%d; %tD; %s; %s; %tD; %s\n"
                        ,el.getId(),
                        el.getCreateDate(),
                        el.getAuthor(),
                        el.getDescription(),
                        el.getDeadline(),
                        el.getValue());
                writer.write(temp);
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void loadData(String name){
        try {
            List<String> allLines = Files.readAllLines(Paths.get(name+".csv"));
            for (String line : allLines) {

                String[] temp = line.split("; ");
                Calendar createDate = transformDate(temp[1]);
                String author = temp[2];
                Calendar deadline = transformDate(temp[4]);
                String description = temp[3];
                Priority value = Priority.valueOf(temp[5]);
                Task newTask = new Task(author, (deadline.get(Calendar.DATE)-createDate.get(Calendar.DATE))*1440, description, value);
                newTask.setCreateDate(createDate);
                Planer.addTask(newTask);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Calendar transformDate(String date) {
        String[] temp = date.split("/");
        Calendar createDate = Calendar.getInstance();
        createDate.set(Integer.parseInt(temp[2]), Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        return createDate;
    }

}
