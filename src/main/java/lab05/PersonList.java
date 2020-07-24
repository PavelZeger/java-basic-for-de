package lab05;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @author Pavel Zeger
 */
public class PersonList implements List<Person> {

    private Person[] persons;

    public PersonList(Person[] persons) {
        this.persons = persons;
    }

    @Override
    public int size() {
        return persons.length;
    }

    @Override
    public boolean isEmpty() {
        return persons.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Person person : persons) {
            if (person.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {

            private int pos = 0 ;

            public boolean hasNext() {
                return persons.length > pos;
            }

            public Person next() {
                return persons[pos++];
            }

            public void remove() {
                throw new UnsupportedOperationException("Cannot remove an element of an array.");
            }
        };
    }

    @Override
    public Object[] toArray() {
        return persons;
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return (T[]) persons;
    }

    @Override
    public boolean add(Person person) {
        Person[] newPersons = new Person[persons.length + 1];
        System.arraycopy(persons, 0, newPersons, 0, persons.length);
        newPersons[persons.length + 1] = person;
        persons = newPersons;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Person> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Person> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<Person> operator) {

    }

    @Override
    public void sort(Comparator<? super Person> c) {

    }

    @Override
    public void clear() {
        persons = new Person[0];
    }

    @Override
    public Person get(int i) {
        return persons[i];
    }

    @Override
    public Person set(int i, Person person) {
        return null;
    }

    @Override
    public void add(int i, Person person) {
        persons[i] = person;
    }

    @Override
    public Person remove(int i) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Person> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Person> listIterator(int i) {
        return null;
    }

    @Override
    public List<Person> subList(int i, int i1) {
        return null;
    }

    @Override
    public Spliterator<Person> spliterator() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonList people = (PersonList) o;
        return Arrays.equals(persons, people.persons);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(persons);
    }
}
