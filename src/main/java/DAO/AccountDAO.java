package DAO;

import Model.Account;
import Util.ConnectionUtil;

import java.sql.*;

public class AccountDAO {

    public Account registerAccount(Account account) {
        Connection connection = ConnectionUtil.getConnection();
        String sql = "INSERT INTO account (username, password) VALUES (?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, account.getUsername());
        preparedStatement.setString(2, account.getPassword());

        preparedStatement.executeUpdate();



    }
    
}
