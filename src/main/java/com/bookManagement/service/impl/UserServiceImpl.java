package com.bookManagement.service.impl;
import com.bookManagement.dao.UserMapper;
import com.bookManagement.entity.User;
import com.bookManagement.service.UserService;
import com.bookManagement.service.exception.AuthenticationFailedException;
import com.bookManagement.service.exception.UsernameAlreadyExistsException;
import com.bookManagement.tool.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {

    @Override
    public void register(String username, String password) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUserByUsername(username);
            if (user == null) {
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                mapper.insertUser(user);
                session.commit();
                System.out.println("Registration successful.");
            } else {
                throw new UsernameAlreadyExistsException("User already exists with username: " + username);
            }
        }
    }

    @Override
    public boolean login(String username, String password) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                System.out.println("Login successful.");
                return true;
            } else {
                throw new AuthenticationFailedException();
            }
        }
    }

    @Override
    public User findUserByUsername(String username) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUserByUsername(username);
            if (user != null) {
                return user;
            } else {
                System.out.println("The user does not exist.");
                return null;
            }
        }
    }
}
