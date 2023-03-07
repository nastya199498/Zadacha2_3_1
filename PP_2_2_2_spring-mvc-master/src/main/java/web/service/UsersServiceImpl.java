package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DAO;
import web.model.Users;

import java.util.List;
@Service
@Transactional
public class UsersServiceImpl implements UsersService{
    private final DAO userDAO;

    @Autowired
    public UsersServiceImpl(DAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<Users> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public Users getUserId(long id) {
        return userDAO.getUserId(id);
    }

    @Override
    public void addUser(Users user) {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(Users user) {
        userDAO.updateUser(user);
    }

    @Override
    public Users removeUser(long id) {
        return userDAO.removeUser(id); }
}
