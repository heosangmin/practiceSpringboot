package dev.mamekun.springboot.api.controller;

import dev.mamekun.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    // @RequestBody와 Map을 활용한 POST API 구현
    /*
    어노테이션을보면 @RequestMapping 대신 @PostMapping을 사용했다.
    이 어노테이션을 사용하면 method 요소를 정의하지 않아도 된다.
    @RequestBody는 HTTP의 body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할을 한다.

    Map 객체는 요청을 통해 어떤 값이 들어올지 특정하기 어려울 때 사용한다.
    */
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    /*
    DTO 객체를 활용한 POST API 구현
     */
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
