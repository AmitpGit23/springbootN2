package org.example.contoller;

import org.example.model.Employee1;
import org.example.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.example.service.EmployeeServiceImpl;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl service;

    @RequestMapping("/insertSingle")
    @ResponseBody
    void insertSingle(@RequestBody Employee1 e1){
        service.insertSingle(e1);
    }
    @RequestMapping("/insertMultiple")
    @ResponseBody
    void insertMultiple(@RequestBody List<Employee1> EmployeeList){
         service.insertMultiple(EmployeeList);
    }

    @RequestMapping("/selectSingle")
    @ResponseBody
    Employee1 selectSingle(@RequestParam int eid,@RequestParam int mid){
        return service.selectSingle(eid,mid);
    }
    @RequestMapping("/selectMultiple")
    @ResponseBody
    List<Employee1> selectMultiple(@RequestParam List<Integer> eid,@RequestParam List<Integer> mid){
        return service.selectMultiple(eid,mid);
    }
    @RequestMapping("/selectAll")
    @ResponseBody
    List<Employee1> selectAll(){
        return service.selectAll();
    }

    @RequestMapping("/updateSingle")
    @ResponseBody
    Employee1 updateSingle(@RequestParam Employee1 e1){
        return service.updateSingle(e1);
    }
    @RequestMapping("/updateMultiple")
    @ResponseBody
    List<Employee1> updateMultiple(@RequestParam List<Employee1> employeeList ){
        return service.updateMultiple(employeeList);
    }


    @RequestMapping("/deleteSingle")
    @ResponseBody
    Boolean deleteSingle(@RequestParam int eid,@RequestParam int mid){
       return service.deleteSingle(eid, mid);
    }
    @RequestMapping("/deleteMultiple")
    @ResponseBody
    Boolean deleteMultiple(@RequestParam List<Integer> eids,@RequestParam List<Integer> mids){
        return service.deleteMultiple(eids, mids);
    }
    @RequestMapping("/deleteAll")
    @ResponseBody
    Boolean deleteAll(){
        return service.deleteAll();
    }
}
