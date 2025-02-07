package com.lemon.meet.controller.api;

import java.util.List;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import com.lemon.database.pagehelper.PageList;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.lemon.meet.entity.dto.UserDTO;
import com.lemon.meet.entity.vo.UserVO;
import com.lemon.meet.service.UserService;

/**
 * @describe (User)用户控制器
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 13:59:40
 * @version 1.0.0
 * @updateTime 2024-06-22 13:59:40
 */

@Api(tags = "用户(客户端)")
@ResponseResult
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Resource
    private UserService userService;


    @GetMapping("/id/{id}")
    @ApiOperation("ID查询")
    public UserVO findById(@ApiParam("ID") @PathVariable(name = "id") Long id){
        return userService.findById(id);
    }


    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    public PageList<UserVO> pageList(UserDTO userDTO,
                                     @ApiParam("页数")@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                     @ApiParam("每页显示条数")@RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize,
                                     @ApiParam("是否查询总条数")@RequestParam(name = "count",defaultValue = "false")Boolean count){
        return userService.pageList(userDTO,pageNum, pageSize, count);
    }


    @GetMapping("/list")
    @ApiOperation("查询全部")
    public List<UserVO> list(){
        return userService.list();
    }


    @PostMapping("/add")
    @ApiOperation("添加")
    public Boolean add(@RequestBody UserDTO userDTO){
        return userService.add(userDTO);
    }


    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除")
    public Boolean remove(@ApiParam("id") @PathVariable(value = "id") Long id){
        return userService.remove(id);
    }


    @PutMapping("/modify")
    @ApiOperation("修改")
    public Boolean modify(@RequestBody UserDTO userDTO){
        return userService.modify(userDTO);
    }

}

