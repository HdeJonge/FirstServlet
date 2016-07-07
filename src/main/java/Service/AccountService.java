 package Service;

import java.util.ArrayList;


import POJO.Account;
import DAO.Hibernate.AccountDAOHibernate;
 
public class AccountService {

	private static AccountDAOHibernate accountDao;

	public AccountService() {
		accountDao = new AccountDAOHibernate();
	}

	public void save(Account entity) {
		accountDao.openCurrentSessionWithTransaction();
		accountDao.save(entity);
		accountDao.closeCurrentSessionWithTransaction();
	}

	public void update(Account entity) {
		accountDao.openCurrentSessionWithTransaction();
		accountDao.update(entity);
		accountDao.closeCurrentSessionWithTransaction();
	}

	public Account findById(int id) {
		accountDao.openCurrentSession();
		Account account = accountDao.findById(id);
		accountDao.closeCurrentSession();
		return account;
	}

	public void delete(int id) {
		accountDao.openCurrentSessionWithTransaction();
		Account account = accountDao.findById(id);
		accountDao.delete(account);
		accountDao.closeCurrentSessionWithTransaction();
	}

	public void delete(Account account) {
		accountDao.openCurrentSessionWithTransaction();
		accountDao.delete(account);
		accountDao.closeCurrentSessionWithTransaction();
	}

	public ArrayList<Account> findAll() {
		accountDao.openCurrentSession();
		ArrayList<Account> accounten = accountDao.findAll();
		accountDao.closeCurrentSession();
		return accounten;
	}


	public AccountDAOHibernate AccountDAOHibernate() {
		return accountDao;
	}
}
