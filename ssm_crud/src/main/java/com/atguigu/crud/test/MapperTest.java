package com.atguigu.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;

import org.springframework.test.context.ContextConfiguration;
/*
 * 1、导入springTest模块
 * 2、指定spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 * */
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	//测试部门
	@Test
	public void testCRUD(){
		/*//1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		System.out.println(departmentMapper);
		
		//1、插入部门
/*		departmentMapper.insertSelective(new Department(null,"开发部"));
		departmentMapper.insertSelective(new Department(null,"测试部"));*/
		//2、插入员工
		//employeeMapper.insertSelective(new Employee(null,"张三","M","zhang@qq.com",1));
		//3、批量插入员工
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i < 100;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
		}
		System.out.println("批量完成!");
	}
}
