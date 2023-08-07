package test05.dao;

import test05.entity.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();
    List<Account> findEmpByLimit(int cpage, int size);
}
