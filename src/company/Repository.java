package company;

import java.util.Collection;
import java.util.function.Predicate;

public interface Repository<T> {
    void add(T... entities);
    Collection<T> findAll();
    Collection<T> findByPredicate(Predicate<T> predicate);
}
