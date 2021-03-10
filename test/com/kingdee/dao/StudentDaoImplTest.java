package com.kingdee.dao;

import org.junit.Test;

import com.kingdee.beans.Student;

public class StudentDaoImplTest {
	
	@Test
	public void insertStu() {
		
		Student student=new Student(99,"三",18,99.0);
		
		StudentDaoImpl studentDao=new StudentDaoImpl();
		
		studentDao.insertStu(student);
		
	}

}
