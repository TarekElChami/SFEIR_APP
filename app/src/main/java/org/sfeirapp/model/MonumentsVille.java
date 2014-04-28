package org.sfeirapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by tarekelchami on 28/04/14.
 */
public class MonumentsVille {

    private List<Monument> listeMonuments;

    public MonumentsVille() {
        listeMonuments = new ArrayList<Monument>();
    }

    public void add(int i, Monument monument) {
        listeMonuments.add(i, monument);
    }

    public boolean containsAll(Collection<?> objects) {
        return listeMonuments.containsAll(objects);
    }

    public boolean isEmpty() {
        return listeMonuments.isEmpty();
    }

    public boolean add(Monument monument) {
        return listeMonuments.add(monument);
    }

    public Iterator<Monument> iterator() {
        return listeMonuments.iterator();
    }

    public <T> T[] toArray(T[] ts) {
        return listeMonuments.toArray(ts);
    }

    public boolean retainAll(Collection<?> objects) {
        return listeMonuments.retainAll(objects);
    }

    public void clear() {
        listeMonuments.clear();
    }

    public List<Monument> subList(int i, int i2) {
        return listeMonuments.subList(i, i2);
    }

    public boolean remove(Object o) {
        return listeMonuments.remove(o);
    }

    public ListIterator<Monument> listIterator(int i) {
        return listeMonuments.listIterator(i);
    }

    public Monument remove(int i) {
        return listeMonuments.remove(i);
    }

    public boolean removeAll(Collection<?> objects) {
        return listeMonuments.removeAll(objects);
    }

    public boolean addAll(int i, Collection<? extends Monument> monuments) {
        return listeMonuments.addAll(i, monuments);
    }

    public int size() {
        return listeMonuments.size();
    }

    public Monument get(int i) {
        return listeMonuments.get(i);
    }

    public Monument set(int i, Monument monument) {
        return listeMonuments.set(i, monument);
    }

    public Object[] toArray() {
        return listeMonuments.toArray();
    }

    public int lastIndexOf(Object o) {
        return listeMonuments.lastIndexOf(o);
    }

    public boolean addAll(Collection<? extends Monument> monuments) {
        return listeMonuments.addAll(monuments);
    }

    public int indexOf(Object o) {
        return listeMonuments.indexOf(o);
    }

    public ListIterator<Monument> listIterator() {
        return listeMonuments.listIterator();
    }

    public boolean contains(Object o) {
        return listeMonuments.contains(o);
    }
}
