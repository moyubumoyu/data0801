package test02.dao;

import test02.entity.Employees;

import java.util.List;

public interface EmpDao {
    List<Employees> findAll();
    int addEmp(Object...obj);
    int deleteEmp(int id);
    List<Employees> findEmpByLimit(int cpage,int size);
    int updateEmp(Object...obj);

}
