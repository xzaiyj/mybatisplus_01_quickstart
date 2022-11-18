package com.xz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xz.dao.UserDao;
import com.xz.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;


    @Test
    void testUpdate(){

        User user = new User();
        user.setId(1L);
        user.setName("Tom666");
        userDao.updateById(user);
    }

    @Test
    void testDelete(){
        userDao.deleteById(1580737673526300673L);
    }


    @Test
    void testSave(){
        User user = new User();
        user.setName("镇哥");
        user.setAge(25);
        user.setPassword("123456");
        user.setTel("1452642");
        userDao.insert(user);
    }

    @Test
    void testGetAll() {
        //方式一：按条件查询

//        QueryWrapper qw = new QueryWrapper();
//        qw.lt("age",18);
//        List<User> userList = userDao.selectList(qw);
//        System.out.println(userList);


//        方式二：Lambda格式按条件查询

//        QueryWrapper<User> qw = new QueryWrapper();
//        qw.lambda().lt(User::getAge,18);
//        List<User> userList = userDao.selectList(qw);
//        System.out.println(userList);


        //        方式三：Lambda格式按条件查询

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.lt(User::getAge,18);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);

    }

    @Test
    void testGetByPage(){
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页码值："+ page.getCurrent());
        System.out.println("当前显示数："+ page.getSize());
        System.out.println("一共多少页："+ page.getPages());
        System.out.println("一共多少条数据："+ page.getTotal());
        System.out.println("一数据："+ page.getRecords());
        System.out.println("hello git!");
        System.out.println("hello git2!");
        System.out.println("hello git3!");
        System.out.println("hello git4!");
        System.out.println("hello githot-fix!");
    }

}
