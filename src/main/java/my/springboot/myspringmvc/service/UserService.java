package my.springboot.myspringmvc.service;

import my.springboot.myspringmvc.pojo.User;
import my.springboot.myspringmvc.pojo.User2;

public interface UserService {
    User getUser(Long id);
    User2 getUser2(Long id);
}
