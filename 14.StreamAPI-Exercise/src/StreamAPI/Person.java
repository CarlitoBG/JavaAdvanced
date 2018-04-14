package StreamAPI;

public class Person {
    private String name;
    private Integer group;

    public Person() {
    }

    Person(String name, Integer group) {

        this.name = name;
        this.group = group;
    }

    String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}