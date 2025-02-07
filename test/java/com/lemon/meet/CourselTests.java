package com.lemon.meet;

import cn.hutool.json.JSONUtil;
import com.lemon.meet.entity.bo.CarouselBO;
import com.lemon.meet.entity.bo.CourseBO;
import com.lemon.meet.entity.bo.EmployeeBO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author
 * @version 1.0.0
 * @describe
 * @company lemon
 * @address
 * @updateTime 2024-07-04 12:10
 * @since 2024-07-04 12:10
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourselTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Before
    public void test(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testFindById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/course/id/592426579471437824")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    @Test
    public void testPageList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/course/pageList")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .param("title","测试")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testListAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/course/list")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testAdd() throws Exception {
        EmployeeBO employeeBO = new EmployeeBO();
        employeeBO.setMail("17699266719@q.com");
        employeeBO.setSort(1);
        employeeBO.setName("部门测试");
        employeeBO.setHead("qr");
        employeeBO.setParentId(0L);
        employeeBO.setStatus(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/course/add")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(employeeBO))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/course/remove/596608383380000768")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testModify() throws Exception {
        EmployeeBO employeeBO = new EmployeeBO();
        employeeBO.setEmployeeId(592311283175723008L);
        employeeBO.setMail("17699266719@q.com");
        employeeBO.setSort(1);
        employeeBO.setName("部门测试");
        employeeBO.setHead("qr");
        employeeBO.setParentId(0L);
        employeeBO.setStatus(1);
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/course/modify")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(employeeBO))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
