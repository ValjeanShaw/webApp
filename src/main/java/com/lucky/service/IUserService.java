package com.lucky.service;

import com.lucky.mapper.IUserMapper;
import com.lucky.pojo.User;
import org.springframework.stereotype.Service;


public interface IUserService {


     User getUserById(int id);


}
