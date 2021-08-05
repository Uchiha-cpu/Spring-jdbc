package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages= {"com.spring.jdbc.dao"})
public class JdbcConfig {

	@Bean("ds")
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://Localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("123456789");
		return ds;
	}
	
	@Bean(name= {"jdbcTemplate"})
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate jdbcTemplate2 = new JdbcTemplate();
		jdbcTemplate2.setDataSource(getDataSource());
		return jdbcTemplate2;
	}
	
	/*
	 * @Bean("studentDao") public StudentDao getStudentDao() { StudentDaoImpl
	 * studentDao=new StudentDaoImpl(); studentDao.setJdbcTemplate(getTemplate());
	 * return studentDao; }
	 */

}
