package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表AreaList
     * @return areaList
     */
    List<Area> queryArea();
    /**
     * 传入id获取单条对应的区域信息
     */
    Area queryAreaId(int areaId);

    /**
     *插入区域信息
     * @return
     */
    int insertArea(Area area);

    /**
     * 修改区域信息
     */

    int updataArea(Area area);
    /**
     *删除区域信息
     */
    int deleteArea(int areaId);

}
