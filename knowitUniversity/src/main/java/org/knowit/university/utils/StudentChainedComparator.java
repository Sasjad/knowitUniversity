package org.knowit.university.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.knowit.university.Student;

public class StudentChainedComparator implements Comparator<Student> {
	 
    private List<Comparator<Student>> listComparators;
 
    @SafeVarargs
    public StudentChainedComparator(Comparator<Student>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    public int compare(Student emp1, Student emp2) {
        for (Comparator<Student> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}