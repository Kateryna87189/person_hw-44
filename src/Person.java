public class Person {
    private String lName;
    private  String fName;
    private  int age;
    private String city;

    public Person(String lName, String fName, int age, String city) {
        this.lName = lName;
        this.fName = fName;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - %s", lName, fName, age, city);
    }

    public String getlName() {
        return lName;
    }

    public String getfName() {
        return fName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
