package com.example.vedio_upload.controller;

import com.example.vedio_upload.service.IProcessService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
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
        String originname = (String) params.get("fileName");
        String aftername = originname.substring(0,originname.indexOf(".")) + "_proced";

        //String processedUrl = processService.ProcessAlgorithm((String) params.get("url"),aftername,req);
        String processedUrl = "http://" + req.getServerName() + ":" + req.getServerPort() + "/video/" + aftername;

        //返回文件类型，url
        result.put("type","mp4");
        result.put("ProcessedUrl",processedUrl);
        result.put("name",aftername);
        return result ;
    }
}
