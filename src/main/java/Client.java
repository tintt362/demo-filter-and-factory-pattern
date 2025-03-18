import criteria.Criteria;
import criteria.impl.NameCriteria;
import enums.PersonEnum;
import factory.FactoryClass;
import model.Staff;
import model.Banker;
import model.Person;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
  //      Person person = FactoryClass.getPerson(PersonEnum.EMPLOYEE);
      //  System.out.println(person.getName());

        List<Person> persons = new ArrayList<Person>();

        Staff staff1 = (Staff) FactoryClass.getPerson(PersonEnum.EMPLOYEE);
        staff1.setName("Anh");

        Staff staff2 = (Staff) FactoryClass.getPerson(PersonEnum.EMPLOYEE);
        staff2.setName("Khoa");

        Banker banker1 = (Banker) FactoryClass.getPerson(PersonEnum.BANKER);
        banker1.setName("Dao");

        Banker banker2 = (Banker) FactoryClass.getPerson(PersonEnum.BANKER);
        banker2.setName("Khang");

        Staff staff3 = (Staff) FactoryClass.getPerson(PersonEnum.EMPLOYEE);
        staff3.setName("Khoa");

        Banker banker3 = (Banker) FactoryClass.getPerson(PersonEnum.BANKER);
        banker3.setName("ANH");

        Staff staff4 = (Staff) FactoryClass.getPerson(PersonEnum.EMPLOYEE);
        staff4.setName("Anh");

        persons.add(staff1);
        persons.add(staff2);
        persons.add(banker1);
        persons.add(banker2);
        persons.add(staff3);
        persons.add(banker3);
        persons.add(staff4);


        Criteria nameCriteria = new NameCriteria();

        List<Person> filteredPersons = nameCriteria.meetCriteria(persons);

        printPersons(filteredPersons );

        Session session = HibernateUtil.getSessionFactory().openSession();
            System.out.println("Connect db: " + session);

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Staff> criteria = builder.createQuery(Staff.class);
            Root<Staff> staffRoot = criteria.from(Staff.class);
            Predicate condition = builder.like(staffRoot.get("name"), "%A%");
            criteria.where(condition);
            List<Staff> result = session.createQuery(criteria).getResultList();
            result.forEach(r -> System.out.println("Table Staff:" + r.getName()));

        Session session2 = HibernateUtil.getSessionFactory().openSession();

            CriteriaQuery<Banker> criteria2 = builder.createQuery(Banker.class);
            Root<Banker> staffRoot2 = criteria2.from(Banker.class);
            Predicate condition2 = builder.like(staffRoot2.get("name"), "%A%");



        criteria.where(condition2);
            List<Banker> result2 = session2.createQuery(criteria2).getResultList();
            result2.forEach(r -> System.out.println("Table Banker:" + r.getName()));
            session.beginTransaction();
            // insert data
//            for (Person person : filteredPersons) {
//                session.save(person);
//            }


            session.getTransaction().commit();

    }
    public static void printPersons(List<Person> persons){

        for (Person person : persons) {
            if (person instanceof Staff)
                 System.out.println("Staff : [ Name : " + person.getName() + " ] ");
            else if (person instanceof Banker) {
                System.out.println("Banker : [ Name : " + person.getName() + " ] ");
            }
        }
    }

}
