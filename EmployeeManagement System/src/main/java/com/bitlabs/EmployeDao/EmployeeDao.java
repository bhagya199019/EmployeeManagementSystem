package com.bitlabs.EmployeDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bitlabs.EmployeModel.Employee;


@Repository
public class EmployeeDao {
 
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addEmploye(Employee employe) {
		this.hibernateTemplate.saveOrUpdate(employe);
	}
	
	public List<Employee> getAll(){
		
		List<Employee> list =new ArrayList();
		list=this.hibernateTemplate.loadAll(Employee.class);
		return list;
	}
	public Employee getById(int id) {
		Employee emp=this.hibernateTemplate.get(Employee.class,id);
		return emp;
	}
	
	@Transactional
	public void delete(int id) {
		Employee emp=this.hibernateTemplate.get(Employee.class,id);
		this.hibernateTemplate.delete(emp);
	}

}

