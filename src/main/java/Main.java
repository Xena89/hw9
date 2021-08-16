import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", Arrays.asList(new Course("Java1"), new Course("Python"),
                new Course("Testing"))));
        students.add(new Student("Петров", Arrays.asList(new Course("Java2"), new Course("Robotic"))));
        students.add(new Student("Сидоров", Arrays.asList(new Course("Java1"), new Course("Biology"),
                new Course("Testing3"), new Course("Math"))));

        //1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet()));

        //2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
        //(любознательность определяется количеством курсов).
        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));

        //3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
        Course course = new Course("Java1");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}