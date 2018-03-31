package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


//@Ignore不执行

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {


    //Autowired动态的实现AreaDao的mybatis实现类 并把它注册进来
    @Autowired
    private AreaDao areaDao;
    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList=areaDao.queryArea();
        //期望值expected,两边都不为空就调用equals来判断
        assertEquals(2, areaList.size());
     }

    @Test
    public void queryAreaId() {
        Area area=areaDao.queryAreaById(1);
        assertEquals("东苑", area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area=new Area();
        area.setAreaName("山水一舍2栋");
        area.setPriority(2);
        int effectedNum=areaDao.insertArea(area);
        assertEquals(1,effectedNum);

    }

    @Test
    public void updataArea() {
        Area area =new Area();
        area.setAreaName("南院");
        area.setAreaId(2);
        area.setLastEditTime(new Date());
        int effectedNum=areaDao.updateArea(area);
        assertEquals(1,effectedNum);

    }

    @Test
    public void deleteArea() {
        int effectedNum=areaDao.deleteArea(1);
        assertEquals(1,effectedNum);

    }
}