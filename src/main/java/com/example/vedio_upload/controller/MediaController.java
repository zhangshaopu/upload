package com.example.vedio_upload.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author zsp
 * @version v 0.1 2022/7/18 16:13
 */
@RestController
@CrossOrigin
public class MediaController {

    String url = "D:\\IdeaProjects\\vedio_upload\\upload\\";

    @Resource
    private MedioHttpRequestHandler medioHttpRequestHandler;

    /**
     * 获取视频
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("video/{filename}")
    public void getPlayResource(HttpServletRequest request, HttpServletResponse response, @PathVariable("filename") String name ) throws Exception {
        System.out.println("getplayresource:");
        Path path = Paths.get(url + name + ".mp4");
        if (Files.exists(path)) {
            String mimeType = Files.probeContentType(path);
            if (!StringUtils.isEmpty(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(MedioHttpRequestHandler.ATTR_FILE, path);
            medioHttpRequestHandler.handleRequest(request, response);
            //System.out.println("test");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }
}

