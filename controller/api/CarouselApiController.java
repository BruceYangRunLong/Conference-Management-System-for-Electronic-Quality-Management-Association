package com.lemon.meet.controller.api;

import java.util.List;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiOperation;
import com.lemon.database.pagehelper.PageList;
import com.lemon.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.lemon.meet.entity.dto.CarouselDTO;
import com.lemon.meet.entity.vo.CarouselVO;
import com.lemon.meet.service.CarouselService;

/**
 * @describe (Carousel)轮播图控制器
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-23 09:57:20
 * @version 1.0.0
 * @updateTime 2024-06-23 09:57:20
 */

@Api(tags = "轮播图(客户端)")
@ResponseResult
@RestController
@RequestMapping("/api/carousel")
public class CarouselApiController {

    @Resource
    private CarouselService carouselService;


    @GetMapping("/id/{id}")
    @ApiOperation("ID查询")
    public CarouselVO findById(@ApiParam("ID") @PathVariable(name = "id") Long id){
        return carouselService.findById(id);
    }


    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    public PageList<CarouselVO> pageList(CarouselDTO carouselDTO,
                                     @ApiParam("页数")@RequestParam(name = "pageNum",defaultValue = "1")Integer pageNum,
                                     @ApiParam("每页显示条数")@RequestParam(name = "pageSize",defaultValue = "8")Integer pageSize,
                                     @ApiParam("是否查询总条数")@RequestParam(name = "count",defaultValue = "false")Boolean count){
        return carouselService.pageList(carouselDTO,pageNum, pageSize, count);
    }


    @GetMapping("/list")
    @ApiOperation("查询全部")
    public List<CarouselVO> list(){
        return carouselService.list();
    }


    @PostMapping("/add")
    @ApiOperation("添加")
    public Boolean add(@RequestBody CarouselDTO carouselDTO){
        return carouselService.add(carouselDTO);
    }


    @DeleteMapping("/remove/{id}")
    @ApiOperation("删除")
    public Boolean remove(@ApiParam("id") @PathVariable(value = "id") Long id){
        return carouselService.remove(id);
    }


    @PutMapping("/modify")
    @ApiOperation("修改")
    public Boolean modify(@RequestBody CarouselDTO carouselDTO){
        return carouselService.modify(carouselDTO);
    }

}

