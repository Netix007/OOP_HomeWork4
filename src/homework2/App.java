package homework2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

public class App {

    public static void main(String[] args) {

        DocumentRepository rep = new DocumentRepository();
        rep.load(new CsvDocuments(), "test1");

        rep.deleteById(2);
        Planer.printPlan();

    }
}
