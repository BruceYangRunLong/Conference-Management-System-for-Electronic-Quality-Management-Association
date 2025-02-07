package com.lemon.meet.controller.admin;

import java.util.List;
import java.time.LocalDateTime;
import javax.annotation.Resource;

import com.lemon.database.annotation.Tenant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import com.lemon.database.pagehelper.PageList;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.lemon.meet.entity.dto.InformationDTO;
import com.lemon.meet.entity.vo.InformationVO;
import com.lemon.meet.service.InformationService;

/**
 * @describe (Information)资讯管理端控制器
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 17:39:16
 * @version 1.0.0
 * @updateTime 2024-06-22 17:39:16
 */

@Tenant
@Api(tags = "资讯(管理端)")
@ResponseResult
@RestController
@RequestMapping("/admin/information")
public class InformationAdminController {

    @Resource
    private InformationService informationService;


    @GetMapping("/id/{id}")
    @ApiOperation("ID查询")
    public InformationVO findById(@ApiParam("ID") @PathVariable(name = "id") Long id){
        return informationService.findById(id);
    }


    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    public PageList<InformationVO> pageList(InformationDTO informationDTO,
                                     @ApiParam("页数")@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                     @ApiParam("每页显示条数")@RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize,
                                     @ApiParam("是否查询总条数")@RequestParam(name = "count",defaultValue = "false")Boolean count){
        return informationService.pageList(informationDTO,pageNum, pageSize, count);
    }


    @GetMapping("/list")
    @ApiOperation("查询全部")
    public List<InformationVO> list(){
        return informationService.list();
    }


    @PostMapping("/add")
    @ApiOperation("添加")
    public Boolean add(@RequestBody InformationDTO informationDTO){
        return informationService.add(informationDTO);
    }


    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除")
    public Boolean remove(@ApiParam("id") @PathVariable(value = "id") Long id){
        return informationService.remove(id);
    }


    @PutMapping("/modify")
    @ApiOperation("修改")
    public Boolean modify(@RequestBody InformationDTO informationDTO){
        return informationService.modify(informationDTO);
    }



    @GetMapping("/export")
    public void excelExport(){
        informationService.excelExport();
    }

}

