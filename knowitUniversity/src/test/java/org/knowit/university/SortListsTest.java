package org.knowit.university;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.knowit.university.utils.SortByLastName;
import org.knowit.university.utils.SortByWeightedAverageGrade;
import org.knowit.university.utils.StudentChainedComparator;

public class SortListsTest {

	public List<Student> getStudent() {
		Student student1 = new Student();
		student1.setLastName("B");
		student1.setWavGrade((float) 3.0);
		
		Student student2 = new Student();
		student2.setLastName("A");
		student2.setWavGrade((float) 3.0);
		
		Student student3 = new Student();
		student3.setLastName("C");
		student3.setWavGrade((float) 4.0);
		
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void SortByWeightedAverageTest() {
		
		List<Student> list = getStudent();
		
		Collections.sort(list, new StudentChainedComparator(
        		new SortByWeightedAverageGrade()
                )
        );
		
		assertEquals(4.0, list.get(0).wavGrade, 0.0001);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void SortByLastNameTest() {
		List<Student> list = getStudent();
		Collections.sort(list, new StudentChainedComparator(
        		new SortByLastName()
                )
        );
		assertEquals("A", list.get(0).lastName);
		assertEquals("B", list.get(1).lastName);
		//No actual need to assert the last element in list
		//assertEquals("C", list.get(2).lastName);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void SortByWeightedAverageAndLastNameTest() {
		
		List<Student> list = getStudent();
		
		Collections.sort(list, new StudentChainedComparator(
        		new SortByWeightedAverageGrade(),
        		new SortByLastName()
                )
        );
		
		assertEquals(4.0, list.get(0).wavGrade, 0.0001);
		assertEquals(3.0, list.get(1).wavGrade, 0.0001);
		
		assertEquals("C", list.get(0).lastName);
		assertEquals("A", list.get(1).lastName);
		//Not actual need to assert the last element in list
		//assertEquals("B", list.get(2).lastName);
	}

}
