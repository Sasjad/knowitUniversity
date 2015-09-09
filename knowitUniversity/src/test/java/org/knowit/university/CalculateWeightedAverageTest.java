package org.knowit.university;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CalculateWeightedAverageTest {
	
	public List<Course> getCourse() {
		Course c1 = new Course();
		c1.setName("Test1");
		c1.setGrade(5);
		c1.setEap(2);
		
		Course c2 = new Course();
		c2.setName("Test2");
		c2.setGrade(4);
		c2.setEap(3);
		
		List<Course> lCourses = new ArrayList<Course>();
		lCourses.add(c1);
		lCourses.add(c2);
		
		return lCourses;
	}

	@Test
	public void testWeigtedAverage() {
		
		Student student = new Student();
		
		float result = student.calculateWavGrade(getCourse());
		assertEquals(4.4, result, 0.0001);
	}

}
