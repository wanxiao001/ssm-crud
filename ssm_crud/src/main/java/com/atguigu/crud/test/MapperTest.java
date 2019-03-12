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
 * 1������springTestģ��
 * 2��ָ��spring�����ļ���λ��
 * 3��ֱ��autowiredҪʹ�õ��������
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
	//���Բ���
	@Test
	public void testCRUD(){
		/*//1������SpringIOC����
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2���������л�ȡmapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		System.out.println(departmentMapper);
		
		//1�����벿��
/*		departmentMapper.insertSelective(new Department(null,"������"));
		departmentMapper.insertSelective(new Department(null,"���Բ�"));*/
		//2������Ա��
		//employeeMapper.insertSelective(new Employee(null,"����","M","zhang@qq.com",1));
		//3����������Ա��
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i < 100;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
		}
		System.out.println("�������!");
	}
}
