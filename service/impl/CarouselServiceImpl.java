package com.lemon.meet.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.lemon.meet.entity.excel.CarouselExcel;
import com.lemon.util.bean.LemonBeanUtil;
import com.lemon.database.pagehelper.PageUtil;
import com.lemon.util.excel.LemonExcelUtil;
import com.lemon.util.mark.LemonSnowFlakeUtil;
import org.springframework.stereotype.Service;
import com.lemon.database.pagehelper.PageList;
import tk.mybatis.mapper.entity.Example;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lemon.database.service.impl.BaseServiceImpl;
import com.lemon.meet.entity.bo.CarouselBO;
import com.lemon.meet.entity.dto.CarouselDTO;
import com.lemon.meet.entity.vo.CarouselVO;
import com.lemon.meet.dao.CarouselDao;
import com.lemon.meet.service.CarouselService;

/**
 * @author
 * @version 1.0.0
 * @describe (Carousel)轮播图Service层实现
 * @company lemon
 * @address 
 * @updateTime 2024-06-23 09:57:20
 * @since 2024-06-23 09:57:20
 */
@Service("carouselService")
public class CarouselServiceImpl extends BaseServiceImpl<CarouselBO> implements CarouselService {

    @Resource
    private CarouselDao carouselDao;

    /**
     * @param id
     * @return CarouselVO
     * @describe ID查询
     */
    @Override
    public CarouselVO findById(Long id) {
        return LemonBeanUtil.cloneBeanProperties(carouselDao.selectByPrimaryKey(id), CarouselVO.class);
    }


    /**
     * @param pageNum 第几页
     * @return PagerList<CarouselVO>
     * @describe 分页查询
     * @Param pageSize 每页显示条数
     * @Param count 是否查询总条数
     */
    @Override
    public PageList<CarouselVO> pageList(CarouselDTO carouselDTO, Integer pageNum, Integer pageSize, Boolean count) {
        PageUtil.startPage(pageNum, pageSize, count);
        Example example = new Example(CarouselBO.class);
        Example.Criteria criteria = example.createCriteria();
        if (ObjectUtil.isNotEmpty(carouselDTO.getCarouselId())) {
            criteria.andEqualTo(CarouselBO.Properties.carouselId, carouselDTO.getCarouselId());
        }
        if (StrUtil.isNotBlank(carouselDTO.getTitle())) {
            criteria.andLike(CarouselBO.Properties.title, "%" + carouselDTO.getTitle() + "%");
        }
        if (ObjectUtil.isNotEmpty(carouselDTO.getSort())) {
            criteria.andEqualTo(CarouselBO.Properties.sort, carouselDTO.getSort());
        }
        return PageUtil.castToPageList(carouselDao.selectByExample(example)).toClass(CarouselVO.class);
    }


    /**
     * @param
     * @return List<CarouselVO>
     * @describe 查询全部
     */
    @Override
    public List<CarouselVO> list() {
        return LemonBeanUtil.listCloneProperties(carouselDao.selectAll(), CarouselVO.class);
    }


    /**
     * @param carouselDTO
     * @return Boolean
     * @describe 增加
     */
    @Override
    public Boolean add(CarouselDTO carouselDTO) {
        CarouselBO carouselBO = LemonBeanUtil.cloneBeanProperties(carouselDTO, CarouselBO.class);
        carouselBO.setCarouselId(LemonSnowFlakeUtil.nextId());
        return carouselDao.insert(carouselBO) > 0;
    }


    /**
     * @param id
     * @return Boolean
     * @describe 删除
     */
    @Override
    public Boolean remove(Long id) {
        return carouselDao.deleteByPrimaryKey(id) > 0;
    }


    /**
     * @param carouselDTO
     * @return Boolean
     * @describe 修改
     */
    @Override
    public Boolean modify(CarouselDTO carouselDTO) {
        CarouselBO carouselBO = LemonBeanUtil.cloneBeanProperties(carouselDTO, CarouselBO.class);
        return carouselDao.updateByPrimaryKeySelective(carouselBO) > 0;
    }


    /**
     * excel导出
     */
    @Override
    public void exportExcel() {
        //查询全部
        List<CarouselBO> carouselBOS = carouselDao.selectAll();
        List<CarouselExcel> carouselExcels = LemonBeanUtil.listCloneProperties(carouselBOS, CarouselExcel.class);
        LemonExcelUtil.writeExcel("轮播图导出","轮播图",CarouselExcel.class,carouselExcels);
    }

}
