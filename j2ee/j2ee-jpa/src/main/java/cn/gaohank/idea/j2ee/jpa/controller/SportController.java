package cn.gaohank.idea.j2ee.jpa.controller;

import cn.gaohank.idea.j2ee.jpa.service.SportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "sport api")
@RequestMapping("sport")
public class SportController {
    @Autowired
    private SportService sportService;

    @ApiOperation("获得比赛选手信息")
    @GetMapping("players")
    public String getPlayers(@RequestParam("id")int id) {
        sportService.logPlayersData(id);
        return "success";
    }

    @ApiOperation("获得选手信息")
    @GetMapping(value = "info/{id}")
    public String getInfo(@PathVariable("id")int id) {
        sportService.logPlayersData(id);
        return "info-success";
    }

    @ApiOperation("获得队员名称")
    @GetMapping("name/{id}")
    public String getName(@PathVariable("id")int id) {
        return sportService.getName(id);
    }
}
