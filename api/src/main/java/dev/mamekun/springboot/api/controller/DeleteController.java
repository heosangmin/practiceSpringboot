package dev.mamekun.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    /*
    5.5.1 @PathVariable과 @RequestParam을 활용한 DELETE 메서드 구현
    */
    // http://localhost:8080/api/v1/delete-api/{String 값}
    @DeleteMapping(value = "/{variable}")
    public String deleteVariable(@PathVariable String variable) {
        // @DeleteMapping에 정의한 value의 이름과 메서드의 매개변수 이름을 동일하게 설정해야 삭제할 값이 주입된다.
        return "delete variable : " + variable;
    }

    // 또는 @RequestParam 어노테이션을 통해 쿼리스트링 값도 받을 수 있다.

    // http://localhost:8080/api/v1/delete-api/request1?email=value
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email) {
        return "email : " + email;
    }
}
