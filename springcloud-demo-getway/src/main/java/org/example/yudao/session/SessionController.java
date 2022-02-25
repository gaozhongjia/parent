package org.example.yudao.session;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
@Api(tags = "用户 API 接口")
public class SessionController {

    @GetMapping("/set")
    @ApiOperation(value = "设置session", notes = "目前仅仅是作为测试")
    public void set(HttpSession session,
                    @RequestParam("key") String key,
                    @RequestParam("value") String value) {
        session.setAttribute(key, value);
    }

    @GetMapping("/get_all")
    @ApiOperation("获得session信息")
    public Map<String, Object> getAll(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        // 遍历
        for (Enumeration<String> enumeration = session.getAttributeNames();
             enumeration.hasMoreElements();) {
            String key = enumeration.nextElement();
            Object value = session.getAttribute(key);
            result.put(key, value);
        }
        // 返回
        return result;
    }

}