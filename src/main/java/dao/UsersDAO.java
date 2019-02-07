package dao;

import Model.User;
import db.UsersDBException;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {

    List<User> getAll() throws Exception, UsersDBException;

//    void delete(User user) throws UsersDBException, SQLException;
//
    void add(User user) throws UsersDBException, SQLException;
//
//    void update(User user) throws UsersDBException, SQLException;
}
