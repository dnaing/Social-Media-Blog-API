package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {

    private AccountDAO account;

    public AccountService() {
        account = new AccountDAO();
    }

    public Account registerAccount(Account account) {
        if (account.getUsername().length() == 0 ||
            account.getPassword().length() < 4 ||
            this.getAccountByUsername(account.getUsername()) != null) {
                return null;
        }
        return this.account.registerAccount(account);
    }

    public Account getAccountByUsername(String username) {
        return this.account.getAccountByUsername(username);
    }
    
    
}
