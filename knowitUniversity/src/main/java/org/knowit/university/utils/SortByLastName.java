package org.knowit.university.utils;

import java.util.Comparator;

import org.knowit.university.Student;

public class SortByLastName implements Comparator<Student>{

	public int compare(Student emp1, Student emp2) {
        return emp1.getLastName().compareTo(emp2.getLastName());
    }
}