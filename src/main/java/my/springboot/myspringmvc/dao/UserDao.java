package my.springboot.myspringmvc.dao;

import my.springboot.myspringmvc.pojo.User;
import my.springboot.myspringmvc.pojo.User2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User getUser(Long id);
    User2 getUser2(Long id);
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public User2 queryUserById(Long id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User2> queryUserAll();

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(User2 user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUser(User2 user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUser(Long id);
}
