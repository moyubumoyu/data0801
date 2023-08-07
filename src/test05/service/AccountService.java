package test05.service;


import test05.entity.Account;
import test05.entity.PageBean;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    PageBean findPage(String currentPage, String pageSize);
}
