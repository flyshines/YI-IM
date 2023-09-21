package com.itic.im.demo.controller;

import com.itic.im.core.model.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * TODO
 *
 * @author wanli.yang
 * @version 1.0
 * @date 2022/1/13 10:18
 */
@Controller
public class ChatRoomController {


    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(HttpSession session, @RequestBody Map<String, Object> param) {

        return Result.ok();
    }

}
