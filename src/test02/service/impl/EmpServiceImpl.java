package test02.service.impl;

import test02.dao.EmpDao;
import test02.dao.impl.EmpDaoImpl;
import test02.entity.Employees;
import test02.page.PageBean;
import test02.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao empDao = new EmpDaoImpl();
    @Override
    public List<Employees> findAll() {
        return empDao.findAll();
    }

    @Override
    public int addEmp(Object...obj) {
        return empDao.addEmp(obj);
    }

    @Override
    public int deleteEmp(int id) {
        return empDao.deleteEmp(id);
    }

    @Override
    public int updateEmp(Object... obj) {
        return empDao.updateEmp(obj);
    }

    @Override
    public PageBean findPage(String currentPage, String pageSize) {
        PageBean pb = new PageBean();
        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);
        pb.setCurrentPage(cpage);
        pb.setPageSize(size);
        List<Employees> list = empDao.findEmpByLimit(cpage,size);
        pb.setList(list);

        List<Employees> allEmployees = empDao.findAll();
        pb.setTotalCount(allEmployees.size());
        return pb;
    }
}
