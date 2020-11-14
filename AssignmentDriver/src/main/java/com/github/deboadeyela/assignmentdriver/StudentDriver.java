package com.github.deboadeyela.assignmentdriver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gbadebo
 */
import java.util.ArrayList;
import org.joda.time.LocalDate;
import com.github.deboadeyela.registerstudents.*;

public class StudentDriver {
    public static void main(String[] args) {

		CourseModule irishculture = new CourseModule("Irish Culture", "AM091");
		CourseModule socandpol = new CourseModule("Soc and Pol", "AM250");
		CourseModule history = new CourseModule("History", "AM300");
		
		ArrayList<CourseModule> politicsModules = new ArrayList<CourseModule>();
		politicsModules.add(irishculture);
		politicsModules.add(history);
		
		ArrayList<CourseModule> artsModules = new ArrayList<CourseModule>();
		artsModules.add(socandpol);
		artsModules.add(history);
		
//		Create courses
		LocalDate startDate = new LocalDate(2017, 9, 1);
		LocalDate endDate = new LocalDate(2021, 5, 31);
		Course politics = new Course("politics", politicsModules, startDate, endDate);
		Course arts = new Course("arts", artsModules, startDate, endDate);

//		Create students
		Student student1 = new Student("Mike Biggs", 22, new LocalDate(1998, 05, 11), 13300822);
		Student student2 = new Student("Bsrry Small", 21, new LocalDate(1998, 04, 12), 13300821);
		Student student3 = new Student("Miles Turner", 20, new LocalDate(1999, 12, 11), 13300920);
		Student student4 = new Student("Tony Rodgers", 23, new LocalDate(1997, 8, 13), 13300723);
		

		ArrayList<Student> politicsStudents = new ArrayList<Student>();
		politicsStudents.add(student1);
		politicsStudents.add(student2);
	
		ArrayList<Student> artsStudents = new ArrayList<Student>();
		artsStudents.add(student3);
		artsStudents.add(student4);
		

		registerStudents(politicsStudents, politicsModules, politics);
		registerStudents(artsStudents, artsModules, arts);

		printStudents(politicsStudents);
		printStudents(artsStudents);
	}

	public static void registerStudents(ArrayList<Student> students, ArrayList<CourseModule> modules, Course course) {
		for(CourseModule module : modules) {
			module.addStudents(students);
		}
		for(Student student : students) {
			student.setCourse(course);
		}
	}

	public static void printStudents(ArrayList<Student> students) {
		for(Student student : students) {
			printInfo(student);
			Course course = student.getCourse();
			System.out.println("Course: " + course.getName());
			System.out.println("Modules:" + structureInfo(course.getModules()));
			System.out.println("\n");
		}
	}

	public static void printInfo(Student student) {
		System.out.println("Name: " + student.getName());
                System.out.println("Username: " + student.getUsername());
		System.out.println("Age: " + student.getAge());
		System.out.println("Date of Birth: " + student.getDateOfBirth());
                System.out.println("Id: " + student.getId());
	}

	public static String structureInfo(ArrayList<CourseModule> modules) {
		String listModules = "";
		for(CourseModule module : modules) {
			listModules += " [" + module.getName() + "]";
		}
		return listModules;
	}
}

