package org.knowit.university;

import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.knowit.university.utils.SortByLastName;
import org.knowit.university.utils.SortByWeightedAverageGrade;
import org.knowit.university.utils.StudentChainedComparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@SuppressWarnings("restriction")
@Controller
@RequestMapping("/studentsList")
public class StudentsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView studentView() throws Exception {
		
		ClassLoader classLoader = getClass().getClassLoader();
		List<Student> students = unmarshalStudentXml(new File(classLoader.getResource("students.xml").getFile())).getStudents();
		
		sortStudents(students);
		
		return createView(students);
	}
	
	private Students unmarshalStudentXml(File file) {
		Students studentsObj = new Students();

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			studentsObj = (Students) jaxbUnmarshaller.unmarshal(file);			 

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return studentsObj;
	}
	
	private ModelAndView createView(List<Student> students) {
		
		ModelAndView model = new ModelAndView("studentsList");
		
        model.addObject("headers", students.get(0).headers);
		model.addObject("students", students);

		return model;
	}
	
	@SuppressWarnings({ "unchecked" })
	private void sortStudents(List<Student> students) {
		
		Collections.sort(students, new StudentChainedComparator(
        		new SortByWeightedAverageGrade(),
        		new SortByLastName()
                )
        );
	}
}
