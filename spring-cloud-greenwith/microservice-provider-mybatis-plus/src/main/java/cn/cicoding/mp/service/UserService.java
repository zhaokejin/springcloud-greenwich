package cn.cicoding.mp.service;

import cn.cicoding.mp.entity.UserDomain;

import java.util.List;

public interface UserService {

    int insert(UserDomain record);

    void deleteUserById(Integer userId);

    void updateUser(UserDomain userDomain);

    List<UserDomain> selectUsers();

    UserDomain findById(Integer id);
}
