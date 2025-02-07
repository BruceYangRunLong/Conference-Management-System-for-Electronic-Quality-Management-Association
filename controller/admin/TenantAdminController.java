package com.lemon.meet.controller.admin;

import java.util.List;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import com.lemon.database.pagehelper.PageList;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.lemon.meet.entity.dto.TenantDTO;
import com.lemon.meet.entity.vo.TenantVO;
import com.lemon.meet.service.TenantService;

/**
 * @describe (Tenant)租户管理端控制器
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 15:20:44
 * @version 1.0.0
 * @updateTime 2024-06-22 15:20:44
 */

@Api(tags = "租户(管理端)")
@ResponseResult
@RestController
@RequestMapping("/admin/tenant")
public class TenantAdminController {

    @Resource
    private TenantService tenantService;


    @GetMapping("/id/{id}")
    @ApiOperation("ID查询")
    public TenantVO findById(@ApiParam("ID") @PathVariable(name = "id") Long id){
        return tenantService.findById(id);
    }


    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    public PageList<TenantVO> pageList(TenantDTO tenantDTO,
                                     @ApiParam("页数")@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                     @ApiParam("每页显示条数")@RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize,
                                     @ApiParam("是否查询总条数")@RequestParam(name = "count",defaultValue = "false")Boolean count){
        return tenantService.pageList(tenantDTO,pageNum, pageSize, count);
    }


    @GetMapping("/list")
    @ApiOperation("查询全部")
    public List<TenantVO> list(){
        return tenantService.list();
    }


    @PostMapping("/add")
    @ApiOperation("添加")
    public Boolean add(@RequestBody TenantDTO tenantDTO){
        return tenantService.add(tenantDTO);
    }


    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除")
    public Boolean remove(@ApiParam("id") @PathVariable(value = "id") Long id){
        return tenantService.remove(id);
    }


    @PutMapping("/modify")
    @ApiOperation("修改")
    public Boolean modify(@RequestBody TenantDTO tenantDTO){
        return tenantService.modify(tenantDTO);
    }



    @PostMapping("/registe")
    @ApiOperation("注册")
    public Boolean registe(@RequestBody TenantDTO tenantDTO){
        return tenantService.registe(tenantDTO);
    }


    @GetMapping("/code/send")
    @ApiOperation("发送验证码")
    public Boolean sendCode(@ApiParam("手机号")@RequestParam(name = "mobile") String mobile){
        return tenantService.sendCode(mobile);
    }

}

