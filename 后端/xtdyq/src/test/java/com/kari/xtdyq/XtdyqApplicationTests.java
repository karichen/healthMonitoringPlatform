package com.kari.xtdyq;


import com.kari.mapper.UserMapper;
import com.kari.pojo.User;
import com.kari.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest
class XtdyqApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    User user;

    @Autowired
    DateUtil dateUtil;
    
    

    @Test
    void contextLoads() throws SQLException {
    }

}
