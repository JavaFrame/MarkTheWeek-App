package ninja.challengecatstudio.marktheweekapp.model.listeners;

/**
 * A listener for the given type
 * @param <T> the type of the listener
 */
@FunctionalInterface
public interface Listener<T> {
    /**
     * the value has changed from the old to the new value
     * @param oldV the old value
     * @param newV the new value
     */
    void change(T oldV, T newV);
}
