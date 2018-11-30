package com.ccb.mahm.web.controller;

import com.ccb.mahm.core.model.User;
import com.ccb.mahm.core.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class TestUserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    @ApiOperation("添加用户信息")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 500, message = "服务器内部异常"),
            @ApiResponse(code = 401, message = "权限不足") })
    @ApiImplicitParam(name="user", value="User", required = true, dataType = "User")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    @ApiOperation("获取用户列表")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 500, message = "服务器内部异常"),
            @ApiResponse(code = 401, message = "权限不足") })
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize  ", required = false, defaultValue = "10")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
}
