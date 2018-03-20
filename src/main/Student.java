package main;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private int id;
    private String fio;
    private double rating;

    public Student(int id, String fio, double rating) {
        this.id = id;
        this.fio = fio;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Double.compare(student.rating, rating) == 0 &&
                Objects.equals(fio, student.fio);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, fio, rating);
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(id, other.id);
    }

    @Override
    public String toString() {
        return id + " " + fio + " " + rating;
    }
}
