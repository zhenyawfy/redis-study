package cn.abel.queue.controller;

import cn.abel.queue.service.HashTypeOpService;
import cn.abel.queue.service.StringTypeOpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/hashType")
public class HashTypeOpController {
    @Autowired
    private HashTypeOpService hashTypeOpService;
    @Autowired
    private StringTypeOpService stringTypeOpService;

    @RequestMapping(value = "{keyValue}", method = RequestMethod.GET)
    public void setKeyValue(@PathVariable("keyValue") String keyValue) {
        String[] split = keyValue.split("_");
        hashTypeOpService.hSet(split[0], split[1], split[2]);
    }

    @RequestMapping(value = "/getKeyValue/{keyName}", method = RequestMethod.GET)
    public Map<Object, Object> getKeyValue(@PathVariable("keyName") String keyName) {
        stringTypeOpService.setIncrValue(keyName + ".vew.num");
        Map<Object, Object> objectObjectMap = hashTypeOpService.hValues(keyName);
        objectObjectMap.put("num", stringTypeOpService.getValue(keyName + ".vew.num"));
        return objectObjectMap;
    }
}
