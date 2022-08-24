package homework2;

public interface Repository<T, ID> {
    void save(T t, String name);

    void load(T t, String name);
    void deleteById(ID id);
    void findById(ID id);

}
