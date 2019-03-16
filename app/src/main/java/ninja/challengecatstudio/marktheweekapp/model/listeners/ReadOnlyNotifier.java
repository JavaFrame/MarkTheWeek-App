package ninja.challengecatstudio.marktheweekapp.model.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A class which manages listeners
 * @param <T> the type of the listeners type
 */
public class ReadOnlyNotifier<T> {
    /**
     * the listeners
     */
    private List<Listener<T>> listeners = new ArrayList<>();

    /**
     * registers the given listener
     *
     * @param l the listener to add
     */
    public void register(Listener<T> l) {
        listeners.add(l);
    }

    /**
     * registers the given listener. The listeners gets automaticly
     * removed when it was called as many times as the given count
     *
     * @param l     the listener
     * @param count how many times the listener should be called, before it is removed
     */
    public void register(Listener<T> l, int count) {
        AtomicInteger countdown = new AtomicInteger(count);
        listeners.add((oldV, newV) -> {
            l.change(oldV, newV);
            if (countdown.decrementAndGet() < 0) {
                remove(l);
            }
        });
    }

    /**
     * removes the given listeners from notifier
     *
     * @param l the listener to remove
     * @return if the element could be removed
     */
    public boolean remove(Listener<T> l) {
        return listeners.remove(l);
    }

    /**
     * Returns all listener registered in this notifier
     * @return the listeners
     */
    public Listener<T>[] getListeners() {
        return (Listener<T>[]) listeners.toArray();
    }
}
