package com.lemon.meet;

import cn.hutool.json.JSONUtil;
import com.lemon.meet.entity.bo.UserBO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

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
public class UserTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Before
    public void test(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testFindById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/id/592392652879106048")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    @Test
    public void testPageList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/pageList")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .param("userName","柠檬")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testListAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/list")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testAdd() throws Exception {
        UserBO userBO = new UserBO();
        userBO.setUserName("小爱同学");
        userBO.setName("小爱同学");
        userBO.setPassword("123456");
        userBO.setRole("1");
        userBO.setMobile("17688922672");
        userBO.setMail("1760216019@qq.com");
        userBO.setEmployeeId(1L);
        userBO.setSex(1);
        userBO.setStatus(1);
        userBO.setStation("经理");
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/user/add")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(userBO))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/user/remove/592361155601567744")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testModify() throws Exception {
        UserBO userBO = new UserBO();
        userBO.setUserId(595328948822773760L);
        userBO.setUserName("小爱同学");
        userBO.setName("小爱同学");
        userBO.setPassword("123456");
        userBO.setRole("1");
        userBO.setMobile("17688922672");
        userBO.setMail("1760216019@qq.com");
        userBO.setEmployeeId(1L);
        userBO.setSex(1);
        userBO.setStatus(1);
        userBO.setStation("经理");
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/user/modify")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(userBO))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/user/login")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(new HashMap<String,String>(){{
                            put("name","小爱同学");
                            put("password","123456");
                        }}))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


}
