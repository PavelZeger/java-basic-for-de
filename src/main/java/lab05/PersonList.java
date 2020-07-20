package lab05;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @author Pavel Zeger
 */
public class PersonList implements List<Person> {

    private List<Person> persons;

    @Override
    public int size() {
        return persons.size();
    }

    @Override
    public boolean isEmpty() {
        return persons.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return persons.contains((Person) o);
    }

    //todo
    @Override
    public Iterator<Person> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Person[] personsArray = new Person[persons.size()];
        for (int i = 0; i < persons.size(); i++) {
            personsArray[i] = persons.get(i);
        }
        return personsArray;
    }

    //todo
    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    //todo
    @Override
    public boolean add(Person person) {
        return false;
    }

    //todo
    @Override
    public boolean remove(Object o) {
        return false;
    }

    //todo
    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    //todo
    @Override
    public boolean addAll(Collection<? extends Person> collection) {
        return false;
    }

    //todo
    @Override
    public boolean addAll(int i, Collection<? extends Person> collection) {
        return false;
    }

    //todo
    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    //todo
    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    //todo
    @Override
    public void replaceAll(UnaryOperator<Person> operator) {

    }

    //todo
    @Override
    public void sort(Comparator<? super Person> c) {

    }

    //todo
    @Override
    public void clear() {

    }

    //todo
    @Override
    public Person get(int i) {
        return persons.get(i);
    }

    //todo
    @Override
    public Person set(int i, Person person) {
        return null;
    }

    //todo
    @Override
    public void add(int i, Person person) {

    }

    //todo
    @Override
    public Person remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return persons.indexOf((Person) o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return persons.lastIndexOf((Person) o);
    }

    //todo
    @Override
    public ListIterator<Person> listIterator() {
        return null;
    }

    //todo
    @Override
    public ListIterator<Person> listIterator(int i) {
        return null;
    }

    //todo
    @Override
    public List<Person> subList(int i, int i1) {
        return null;
    }

    //todo
    @Override
    public Spliterator<Person> spliterator() {
        return null;
    }
}
