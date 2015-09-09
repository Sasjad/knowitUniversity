package org.knowit.university;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

@SuppressWarnings("restriction")
public class Student {
	
	String firstName;
	String lastName;
	Float wavGrade;
	List<Course> courses;
	List<String> headers =  Arrays.asList("Perenimi", "Eesnimi", "Kaalutud keskmine", "Aine/hinne/EAP");

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@XmlElementWrapper(name = "courses")
	@XmlElement(name = "course")
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		setWavGrade(calculateWavGrade(courses));
		this.courses = courses;
	}
	
	public float calculateWavGrade(List<Course> courses) {
		if (!courses.isEmpty()) {
			int gr = 0;
			int eaps = 0;
			for (int i = 0; i < courses.size(); i++) {
				int grade = courses.get(i).grade;
				int eap = courses.get(i).eap;
				gr +=  grade * eap;
				eaps += eap;
			}
			return((float) gr/eaps);
		}
		return 0;
	}

	public Float getWavGrade() {
		return wavGrade;
	}

	public void setWavGrade(Float wavGrade) {
		this.wavGrade = wavGrade;
	}

	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		String res = "\n";
		try {
			for (Field field : fields) {
				res += field.getName() + " : " + field.get(this) + "\n";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
}
