package factory;

import enums.PersonEnum;
import model.Staff;
import model.Banker;
import model.Person;

public class FactoryClass {

    public static final Person getPerson(PersonEnum personEnum) {
        switch (personEnum) {
            case BANKER:
                return new Banker();
            case EMPLOYEE:
                return new Staff();

            default:
                throw new IllegalArgumentException("This person type is unsupported");
        }
    }
}
