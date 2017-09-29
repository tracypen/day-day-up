package com.hp.up.backend.controller;

import com.sun.deploy.net.URLEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * springMvc file upload And download
 * com.hp.up.backend.controller
 * Created by haopeng on 2017/9/29  22:01.
 */
public class FileUploadController extends BaseController{

    /**
     *  single file upload
     */
    @RequestMapping("/upload")
    @ResponseBody
    public ResponseEntity singleFile(@RequestParam MultipartFile file, HttpServletRequest request){
        try{
            String path = request.getSession().getServletContext().getRealPath("upload");
            String fileName = file.getOriginalFilename();
            File dir = new File(path,fileName);
            if(!dir.exists()){
                dir.mkdirs();
            }
            //MultipartFile自带的解析方法
            file.transferTo(dir);

        }catch(Exception e){
            e.printStackTrace();
            return super.getJsonResponseEntity(Boolean.FALSE);
        }
        return super.getJsonResponseEntity(Boolean.TRUE);
    }

    /**
     * multi-file upload
     */
    @RequestMapping("/multi_upload")
    @ResponseBody
    public ResponseEntity multiFile(@RequestParam MultipartFile[] files,HttpServletRequest request){
        try{
            if(files!=null&&files.length>0){
                //循环获取file数组中得文件
                for(int i = 0;i<files.length;i++){
                    MultipartFile file = files[i];
                    if(file.getSize()==0){
                        continue;
                    }
                    //保存文件
                    String filename=file.getOriginalFilename();
                    String targetDir=request.getSession().getServletContext().getRealPath("upload");
                    File targetfile=new File(targetDir,filename);
                    file.transferTo(targetfile);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            return super.getJsonResponseEntity(Boolean.FALSE);
        }
        return super.getJsonResponseEntity(Boolean.TRUE);
    }


    /**
     * file download
     */
    @RequestMapping("/download")
    public void down(HttpServletRequest request,HttpServletResponse response,String fileName) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String fileFullName = request.getSession().getServletContext().getRealPath("upload")+"/"+ fileName;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileFullName)));
        //假如以中文名下载的话
        String filename = "下载文件.txt";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }


}
