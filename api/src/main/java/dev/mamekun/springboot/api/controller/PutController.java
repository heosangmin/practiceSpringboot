package dev.mamekun.springboot.api.controller;

import dev.mamekun.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    /*
    5.4.1 @RequestBody를 활용한 PUT 메서드 구현
    */

    // @RequestBody와 Map을 활용한 PUT 메서드 구현
    // http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 PUT 메서드 구현
    // http://localhost:8080/api/v1/put-api/member1
    // response headers 영역의 Content-Type항목이 text/plain
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    // http://localhost:8080/api/v1/put-api/member2
    // DTO 객체를 그대로 반환하면
    // response headers 영역의 Content-Type항목이 application/json
    // 즉, @RestController 어노테이션이 지정된 클래스는 @ResponseBody를 생략할 수 있는데,
    // 이 @ResponseBody 어노테이션은 자동으로 값을 JSON과 같은 형식으로 변환해서 전달하는 역할을 수행한다.
    @PutMapping(value = "/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    /*
    5.4.2 ResponseEntity를 활용한 PUT 메서드 구현

    스프링 프레임워크에는 HttpEntity라는 클래스가 있다.
    HttpEntity는 헤더(Header)와 Body로 구성된 HTTP 요청과 응답을 구성하는 역할을 수행한다.
    RequestEntity와 ResponseEntity는 httpEntity를 상속받아 구현한 클래스이다.
    그중 ReponseEntity는 HttpEntity로부터 HttpHeaders와 Body를 가지고 자체적으로 HttpStatus를 구현한다.
     */
    // ResponseEntity를 활용한 PUT 메서드 구현
    // http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }
}
