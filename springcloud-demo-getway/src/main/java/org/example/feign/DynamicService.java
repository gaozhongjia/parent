package org.example.feign;

import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author gaozhongjia
 */
public interface DynamicService {

    @PostMapping("{url}")
    Object executePostApi(@PathVariable("url") String url, @RequestBody Object params);

    @GetMapping("{url}")
    Object executeGetApi(@PathVariable("url") String url, @SpringQueryMap Object params);
}
