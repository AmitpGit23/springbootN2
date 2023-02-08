package org.example.service;

import org.example.model.Employee1;
import org.example.model.Manager;

import java.util.List;

public interface EmployeeServiceImpl {
    void insertSingle(Employee1 e1);
    void insertMultiple(List<Employee1> EmployeeList);

    Employee1 selectSingle(int eid, int mid);
    List<Employee1> selectMultiple(List<Integer> eid,List<Integer> mid);
    List<Employee1> selectAll();

    Employee1 updateSingle(Employee1 e1);
    List<Employee1> updateMultiple(List<Employee1> employeeList );

    Boolean deleteSingle(int eid,int mid);
    Boolean deleteMultiple(List<Integer> eids,List<Integer> mids);
    Boolean deleteAll();

}
