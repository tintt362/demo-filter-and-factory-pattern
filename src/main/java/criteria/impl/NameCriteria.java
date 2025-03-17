package criteria.impl;

import criteria.Criteria;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class NameCriteria implements Criteria {
    private List<Person> persons = new ArrayList<Person>();
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        for (Person person : persons) {
            if (person.getName().equalsIgnoreCase("Anh") || person.getName().equalsIgnoreCase("Khoa")) {
                this.persons.add(person);
            }
        }
        return this.persons;
    }
}
