package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persion")
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract String getName();

    public void setName(String name) {
        this.name = name;
    }
}
