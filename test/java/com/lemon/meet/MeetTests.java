package com.lemon.meet;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.lemon.meet.entity.bo.MeetBO;
import com.lemon.meet.entity.bo.UserBO;
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
public class MeetTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Before
    public void test(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void testFindById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/meet/id/592426579471437824")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



    @Test
    public void testPageList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/meet/pageList")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .param("title","会议")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testListAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/meet/list")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testAdd() throws Exception {
        MeetBO meetBO = new MeetBO();
        meetBO.setTitle("会议测试");
        meetBO.setType("会议类型");
        meetBO.setImage("[]");
        meetBO.setDetail("会议详情");
        meetBO.setCreator("创建人");
        meetBO.setCreateTime(DateUtil.date());
        meetBO.setEndTime(DateUtil.date());
        meetBO.setTravelModel("北京站");
        meetBO.setTenantId(1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/admin/meet/add")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(meetBO))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testRemove() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/meet/remove/596608383380000768")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void testModify() throws Exception {
        MeetBO meetBO = new MeetBO();
        meetBO.setMeetId(592426579471437824L);
        meetBO.setTitle("会议测试");
        meetBO.setType("会议类型");
        meetBO.setImage("[]");
        meetBO.setDetail("会议详情");
        meetBO.setCreator("创建人");
        meetBO.setCreateTime(DateUtil.date());
        meetBO.setEndTime(DateUtil.date());
        meetBO.setTravelModel("北京站");
        meetBO.setTenantId(1L);
        mockMvc.perform(MockMvcRequestBuilders.put("/admin/meet/modify")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .header("Authorization","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0ZW5hbnRJZCI6IjU5MjM5MjY0OTExNjgxNTM2MCIsInVzZXJJZCI6IjU5MjM5MjY1Mjg3OTEwNjA0OCIsImlhdCI6MTcyMDA5MjQ4MX0.QGIaxO-ymJXtehYa70X3WZZ8T1-kGWLPJrqsrerOBLM")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONUtil.toJsonStr(meetBO))
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }



}
