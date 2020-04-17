package testgroup.studentslist.model;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "group_name")
    private String group;

    // нужны стандартные имена геттеров и сеттеров
    public void setId(int id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() { return id; }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGroup() {
        return group;
    }

    public String toString() {
        return this.name + " " + this.age + " " + this.group;
    }

}
