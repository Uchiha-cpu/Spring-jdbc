package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My program started.............." );
        //ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
        //JdbcTemplate template=context.getBean("jdbcTemplate",JdbcTemplate.class);
        //insert
        //String query="insert into student(id,name,city) values(?,?,?)";
        //fire query
        //int result = template.update(query,456,"Dipesh","Sahibganj");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        Student student=new Student();
        //insert
		
		/*
		 * student.setId(665); student.setName("John"); student.setCity("Kanpur"); int
		 * result=studentDao.insert(student);
		 * System.out.println("Student added..........."+result);
		 */
		 
        //update
		/*
		 * student.setId(456); student.setName("Arnav"); student.setCity("Lucknow"); int
		 * result=studentDao.change(student);
		 * System.out.println("Student changed..........."+result);
		 */   
        //delete
		/*
		 * int result=studentDao.delete(666);
		 * System.out.println("Student deleted..........."+result);
		 */
        //select single data
		/*
		 * Student student = studentDao.getStudent(222); System.out.println(student);
		 */
        // select all
        List<Student> students=studentDao.getAllStudents();
        for(Student s:students)
        {
        	System.out.println(s);
        }
    }
}
