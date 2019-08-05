package cn.gaohank.idea.j2ee.es.controller;

import cn.gaohank.idea.j2ee.es.service.EsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class EsController {
    @Autowired
    private EsService esService;

    @ApiOperation(value = "测试es")
    @GetMapping("/test")
    public String searchEntityes(@RequestParam("query") String query) {
        try {
            return "es result is : " + esService.search(query, "1_4").get(0);
        } catch (Exception e) {
            return "has exception";
        }
    }
}
