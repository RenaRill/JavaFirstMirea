import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// Класс MySynchronizedSet реализует интерфейс Set и защищает доступ к данным с помощью синхронизации
public class MySynchronizedSet<E> implements Set<E> {
    private Set<E> set;

    public MySynchronizedSet(Set<E> set) {
        this.set = set;
    }

    //В методах, которые не изменяют состояние множества, синхронизацию не используем
    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return set.toArray(a);
    }

    @Override
    synchronized public boolean add(E e) {
        return set.add(e);
    }

    @Override
    synchronized public boolean remove(Object o) {
        return set.remove(o);
    }

    @Override
    synchronized public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    synchronized public boolean addAll(Collection<? extends E> c) {
        return set.addAll(c);
    }

    @Override
    synchronized public boolean retainAll(Collection<?> c) {
        return set.retainAll(c);
    }

    @Override
    synchronized public boolean removeAll(Collection<?> c) {
        return set.removeAll(c);
    }

    @Override
    synchronized public void clear() {
        set.clear();
    }
}
