package com.lemon.meet.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.lang.tree.parser.NodeParser;
import com.lemon.util.bean.LemonBeanUtil;
import com.lemon.database.pagehelper.PageUtil;
import com.lemon.util.mark.LemonSnowFlakeUtil;
import org.springframework.stereotype.Service;
import com.lemon.database.pagehelper.PageList;
import tk.mybatis.mapper.entity.Example;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lemon.database.service.impl.BaseServiceImpl;
import com.lemon.meet.entity.bo.EmployeeBO;
import com.lemon.meet.entity.dto.EmployeeDTO;
import com.lemon.meet.entity.vo.EmployeeVO;
import com.lemon.meet.dao.EmployeeDao;
import com.lemon.meet.service.EmployeeService;

/**
 * @describe (Employee)部门Service层实现
 * @company lemon
 * @address 
 * @author
 * @since 2024-06-22 11:04:48
 * @version 1.0.0
 * @updateTime 2024-06-22 11:04:48
 */
@Service("employeeService")
public  class EmployeeServiceImpl extends BaseServiceImpl<EmployeeBO> implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

   /**
   *@describe ID查询
   *@param id
   *@return EmployeeVO
   */
   @Override
   public EmployeeVO findById(Long id){
        return LemonBeanUtil.cloneBeanProperties(employeeDao.selectByPrimaryKey(id),EmployeeVO.class);
   }


   /**
   *@describe 分页查询
   *@param pageNum 第几页
   *@Param pageSize 每页显示条数
   *@Param count 是否查询总条数
   *@return PagerList<EmployeeVO>
   */
   @Override
   public PageList<EmployeeVO> pageList(EmployeeDTO employeeDTO,Integer pageNum,Integer pageSize,Boolean count){
       PageUtil.startPage(pageNum,pageSize,count);
       Example example = new Example(EmployeeBO.class);
       Example.Criteria criteria = example.createCriteria();
             if(ObjectUtil.isNotEmpty(employeeDTO.getEmployeeId())){
          criteria.andEqualTo(EmployeeBO.Properties.employeeId, employeeDTO.getEmployeeId());
       }
                    if(ObjectUtil.isNotEmpty(employeeDTO.getParentId())){
          criteria.andEqualTo(EmployeeBO.Properties.parentId, employeeDTO.getParentId());
       }
                    if(StrUtil.isNotBlank(employeeDTO.getName())){
          criteria.andLike(EmployeeBO.Properties.name,"%" + employeeDTO.getName() + "%");
       }
                    if(StrUtil.isNotBlank(employeeDTO.getHead())){
          criteria.andLike(EmployeeBO.Properties.head,"%" + employeeDTO.getHead() + "%");
       }
                    if(StrUtil.isNotBlank(employeeDTO.getMobile())){
          criteria.andLike(EmployeeBO.Properties.mobile,"%" + employeeDTO.getMobile() + "%");
       }
                    if(StrUtil.isNotBlank(employeeDTO.getMail())){
          criteria.andLike(EmployeeBO.Properties.mail,"%" + employeeDTO.getMail() + "%");
       }
                    if(ObjectUtil.isNotEmpty(employeeDTO.getStatus())){
          criteria.andEqualTo(EmployeeBO.Properties.status, employeeDTO.getStatus());
       }
                    if(ObjectUtil.isNotEmpty(employeeDTO.getSort())){
          criteria.andEqualTo(EmployeeBO.Properties.sort, employeeDTO.getSort());
       }
              return PageUtil.castToPageList(employeeDao.selectByExample(example)).toClass(EmployeeVO.class);
   }


   /**
   *@describe 查询全部
   *@param
   *@return List<EmployeeVO>
   */
   @Override
   public List<EmployeeVO> list(){
       return LemonBeanUtil.listCloneProperties(employeeDao.selectAll(),EmployeeVO.class);
   }


   /**
   *@describe 增加
   *@param employeeDTO
   *@return Boolean
   */
   @Override
   public Boolean add(EmployeeDTO employeeDTO){
       EmployeeBO employeeBO = LemonBeanUtil.cloneBeanProperties(employeeDTO,EmployeeBO.class);
       employeeBO.setEmployeeId(LemonSnowFlakeUtil.nextId());
       employeeBO.setCreateTime(DateUtil.date());
       return employeeDao.insert(employeeBO) > 0;
   }


   /**
   *@describe 删除
   *@param id
   *@return Boolean
   */
   @Override
   public Boolean remove(Long id){
       return employeeDao.deleteByPrimaryKey(id) > 0;
   }


   /**
   *@describe 修改
   *@param employeeDTO
   *@return Boolean
   */
   @Override
   public Boolean modify(EmployeeDTO employeeDTO){
       EmployeeBO employeeBO = LemonBeanUtil.cloneBeanProperties(employeeDTO,EmployeeBO.class);
       return  employeeDao.updateByPrimaryKeySelective(employeeBO) > 0;
   }


    /**
     * 机构树状结构
     * @return
     */
    @Override
    public List<Tree<Long>> tree() {
        List<EmployeeBO> employeeBOS = employeeDao.selectAll();
        if(CollUtil.isEmpty(employeeBOS)){
            return new ArrayList<>();
        }
        return TreeUtil.build(employeeBOS, 0L, new NodeParser<EmployeeBO, Long>() {
            @Override
            public void parse(EmployeeBO employeeBO, Tree<Long> tree) {
                tree.setId(employeeBO.getEmployeeId());
                tree.setParentId(employeeBO.getParentId());
                tree.put(EmployeeBO.Properties.name,employeeBO.getName());
                tree.put(EmployeeBO.Properties.head,employeeBO.getHead());
                tree.put(EmployeeBO.Properties.mobile,employeeBO.getMobile());
                tree.put(EmployeeBO.Properties.mail,employeeBO.getMail());
                tree.put(EmployeeBO.Properties.status,employeeBO.getStatus());
                tree.put(EmployeeBO.Properties.sort,employeeBO.getSort());
                tree.put(EmployeeBO.Properties.createTime,employeeBO.getCreateTime());
            }
        });
    }

}
