package com.hbsi.dao;

import com.hbsi.pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee finUsersById(Integer id);
    public List<Employee> findAllUsers();
    public List<Employee> findUsersByName(String name);
    //增。删。改。
    public  int addEmployee(Employee employee);
    public int deleteUsers(Integer id);
    public  int updateUsers(Employee employee);
}
