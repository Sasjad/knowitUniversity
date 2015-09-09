package org.knowit.university.utils;

import java.util.Comparator;

import org.knowit.university.Student;

public class SortByWeightedAverageGrade implements Comparator<Student>{

	public int compare(Student emp1, Student emp2) {
		return Float.valueOf(emp2.getWavGrade()).compareTo(Float.valueOf(emp1.getWavGrade()));
	}
}