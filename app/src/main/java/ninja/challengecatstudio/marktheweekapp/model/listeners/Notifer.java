package ninja.challengecatstudio.marktheweekapp.model.listeners;

public class Notifer<T> extends ReadOnlyNotifier<T>{

    /**
     * notifies the registered listeners
     *
     * @param oldV the old value
     * @param newV the new value
     */
    public void notify(T oldV, T newV) {
        for (Listener<T> l : getListeners()) {
            l.change(oldV, newV);
        }
    }

    public ReadOnlyNotifier<T> getReadOnly() {
        return this;
    }
}
