package org.knowit.university;

import java.lang.reflect.Field;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement(name="students")
public class Students {
	
    List<Student> students;

    @XmlElement(name="student")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        Field[] fields = this.getClass().getDeclaredFields();
        String res = "";
        try {
            for (Field field : fields) {
                res += field.getName() + " :\n" + field.get(this);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        return res;
    }
}
