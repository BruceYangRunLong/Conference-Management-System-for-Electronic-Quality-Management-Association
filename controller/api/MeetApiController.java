package com.lemon.meet.controller.api;

import java.util.List;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import com.lemon.database.pagehelper.PageList;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.lemon.meet.entity.dto.MeetDTO;
import com.lemon.meet.entity.vo.MeetVO;
import com.lemon.meet.service.MeetService;

/**
 * @describe (Meet)会议控制器
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 18:41:25
 * @version 1.0.0
 * @updateTime 2024-06-22 18:41:25
 */

@Api(tags = "会议(客户端)")
@ResponseResult
@RestController
@RequestMapping("/api/meet")
public class MeetApiController {

    @Resource
    private MeetService meetService;


    @GetMapping("/id/{id}")
    @ApiOperation("ID查询")
    public MeetVO findById(@ApiParam("ID") @PathVariable(name = "id") Long id){
        return meetService.findById(id);
    }


    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    public PageList<MeetVO> pageList(MeetDTO meetDTO,
                                     @ApiParam("页数")@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                     @ApiParam("每页显示条数")@RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize,
                                     @ApiParam("是否查询总条数")@RequestParam(name = "count",defaultValue = "false")Boolean count){
        return meetService.pageList(meetDTO,pageNum, pageSize, count);
    }


    @GetMapping("/list")
    @ApiOperation("查询全部")
    public List<MeetVO> list(){
        return meetService.list();
    }


    @PostMapping("/add")
    @ApiOperation("添加")
    public Boolean add(@RequestBody MeetDTO meetDTO){
        return meetService.add(meetDTO);
    }


    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除")
    public Boolean remove(@ApiParam("id") @PathVariable(value = "id") Long id){
        return meetService.remove(id);
    }


    @PutMapping("/modify")
    @ApiOperation("修改")
    public Boolean modify(@RequestBody MeetDTO meetDTO){
        return meetService.modify(meetDTO);
    }

}

