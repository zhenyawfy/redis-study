package cn.abel.queue.controller;

import cn.abel.queue.service.StringTypeOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stringType")
public class StringTypeOpController {
    @Autowired
    private StringTypeOpService stringTypeOpService;

    @RequestMapping(value = "{keyValue}", method = RequestMethod.GET)
    public void setKeyValue(@PathVariable("keyValue") String keyValue) {
        String[] split = keyValue.split("_");
        stringTypeOpService.setValue(split[0], split[1]);
    }

    @RequestMapping(value = "/getKeyValue/{keyName}", method = RequestMethod.GET)
    public String getKeyValue(@PathVariable("keyName") String keyName) {
        stringTypeOpService.setIncrValue(keyName + ".vew.num");
        return "内容： " + stringTypeOpService.getValue(keyName) + "  访问次数：" + stringTypeOpService.getValue(keyName + ".vew.num");
    }
}
