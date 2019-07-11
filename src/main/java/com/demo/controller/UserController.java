package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.entity.UserEntity;
import com.demo.service.UserService;
import com.demo.utils.SecurityUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

    /**
     * @deprecated 新增用户信息
     * @param request
     * @return
     */
    @RequestMapping("/insertUser")
    public JSONObject insertUser(HttpServletRequest request) {
        try{
            UserEntity userBean = new UserEntity();
            userBean = buildUser(request);
            int i = userService.insertUser(userBean);
            if(i==0){
                return errorResult();
            }else{
                return successResult();
            }
        }catch (Exception e){
            e.printStackTrace();
            return errorResult();
        }
    }

    /**
     * @deprecated 逻辑删除用户信息
     * @param request
     * @return
     */
    @RequestMapping("/deleteUser")
    public JSONObject deleteUser(HttpServletRequest request) {
        try {
            UserEntity userBean = new UserEntity();
            userBean.setId(Integer.parseInt(SecurityUtils.getPara(request,"id")));
            int i = userService.deleteUser(userBean);
            if(i==0){
                return errorResult();
            }else{
                return successResult();
            }
        }catch (Exception e){
            e.printStackTrace();
            return errorResult();
        }
    }

    /**
     * @deprecated 更新用户数据
     * @param request
     * @return
     */
    @RequestMapping("/updateUser")
    public JSONObject updateUser(HttpServletRequest request) {
        try {
            UserEntity userBean = new UserEntity();
            userBean = buildUser(request);
            userBean.setId(Integer.parseInt(SecurityUtils.getPara(request,"id")));
            int i = userService.updateUser(userBean);
            if(i==0){
                return errorResult();
            }else{
                return successResult();
            }
        }catch (Exception e){
            e.printStackTrace();
            return errorResult();
        }
    }

    /**
     * 根据id查询一条数据
     * @param request
     * @return
     */
    @RequestMapping("/queryUserById")
    public UserEntity queryUserById(HttpServletRequest request){
        UserEntity userUser = new UserEntity();
        try {
            int id = Integer.parseInt(SecurityUtils.getPara(request,"id"));
            System.out.println(id);
            userUser = userService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return userUser;
    }

    @RequestMapping("/queryUserList")
    public List<UserEntity> queryUserList(HttpServletRequest request){
        List<UserEntity> list = new ArrayList<UserEntity>();
        try{
            int pageNum = Integer.parseInt(SecurityUtils.getPara(request,"pageNum"));
            int pageSize = Integer.parseInt(SecurityUtils.getPara(request,"pageSize"));
            PageHelper.startPage(pageNum, pageSize);
            list = userService.queryList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static UserEntity buildUser(HttpServletRequest request){
        UserEntity userBean = new UserEntity();
        try{
            String re_name = SecurityUtils.getPara(request,"name");
            String name = StringUtils.isEmpty(re_name)?"definedName":re_name;
            String re_age = SecurityUtils.getPara(request,"age");
            String age = StringUtils.isEmpty(re_age)?"10":re_age;
            int int_age = Integer.parseInt(age);
            userBean.setName(name);
            userBean.setAge(int_age);
            userBean.setState("1");
            userBean.setCreateDate(new Date());
            return userBean;
        }catch (Exception e){
            return userBean;
        }
    }

    public static JSONObject successResult(){
        JSONObject obj = new JSONObject();
        obj.put("state","1");
        obj.put("error","调用成功");
        return obj;
    }

    public static JSONObject errorResult(){
        JSONObject obj = new JSONObject();
        obj.put("state","0");
        obj.put("error","调用失败");
        return obj;
    }

}
