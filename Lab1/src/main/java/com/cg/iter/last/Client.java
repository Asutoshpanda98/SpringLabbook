package com.cg.iter.last;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("last.xml");
	EmployeeDao sbu=(EmployeeDao) context.getBean("emp");
	System.out.println("Enter Employee Id : ");
	Scanner s=new Scanner(System.in);
	int empId=s.nextInt();
	EmployeeService empService=new EmployeeServiceImpl();
	Employee emp=empService.getDetails(empId);
	if(emp==null){
		System.out.println("No Employee Exist");
	}
	else{
		System.out.println("Employee Id: "+emp.getEmployeeId());
		System.out.println("Employee Name: "+emp.getEmployeeName());
		System.out.println("Employee Salary: "+emp.getSalary());
	}
}
}
