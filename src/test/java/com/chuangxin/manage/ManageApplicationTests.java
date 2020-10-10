package com.chuangxin.manage;

import com.chuangxin.manage.dao.PhotoDao;
import com.chuangxin.manage.util.Generator;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.chuangxin.manage.dao")
class ManageApplicationTests {

    @Autowired
    Generator generator;

    @Autowired
    PhotoDao photoDao;

    @Test
    void contextLoads() {
//        byte[] bytes = "wefwef".getBytes();
//        photoDao.insertPhoto("aaa", "aaaa", bytes);
        System.out.println(photoDao.findById("aaa"));
    }

}
