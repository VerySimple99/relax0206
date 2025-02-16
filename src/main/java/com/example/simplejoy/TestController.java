package com.example.simplejoy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TestService testService;
    @GetMapping("/test")
    public List<Member> getAllMembers(){
        return testService.getAllMembers();
    }
}
