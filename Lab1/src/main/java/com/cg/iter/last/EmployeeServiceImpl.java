package com.cg.iter.last;

public class EmployeeServiceImpl implements EmployeeService{

	public Employee getDetails(int empId) {
		EmployeeDao emp=new EmployeeDao();
		return emp.getDetails(empId);
	}
 
}
