package dao.sql;

import Model.User;
import dao.UsersDAO;
import db.UsersDB;
import db.UsersDBException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLUsersDAO implements UsersDAO {

    private UsersDB db;

    public SQLUsersDAO(UsersDB db) {
        this.db = db;
    }

    @Override
    public List<User> getAll() throws Exception, UsersDBException {
        try (Connection conn = db.connect()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from user_table;");
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = mapResultSetToUser(resultSet);
                users.add(user);
            }
            return users;
        }
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setID(resultSet.getInt("ID"));
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));

        return user;
    }

    @Override
    public void add(User user) throws UsersDBException, SQLException {
        try (Connection connection = db.connect()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO user_test(ID, username, password) values('" + user.getUserName() + "', '" + user.getPassword() + "');");
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT CURRVAL('user_ids')");
            resultSet.next();
            user.setID(resultSet.getInt(1));
        }
    }
}
