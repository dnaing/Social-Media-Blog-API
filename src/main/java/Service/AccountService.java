package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {

    private AccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAO();
    }

    public Account registerAccount(Account account) {
        if (account.getUsername().length() == 0 ||
            account.getPassword().length() < 4 ||
            getAccountByUsername(account.getUsername()) != null) {
                return null;
        }
        return accountDAO.registerAccount(account);
    }

    public Account getAccountByUsername(String username) {
        return accountDAO.getAccountByUsername(username);
    }

    public Account getAccountByUserAndPass(String username, String password) {
        return accountDAO.getAccountByUserAndPass(username, password);
    }

    
    
}
