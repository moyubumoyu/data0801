package test02.service;

import test02.entity.Employees;
import test02.page.PageBean;

import java.util.List;

public interface EmpService {
    List<Employees> findAll();
    int addEmp(Object...obj);
    int deleteEmp(int id);
    int updateEmp(Object...obj);
    PageBean findPage(String currentPage,String pageSize);
}
