import java.util.*;
import java.util.concurrent.Semaphore;

// Класс MySemaphoreList реализует интерфейс List и защищает доступ к данным с помощью семафора
public class MySemaphoreList<E> implements List<E> {
    // Список, который будет защищен семафором
    private List<E> list;
    // Семафор, который будет использоваться для синхронизации доступа к списку
    public static final Semaphore semaphore = new Semaphore(1);

    public MySemaphoreList(List<E> list) {
        this.list = list;
    }

    //В методах, которые не изменяют состояние списка, семафор не используем
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(E e) {
        try {
            // Приобретаем семафор, чтобы получить доступ к списку
            semaphore.acquire();
            boolean res = list.add(e);
            // Освобождаем семафор, чтобы другие потоки могли получить доступ к списку
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            boolean res = list.remove(o);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = list.containsAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire();
            boolean res = list.addAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            semaphore.acquire();
            boolean res = list.addAll(index, c);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = list.removeAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean res = list.retainAll(c);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return false;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
            semaphore.release();
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        try {
            semaphore.acquire();
            E res = list.get(index);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        try {
            semaphore.acquire();
            E res = list.set(index, element);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        try {
            semaphore.acquire();
            list.add(index, element);
            semaphore.release();
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }

    @Override
    public E remove(int index) {
        try {
            semaphore.acquire();
            E res = list.remove(index);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        try {
            semaphore.acquire();
            int res = list.indexOf(o);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            semaphore.acquire();
            int res = list.lastIndexOf(o);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        try {
            semaphore.acquire();
            ListIterator<E> res = list.listIterator();
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        try {
            semaphore.acquire();
            ListIterator<E> res = list.listIterator(index);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        try {
            semaphore.acquire();
            List<E> res = list.subList(fromIndex, toIndex);
            semaphore.release();
            return res;
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return null;
    }
}
