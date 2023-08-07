package test05.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import test05.dao.AccountDao;
import test05.entity.Account;
import test05.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        try {
            return qr.query(sql,new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> findEmpByLimit(int cpage, int size) {
        String sql = "select * from account limit ?,?";
        int start = (cpage-1)*size;
        try {
            return qr.query(sql,new BeanListHandler<>(Account.class),start,size);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
