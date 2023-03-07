package web.dao;

import web.model.Users;

import java.util.List;

public interface DAO {
    List<Users> getAllUsers();

    Users getUserId(long id);

    void addUser(Users users);

    void updateUser(Users users);

    Users removeUser(long id);
}
