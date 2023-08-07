package test02.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import test02.dao.EmpDao;
import test02.entity.Employees;
import test02.utils.JDBCUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Employees> findAll() {
        String sql = "select * from employees";
        try {
            return qr.query(sql,new BeanListHandler<Employees>(Employees.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int addEmp(Object...obj) {
        String sql = "insert into employees values(?,?,?,?,?)";
        try {
            return qr.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEmp(int id) {
        String sql = "delete from employees where employeeId=?";
        try {
            return qr.update(sql,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Employees> findEmpByLimit(int cpage, int size) {
        String sql = "select * from employees limit ?,?";
        int start = (cpage-1)*size;
        try {
            return qr.query(sql,new BeanListHandler<>(Employees.class),start,size);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateEmp(Object...obj) {
        String sql = "update employees set name=?,salary=?,hireDate=?,departmentId=? where employeeId=?";
        try {
            return qr.update(sql,obj);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }


}
