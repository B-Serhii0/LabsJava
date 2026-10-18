import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/** Завдання 1*/
public class StorageManager<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("item == null");
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    /** Видалення за критерієм*/
    public int removeBy(Predicate<T> criterion) {
        int removed = 0;
        for (int i = items.size() - 1; i >= 0; i--) {
            if (criterion.test(items.get(i))) {
                items.remove(i);
                removed++;
            }
        }
        return removed;
    }

    /** Пошук першого елемента*/
    public T findFirst(Predicate<T> criterion) {
        for (T item : items) {
            if (criterion.test(item)) return item;
        }
        return null;
    }

    /** Фільтрація циклом*/
    public List<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) result.add(item);
        }
        return Collections.unmodifiableList(result);
    }

    public int size() {
        return items.size();
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }
}
