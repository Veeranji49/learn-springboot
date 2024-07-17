package com.spring.Spring_Hibernate_CRUD;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Spring_Hibernate_CRUD.Business.EmployeeBusiness;
import com.spring.Spring_Hibernate_CRUD.Entity.Employee;

import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("spring_hibernate.xml");
        
        EmployeeBusiness employeebusiness=context.getBean("employeeBusinessImpl",EmployeeBusiness.class);
        
        
        ////// insert //////
        /*
        Employee emp=new Employee();
        emp.setId(4);
        emp.setName("veeresh");
        emp.setSalary(76353);
        emp.setAge(22);
        emp.setLocation("kosigi");
        emp.setContact(63029178);
      
        employeebusiness.saveEmployee(emp);
        System.out.println("Successfully inserted");
        */
        
        
        ////// update ////
        /*
        Employee emp=employeebusiness.getone(2);
        emp.setName("veeranji");
        emp.setLocation("adoni");
        employeebusiness.updateEmployee(emp);
        System.out.println("Updated successfully");
        */
        
        ///// delete /////
        /*
        Employee emp=employeebusiness.getone(4);
        employeebusiness.deleteEmployee(emp);
        System.out.println("Successfully deleted");
        */
        
        ///// getting all values /////
        List<Employee> list=employeebusiness.getall();
        for(Employee e:list)
        {
        	System.out.println("Id:"+e.getId());
        	System.out.println("Name:"+e.getName());
        	System.out.println("Age:"+e.getAge());
        }
        
        ///// getting one value /////
        Employee emp=employeebusiness.getone(1);
        System.out.println(emp);
    }
}
