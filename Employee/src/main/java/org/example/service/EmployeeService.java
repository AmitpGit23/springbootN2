package org.example.service;

import org.example.model.Employee1;
import org.example.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repo.EmployeeRepoImpl;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceImpl {
    @Autowired
    private EmployeeRepoImpl repo;

    @Override
    public void insertSingle(Employee1 e1){
        repo.insertSingle(e1);
    }
    @Override
   public void insertMultiple(List<Employee1> EmployeeList){
        for (int i=0;i<EmployeeList.size();i++){
            repo.insertSingle(EmployeeList.get(i));
        }
   }

   @Override
   public  Employee1 selectSingle(int eid, int mid){
       return repo.selectSingle(eid,mid);
   }
   @Override
   public List<Employee1> selectMultiple(List<Integer> eid,List<Integer> mid){
        List<Employee1> employeeList= new ArrayList<>();
        for (int i=0;i<eid.size();i++){
            if(mid.size()<i){
                employeeList.add(repo.selectSingle(eid.get(i),mid.get(mid.size())));
            }
            else {
                employeeList.add(repo.selectSingle(eid.get(i),mid.get(i)));
            }
        }
        return employeeList;
   }
   @Override
   public List<Employee1> selectAll(){
        return repo.selectAll();
   }

   @Override
   public Employee1 updateSingle(Employee1 e1){
        return repo.updateSingle(e1);
   }
   @Override
   public  List<Employee1> updateMultiple(List<Employee1> employeeList){
       for(int i=0;i<employeeList.size();i++){
           repo.updateSingle(employeeList.get(i));
       }return employeeList;
   }

   @Override
    public Boolean deleteSingle(int eid,int mid){
        return repo.deleteSingle(eid,mid);
    }
    @Override
    public Boolean deleteMultiple(List<Integer> eids,List<Integer> mids){
        List<Boolean> deleteList=new ArrayList<>();
        Boolean result = false;
        for (int i=0;i<eids.size();i++){
            deleteList.add(repo.deleteSingle(eids.get(i), mids.get(i)));
        }
        for(int i=0;i<deleteList.size();i++){
            if (deleteList.get(i).equals(true)){
                result=true;
            }
        }
        return result;
    }
    @Override
    public Boolean deleteAll(){
         return repo.deleteAll();
    }
}
