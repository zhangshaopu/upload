package com.example.vedio_upload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zsp
 * @version v 0.1 2022/7/11 17:27
 */

@RestController
@CrossOrigin
public class VedioUploadController  {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");

    @PostMapping("upload")
    public Map<String,Object> fillupload(MultipartFile file, HttpServletRequest req){
        System.out.println("getvideo:");
        Map<String,Object> result = new HashMap<>();
        String format = sdf.format(new Date());
        String realPath = "D:/IdeaProjects/vedio_upload/upload" ; // 存储文件夹路径
        //String realPath = req.getServletContext().getRealPath("/") + format;
        File folder = new File(realPath);
        if(!folder.exists()){ // 如果文件夹不存在，创建文件夹
            folder.mkdirs();
        }
        System.out.println(realPath);
        String oldName = file.getOriginalFilename();
        System.out.println("oldName:"+ oldName);
//        if(!oldName.endsWith(".mp4")){
//            result.put("status","error");
//            result.put("msg","文件类型不对");
//            return result;
//        }
        //String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        //String newName = oldName.substring(oldName.lastIndexOf("."));
        //System.out.println("newName:" + newName);
        try {
            file.transferTo(new File(folder,oldName));
            //String url = "/upload" + format + newName;
            String url = req.getScheme() + "://" +
                    req.getServerName() + ":"
                    + req.getServerPort()
                    + "/upload/" + oldName;
            System.out.println("url:" + url);
            //返回状态，文件名字，文件url
            result.put("status","OK");
            result.put("name",oldName);
            result.put("url",url);
        } catch (IOException e) {
            result.put("status","ERROR");
            result.put("msg",e.getMessage());
        }


        return result;
    }
}
