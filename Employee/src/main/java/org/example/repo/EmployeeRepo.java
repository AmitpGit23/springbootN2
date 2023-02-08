package org.example.repo;

import org.example.model.Employee1;
import org.example.model.Manager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepo implements EmployeeRepoImpl {
    String url="jdbc:mysql://localhost:3306/test";
    String user="root";
    String pass="";

    @Override
    public void insertSingle(Employee1 e1){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            Statement st= con.createStatement();
            st.executeUpdate("insert into employee values('"+e1.getEid()+"','"+e1.getNo()+"','"+e1.getName()+"','"+e1.getEmail()+"')");
            st.executeUpdate("insert into manager values('"+e1.getM1().getMid()+"','"+e1.getM1().getNo()+"','"+e1.getM1().getName()+"','"+e1.getM1().getEmail()+"')");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @Override
    public Employee1 selectSingle(int eid,int mid){
        Employee1 e1= new Employee1();
        Manager m1= new Manager();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee where id='"+eid+"'");
                while(rs.next()) {
                    e1.setEid(rs.getInt(1));
                    e1.setNo(rs.getInt(2));
                    e1.setName(rs.getString(3));
                    e1.setEmail(rs.getString(4));
                }
            ResultSet rs1=st.executeQuery("select * from manager where id='"+mid+"'");
            while(rs.next()) {
                m1.setMid(rs.getInt(1));
                m1.setNo(rs.getInt(2));
                m1.setName(rs.getString(3));
                m1.setEmail(rs.getString(4));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return e1;
    }
    @Override
    public List<Employee1> selectAll(){
        List<Employee1> employee1List=new ArrayList<>();
        List<Manager> managerList=new ArrayList<>();
        List<Employee1> EmployeeResult= new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee");
            while (rs.next()){
                Employee1 e1=new Employee1();
                e1.setEid(rs.getInt(1));
                e1.setNo(rs.getInt(2));
                e1.setName(rs.getString(3));
                e1.setEmail(rs.getString(4));
                employee1List.add(e1);
            }
            ResultSet rs1=st.executeQuery("select * from manager");
            while (rs1.next()){
                Manager m1=new Manager();
                m1.setMid(rs1.getInt(1));
                m1.setNo(rs1.getInt(2));
                m1.setName(rs1.getString(3));
                m1.setEmail(rs1.getString(4));
                managerList.add(m1);
            }
            for (int i=0;i<employee1List.size();i++){
                if(managerList.size()<i){
                    Employee1 e1= employee1List.get(i);
                    e1.setM1(managerList.get(managerList.size()));
                    EmployeeResult.add(e1);
                }
                else {
                    Employee1 e1= employee1List.get(i);
                    e1.setM1(managerList.get(i));
                    EmployeeResult.add(e1);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return EmployeeResult;
    }
    @Override
    public Employee1 updateSingle(Employee1 e1){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            Statement st=con.createStatement();
            st.executeUpdate("update employee set no='"+e1.getNo()+"',name='"+e1.getName()+"',email='"+e1.getEmail()+"',where id='"+e1.getEid()+"'");
            st.executeUpdate("update manager set no='"+e1.getM1().getNo()+"',name='"+e1.getM1().getName()+"',email='"+e1.getM1().getEmail()+"',where id='"+e1.getM1().getMid()+"'");
        }catch (Exception e){
            System.out.println(e);
        }
        return e1;
    }
    @Override
    public Boolean deleteSingle(int eid,int mid){
        Boolean result= false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            Statement st= con.createStatement();
            int numberOfDeleteEmployee = st.executeUpdate("delete from employee where id='"+eid+"'");
            int numberOfDeleteManager = st.executeUpdate("delete from manager where id='"+mid+"'");
            if(numberOfDeleteEmployee>0){
                result=true;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }
    @Override
    public Boolean deleteAll(){
        Boolean result=false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            Statement st= con.createStatement();
            int employeeResult=st.executeUpdate("delete from employee");
            int managerResult=st.executeUpdate("delete from manager");
            if(employeeResult>0|| managerResult>0){
                result= true;
            }
        }catch(Exception e){
            System.out.println(e);
        }return result;
    }
}
