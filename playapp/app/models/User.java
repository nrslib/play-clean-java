package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {
    @Id
    private String id;

    private String name;

    private int role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() { return role; }

    public void setRole(int role) { this.role = role; }

    public static Find<String, User> find = new Find<String, User>() {};
}
