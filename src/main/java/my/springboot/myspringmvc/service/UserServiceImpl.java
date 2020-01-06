package my.springboot.myspringmvc.service;

import my.springboot.myspringmvc.dao.UserDao;
import my.springboot.myspringmvc.pojo.User;
import my.springboot.myspringmvc.pojo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public User2 getUser2(Long id) {
        return userDao.getUser2(id);
    }
}
