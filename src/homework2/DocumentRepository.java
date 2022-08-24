package homework2;

public class DocumentRepository implements Repository<Document, Integer>{

    @Override
    public void save(Document document, String name) {
        document.saveData(name);
    }

    @Override
    public void load(Document document, String name) { document.loadData(name); }

    @Override
    public void deleteById(Integer integer) {
        for (int i = 0; i < Planer.getTasks().size(); i++) {
            if (Planer.getTasks().get(i).getId() == integer) {
                Planer.getTasks().remove(i);
            }
        }
    }

    @Override
    public void findById(Integer integer) {
        for (Task el: Planer.getTasks()) {
            if (el.getId() == integer) {
                System.out.println(el);
            }
        }
        return;
    }

}
