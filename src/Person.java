public class Person {private String name;
    private String surname;
    private Byte age;
    private Long id;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Byte getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person() {

    }

    public Person(Long id, String name, String surname, Byte age) {
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.age=age;
    }
    public String toString(){
        return "person{"+ "\t\tid"+id+
                "\t\tname"+name+
                "\t\tsurname"+surname+
                "\t\t age"+age+"}";
    }
}
