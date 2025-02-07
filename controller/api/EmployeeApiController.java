package com.lemon.meet.controller.api;

import java.util.List;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import com.lemon.database.pagehelper.PageList;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.lemon.meet.entity.dto.EmployeeDTO;
import com.lemon.meet.entity.vo.EmployeeVO;
import com.lemon.meet.service.EmployeeService;

/**
 * @describe (Employee)部门控制器
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 11:04:48
 * @version 1.0.0
 * @updateTime 2024-06-22 11:04:48
 */

@Api(tags = "部门(客户端)")
@ResponseResult
@RestController
@RequestMapping("/api/employee")
public class EmployeeApiController {

    @Resource
    private EmployeeService employeeService;


    @GetMapping("/id/{id}")
    @ApiOperation("ID查询")
    public EmployeeVO findById(@ApiParam("ID") @PathVariable(name = "id") Long id){
        return employeeService.findById(id);
    }


    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    public PageList<EmployeeVO> pageList(EmployeeDTO employeeDTO,
                                     @ApiParam("页数")@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                     @ApiParam("每页显示条数")@RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize,
                                     @ApiParam("是否查询总条数")@RequestParam(name = "count",defaultValue = "false")Boolean count){
        return employeeService.pageList(employeeDTO,pageNum, pageSize, count);
    }


    @GetMapping("/list")
    @ApiOperation("查询全部")
    public List<EmployeeVO> list(){
        return employeeService.list();
    }


    @PostMapping("/add")
    @ApiOperation("添加")
    public Boolean add(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.add(employeeDTO);
    }


    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除")
    public Boolean remove(@ApiParam("id") @PathVariable(value = "id") Long id){
        return employeeService.remove(id);
    }


    @PutMapping("/modify")
    @ApiOperation("修改")
    public Boolean modify(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.modify(employeeDTO);
    }

}

