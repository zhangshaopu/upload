package com.example.vedio_upload.controller;

import com.example.vedio_upload.service.IProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zsp
 * @version v 0.1 2022/7/12 20:28
 */

@RestController
@CrossOrigin
public class ProcessController {
    @Autowired
    private IProcessService processService;

    @PostMapping("process")
    public Map<String,Object> process(@RequestBody Map params, HttpServletRequest req){
        Map<String,Object> result = new HashMap<>();
        //收到确认信息，文件url , 文件名
        System.out.println("收到post请求：" + params.get("context") + " " + params.get("url") + " " + params.get("fileName"));
        //将url传给处理函数
        String processedUrl = processService.ProcessAlgorithm((String) params.get("url"),(String) params.get("fileName"),req);


        //返回文件类型，url
        String name = params.get("fileName") + "_proced";
        result.put("type","mp4");
        result.put("ProcessedUrl",processedUrl);
        result.put("name",name);
        return result ;
    }
}
