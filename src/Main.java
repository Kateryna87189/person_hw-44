import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Дан список Person (lName, fName, age, city) необходимо реализовать метод
который вернет средний возраст всех людей проживающих в Берлине
который вернет map, где ключ - возраст, значение количество людей, соответствующего возраста
*/
public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Koch", "Valter", 29, "Berlin"),
                new Person("Schwartz", "Silvia", 41, "Gerling"),
                new Person("Baum", "Karolina", 24, "Berlin"),
                new Person("Miller", "Olaf", 18, "Dusseldorf"),
                new Person("Farhad", "Oliver", 37, "Berlin"),
                new Person("Fischer", "Rudger", 29, "Hannover")
        );
        printPersonList(personList);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Середній вік людей які живуть в Берліні: "+ middleAgeInBerlin(personList));
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Кількість людей за віком <= 30: " + getCountByAgeForPerson(personList));

    }
    public static void printPersonList(List<Person> personList) {
        personList.forEach(person -> System.out.println(person));
    }

    //метод который вернет средний возраст всех людей проживающих в Берлине
    public static double middleAgeInBerlin (List<Person> personList){
        return personList.stream()
                .filter(p->"Berlin".equals(p.getCity()))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
    }
    //метод который вернет map, где ключ - возраст, значение количество людей, соответствующего возраста
    public static Map<Integer, List<String>> getCountByAgeForPerson (List<Person> personList){
        return personList.stream()
                .filter(p->p.getAge()<=30)
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(p->p.getlName()+" "+p.getfName(), Collectors.toList())
                ));
    }

}