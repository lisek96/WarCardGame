package service.utilites;

import java.util.Comparator;

@FunctionalInterface
public interface ThrowingComparator<T> extends Comparator<T> {

    @Override
    default int compare(T o1, T o2) {
        try {
            return compareThrows(o1, o2);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    int compareThrows(T o1, T o2) throws Exception;

}