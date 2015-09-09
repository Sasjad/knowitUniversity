package org.knowit.university;

import java.lang.reflect.Field;

public class Course {
	
	Integer id;
	Integer grade;
	Integer eap;
	String name;
	
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getEap() {
		return eap;
	}

	public void setEap(Integer eap) {
		this.eap = eap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		Field[] fields = this.getClass().getDeclaredFields();
		String res = "{";
		try {
			for (Field field : fields) {
				res += field.getName() + " : " + field.get(this);
			}
			res += "}";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
}
