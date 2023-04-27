import java.util.Scanner;

public class Main {
    private static Person[] persons;
    private static int count = 0;

    public static void main(String[] args) {

        System.out.println("nece");
        Scanner sc = new Scanner(System.in);
        int say=sc.nextInt();

        persons = new Person[say];
        System.out.println("Menu"+
                "\n\t1-Create"+
                "\n\t2 - Read All"+
                "\n\t3 - Read By Id"+
                "\n\t4 - Update By Id"+
                "\n\t5 - DeleteBy Id"+
                "\n\t0- Exit");
        while (true){
            int menuItem = sc.nextInt();
            switch (menuItem){
                case 1:
                    createPerson(sc);
                    break;
                case 2:
                    readPerson();
                    break;
                case 3:
                    findPersonById(sc);
                    break;
                case 4:
                    updatePerson(sc);
                    break;
                case 5:
                    deletePerson(sc);
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Menu Item [1-5]");
            }
        }
    }

    private static Person findPersonById(Scanner sc) {
        Long id = sc.nextLong();
        Person person = getPersonById(id);
        if (person == null) {
            System.out.println("id yoxdur");

        } else {
            System.out.println(person);
        }
        return person;
    }

    private static void  updatePerson(Scanner sc) {
        Person newPerson = new Person(sc.nextLong(),
                sc.nextLine(),
                sc.nextLine(),
                sc.nextByte());


        Person updatedPerson = updatePersonById(newPerson.getId(), newPerson);
        if (updatedPerson == null) {
            System.out.println("Hec bir melumat yoxdur");
        } else {
            System.out.println(updatedPerson);

        }
    }

    private static void deletePerson(Scanner sc) {
        Long idForDelete= sc.nextLong();
        deleteById(idForDelete);
        boolean deleted=deleteById((idForDelete));
        if(deleted){
            System.out.println("Id-si"+idForDelete+"olan Person silindi");
        }
        else{
            System.out.println("Id-si"+idForDelete+"olan Person tapilmadi");
        }
    }


    public static Person createPerson(Scanner sc) {
        System.out.println("id=");
        Long id=sc.nextLong();
        System.out.println("name=");
        String name=sc.nextLine();
        System.out.println("surname=");
        String surname=sc.nextLine();
        System.out.println("age=");
        Byte age=sc.nextByte();
        Person p1 = new Person(id, name ,surname,age);
        persons[count++] = p1;
        return p1;
    }

    public static void readPerson() {
        System.out.println( "id/t/tname/t/tsurname/t/tage");

        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null) {

                System.out.println(persons[i].getId() + " " +
                        persons[i].getName() + " " +
                        persons[i].getSurname() + " " +
                        persons[i].getAge());
            }


        }
    }

    public static Person getPersonById(Long id) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getId().equals(id)) {
                return persons[i];
            }
        }

        return null;
    }

    public static Person updatePersonById(Long id, Person newPerson) {
        Person person = getPersonById(id);
        if (person != null) {
            person.setName(newPerson.getName());
            person.setSurname(newPerson.getSurname());
            person.setAge(newPerson.getAge());
            return person;
        } else {
            return null;
        }
    }

    public static boolean deleteById(Long id) {
        for (int i = 0; i < count; i++) {
            if (true) {
                for (int j = 0; j < count; j++) {
                    if (persons[i].getId().equals(id)) {
                        persons[i] = persons[j + 1];
                    }
                    persons[--count] = null;

                }
                return true;
            }
        }
        return false;
    }
}