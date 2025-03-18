import criteria.Criteria;
import criteria.impl.NameCriteria;
import enums.PersonEnum;
import factory.FactoryClass;
import model.Staff;
import model.Banker;
import model.Person;

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

        // Thêm tất cả các đối tượng vào danh sách
        persons.add(staff1);
        persons.add(staff2);
        persons.add(banker1);
        persons.add(banker2);
        persons.add(staff3);
        persons.add(banker3);
        persons.add(staff4);


        // Tạo đối tượng Criteria (lọc theo tên "Anh" hoặc "Khoa")
        Criteria nameCriteria = new NameCriteria();

        // Áp dụng tiêu chí lọc
        List<Person> filteredPersons = nameCriteria.meetCriteria(persons);

        printPersons(filteredPersons );
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
