package ninja.challengecatstudio.marktheweekapp.model;

import java.util.ArrayList;
import java.util.List;

import ninja.challengecatstudio.marktheweekapp.model.listeners.Notifer;
import ninja.challengecatstudio.marktheweekapp.model.listeners.ReadOnlyNotifier;

/**
 * The interface for a subject
 */
public abstract class Subject<T extends Mark> {
    /**
     * the list of the marks
     */
    private List<T> marks = new ArrayList<>();

    /**
     * the name of the subject
     */
    private String name;

    /**
     * the notifier for the name
     */
    private Notifer<String> nameNotifier = new Notifer<>();

    /**
     * Returns the average mark.
     * @return the average
     */
    public abstract T getAverage();

    /**
     * Returns all marks in this subject
     * @return the marks
     */
    public T[] getMarks() {
        return (T[]) marks.toArray();
    }

    /**
     * Adds a mark to this subject
     * @param m the mark
     */
    public void addMark(T m) {
        marks.add(m);
    }

    /**
     * Remeoves the given mark from this subject
     * @param m the mark
     * @return if the mark was removed
     */
    public boolean removeMark(T m) {
        return marks.remove(m);
    }

    /**
     * If the given mark already exists in the subject
     * @param m the mark
     * @return if the mark exists or not
     */
    public boolean containsMark(T m) {
        return marks.contains(m);
    }

    /**
     * How many marks are totaly in this subject
     * @return the size of this subject
     */
    public int size() {
        return marks.size();
    }

    /**
     * The name of the subject
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the subject
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
