package dev.mamekun.springboot.api.controller;

import dev.mamekun.springboot.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
// 클래스 수준에서 RequestMapping을 설정하면
// 내부에 선언한 메서드의 URL 리소스 앞에 RequestMapping의 값이 공통 값으로 추가된다.
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("메서드 호출됨");
        return "Hello World";
    }

    // 매개변수 없는 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        LOGGER.info("메서드 호출됨?");
        return "My name";
    }

    // @PathVariable을 활용한 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    // @PathVariable에 변수명을 매핑하는 방법
    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // @RequestParam을 활용한 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request1")
//    public String getRequestParam1(
//            @RequestParam String name,
//            @RequestParam String email,
//            @RequestParam String organization
//    ) {
//        return name + " " + email + " " + organization;
//    }
    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET method")
    // @ApiOperation: 대상 API의 설명을 작성하기 위한 어노테이션
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "회사", required = true) @RequestParam String organization
            // @ApiParam: 매개변수에 대한 설명 및 설정을 위한 어노테이션.
            // 메서드의 매개변수뿐 아니라 DTO 객체를 매개변수로 사용할 경우 DTO 클래스 내의 매개변수에도 정의할 수 있음.
    ) {
        return name + " " + email + " " + organization;
    }

    // @RequestParam과 map을 조합한 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/request2?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // DTO 객체를 활용한 GET 메서드 구현
    // http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto) {
        return memberDto.toString();
    }
}
