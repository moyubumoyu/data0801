package test05.service.impl;

import test05.dao.AccountDao;
import test05.dao.impl.AccountDaoImpl;
import test05.entity.Account;
import test05.entity.PageBean;
import test05.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public PageBean findPage(String currentPage, String pageSize) {
        PageBean pb = new PageBean();
        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);
        pb.setCurrentPage(cpage);
        pb.setPageSize(size);
        List<Account> list = accountDao.findEmpByLimit(cpage,size);
        pb.setList(list);

        List<Account> allAccount = accountDao.findAll();
        pb.setTotalCount(allAccount.size());
        return pb;
    }
}
