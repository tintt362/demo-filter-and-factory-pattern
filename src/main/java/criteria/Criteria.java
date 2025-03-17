package criteria;

import model.Person;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);

}
