package main;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        Set<Integer> nums = new HashSet<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(17);
        nums.add(18);
        nums.add(34);
        nums.add(7);
        nums.add(5);
        nums.add(6);
        nums.add(8);
        nums.add(9);
        nums.add(10);
//        nums.add(11);

        System.out.println(nums);

        Set<Student> students = new TreeSet<>();
        students.add(new Student(1,"Ivanov", 60));
        students.add(new Student(2,"Petrenko", 70));
        students.add(new Student(4,"Pidoprygora", 50));
        students.add(new Student(11,"Sidorchuk", 99));
        students.add(new Student(3,"Li", 90));

        students.forEach(System.out::println);
        System.out.println("----------------------");
        Set<Student> set2 = new TreeSet<>(new StudentComparator());
        set2.addAll(students);
        set2.forEach(System.out::println);

        Set<Student> set3 = new TreeSet<>(Comparator.comparing(Student::getFio).thenComparingInt(Student::getId));
        set3.addAll(set2);
        set3.forEach(System.out::println);
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (Double.compare(o1.getRating(), o2.getRating()) == 0) {
            return Integer.compare(o1.getId(), o2.getId());
        }
        return -Double.compare(o1.getRating(), o2.getRating());
    }
}