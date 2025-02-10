package com.example.simplejoy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest //테스트용 어플리케이션 컨텍스트 생성
@AutoConfigureMockMvc //MockMvc 생성
class TestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Autowired
    MemberRepository memberRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메서드
    void mockMvcSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @AfterEach // 테스트 후 실행하는 메서드
    void cleanup() {
        this.memberRepository.deleteAll();
    }

    @Test
    void getAllMembers() {
        //given
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1l,"손흥민"));
        //when
        try {
            final ResultActions resultActions=mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));
            //then
            resultActions
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                    .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}