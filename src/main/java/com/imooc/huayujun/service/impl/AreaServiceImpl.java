package com.imooc.huayujun.service.impl;

import com.imooc.huayujun.dao.AreaDao;
import com.imooc.huayujun.entity.Area;
import com.imooc.huayujun.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
//        if(!"".equals(areaId)){
//        int a=1/0;
        return areaDao.queryAreaById(areaId);

//        }else{
//            throw new RuntimeException("areaId不能为空");
//        }
    }

    /**
     * 添加区域信息
     * @param area
     * @return
     */
    //事务控制
    @Transactional
    @Override
    public boolean addArea(Area area) {
        //判断areaId不能为空
        if(area.getAreaName()!=null&&!"".equals(area.getAreaName())){
            area.setLastEditTime(new Date());
            try{
                int effectedNum=areaDao.insertArea(area);
                if(effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch(Exception e){
                throw new RuntimeException("插入区域信息失败"+e.getMessage());
            }

        }else{
            throw new RuntimeException("区域名称不能为空");

        }
    }

    /**
     * 修改区域信息
     * @param area
     * @return
     */
    @Override
    public boolean modifyArea(Area area) {
        //判断areaId是否为空
        if(area.getAreaId()!=null&&area.getAreaId()>0){
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("修改区域信息失败");
                }
            }catch(Exception e){
                throw new RuntimeException("修改区域信息失败"+e.toString());
            }
        }else{
            throw new RuntimeException("areaId不能为空");

        }
    }

    /**
     * 删除单条
     * @param areaId
     * @return
     */
    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                int effectedNum=areaDao.deleteArea(areaId);
                if(effectedNum>0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败");
                }
            }catch(Exception e){
                throw new RuntimeException("删除区域信息失败"+e.toString());
            }

        }else{
            throw new RuntimeException("areaId不能为空");

        }
    }
}
