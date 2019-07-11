package com.demo.service;

import com.demo.dao.UserMapper;
import com.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class UserService {
	@Autowired(required = false)
	private UserMapper mapper;

    public int insertUser(UserEntity user) {
        return mapper.insertUser(user);
    }

    public int deleteUser(UserEntity user) {
        return mapper.deleteUser(user);
    }

    public int updateUser(UserEntity user) {
        return mapper.updateUser(user);
    }

    public UserEntity findById(int id){
        return mapper.findById(id);
    }

    public List<UserEntity> queryList(){
        List<UserEntity> userList=mapper.queryList();
        return userList;
    }

}
