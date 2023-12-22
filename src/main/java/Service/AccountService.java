package Service;

import DAO.AccountDAO;
import Model.Account;

public class AccountService {

    private AccountDAO account;

    public AccountService() {
        account = new AccountDAO();
    }

    public Account registerAccount(Account account) {
        return this.account.registerAccount(account);
    }
    
    
}
