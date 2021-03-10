package com.kingdee.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//import com.kingdee.Utils;
import com.kingdee.beans.Student;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public void insertStu(Student student) {
		try {
			//String resourcePath=Utils.class.getClassLoader().getResource("mybatis.xml").getPath();
			InputStream inputstream=Resources.getResourceAsStream("mybatis.xml");
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
			SqlSession sqlSession=sqlSessionFactory.openSession();
			//执行插入语句
			sqlSession.insert("insertStu",student);
			//提交
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}
	
	

}
