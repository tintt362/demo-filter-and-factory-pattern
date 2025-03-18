package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "staff")
public class Staff implements Serializable , Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Staff() {
    }

    public Staff(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
