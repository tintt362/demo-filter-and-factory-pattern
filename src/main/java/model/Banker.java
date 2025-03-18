package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "banker")
public class Banker implements Serializable , Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Banker() {

    }

    public Banker(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
