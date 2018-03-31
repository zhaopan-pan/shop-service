package com.imooc.demo.web;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//标识controller类 RestController包括(responseBody和Controller)
@RestController
@RequestMapping("/superAdmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    /**
     * 获取列表
     * @return
     */
    @RequestMapping(value = "/arealist",method = RequestMethod.GET)
    private Map<String,Object> ListArea(){
        //实例化map,
        Map<String,Object> modelMap=new HashMap<String,Object>();
        //获取列表
        List<Area> list=areaService.getAreaList();
//        for(int i=1,i<list.){
//
//        }
        //向map里面put放入list
        modelMap.put("areaList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    private Map<String,Object> getAreaById(Integer areaId){
        //实例化map,
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Area area=areaService.getAreaById(areaId);
        if(area==null){
            modelMap.put("-1","暂无数据");
        }else{
            modelMap.put("area",area);
        }
        return modelMap;
    }

    /**
     * 添加area
     * @param area
     * @return
     */
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){   //RequestBody：除x-www-form-urlencoded之外的可以传入json或xml等
        //实例化map,
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    /**
     * 修改单条area
     * @param area
     * @return
     */
    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area){   //RequestBody：除x-www-form-urlencoded之外的可以传入json或xml等
        //实例化map,
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    /**
     * 删除单条
     * @param areaId
     * @return
     */
    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String,Object> removeArea(Integer areaId){
        //实例化map,
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }

}
