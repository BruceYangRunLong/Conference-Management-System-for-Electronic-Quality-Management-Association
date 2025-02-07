package com.lemon.meet.controller.api;

import java.util.List;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import com.lemon.database.pagehelper.PageList;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.lemon.meet.entity.dto.CourseDTO;
import com.lemon.meet.entity.vo.CourseVO;
import com.lemon.meet.service.CourseService;

/**
 * @describe (Course)课程控制器
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:14:34
 * @version 1.0.0
 * @updateTime 2024-06-22 18:14:34
 */

@Api(tags = "课程(客户端)")
@ResponseResult
@RestController
@RequestMapping("/api/course")
public class CourseApiController {

    @Resource
    private CourseService courseService;


    @GetMapping("/id/{id}")
    @ApiOperation("ID查询")
    public CourseVO findById(@ApiParam("ID") @PathVariable(name = "id") Long id){
        return courseService.findById(id);
    }


    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    public PageList<CourseVO> pageList(CourseDTO courseDTO,
                                     @ApiParam("页数")@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                     @ApiParam("每页显示条数")@RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize,
                                     @ApiParam("是否查询总条数")@RequestParam(name = "count",defaultValue = "false")Boolean count){
        return courseService.pageList(courseDTO,pageNum, pageSize, count);
    }


    @GetMapping("/list")
    @ApiOperation("查询全部")
    public List<CourseVO> list(){
        return courseService.list();
    }


    @PostMapping("/add")
    @ApiOperation("添加")
    public Boolean add(@RequestBody CourseDTO courseDTO){
        return courseService.add(courseDTO);
    }


    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除")
    public Boolean remove(@ApiParam("id") @PathVariable(value = "id") Long id){
        return courseService.remove(id);
    }


    @PutMapping("/modify")
    @ApiOperation("修改")
    public Boolean modify(@RequestBody CourseDTO courseDTO){
        return courseService.modify(courseDTO);
    }

}

