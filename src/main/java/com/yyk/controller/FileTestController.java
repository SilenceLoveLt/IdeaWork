package com.yyk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file/")
public class FileTestController {

    @RequestMapping("show")
    public  String show(){
        return "fileTest";
    }

    @RequestMapping("fileUpload")
    public String fileUpload(@RequestParam(value="file")MultipartFile file, Model model, HttpServletRequest request){
        if(file.isEmpty()){
            return "文件为空";
        }

        String fileName = file.getOriginalFilename();  // 文件名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "C://temp-rainy//"; // 上传后的路径
       // fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);
        return "fileTest";
    }
}
