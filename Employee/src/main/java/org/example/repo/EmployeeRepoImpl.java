package org.example.repo;

import org.example.model.Employee1;
import org.example.model.Manager;

import java.util.List;

public interface EmployeeRepoImpl {
    void insertSingle(Employee1 e1);
//    void insertMultiple(List<Employee1> EmployeeList);
    Employee1 selectSingle(int eid,int mid);
    List<Employee1> selectAll();

    Employee1 updateSingle(Employee1 e1);

    Boolean deleteSingle(int eid,int mid);
    Boolean deleteAll();
}
