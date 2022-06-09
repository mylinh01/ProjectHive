package com.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadDownloadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadDownloadController.class);
    static List<String[]> data1;
    static List<String[]> data2;
    static List<String[]> data3;
    public UploadDownloadController() {
    }

    @GetMapping({"/download/{fileName:.+}"})
    public ResponseEntity downloadFileFromLocal(@PathVariable String fileName) {
        ClassPathResource resource = null;

        try {
            logger.info("DownloadFile: {}", fileName);
            resource = new ClassPathResource("classpath:data/" + fileName);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return ((BodyBuilder)ResponseEntity.ok().header("Content-Disposition", new String[]{"attachment; filename=\"" + resource.getFilename() + "\""})).body(resource);
    }



    @GetMapping({"/data1"})
    public List<String[]> getData() {
        return data1;
    }
    @PostMapping({"/upload1"})
    public void upload(@RequestParam MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            List<String[]> arrList = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) {
                String[] map = line.split("\t");
                arrList.add(map);
            }


            StringBuilder salesData = new StringBuilder();
            bufferedReader.close();
            data1 = arrList;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

    }

    @GetMapping({"/data2"})
    public List<String[]> getData2() {
        return data2;
    }
    @PostMapping({"/upload2"})
    public void upload2(@RequestParam MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            List<String[]> arrList = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) {
                String[] map = line.split("\t");
                arrList.add(map);
            }


            StringBuilder salesData = new StringBuilder();
            bufferedReader.close();
            data2 = arrList;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

    }

    @GetMapping({"/data3"})
    public List<String[]> getData3() {
        return data3;
    }
    @PostMapping({"/upload3"})
    public void upload3(@RequestParam MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            List<String[]> arrList = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) {
                String[] map = line.split("\t");
                arrList.add(map);
            }


            StringBuilder salesData = new StringBuilder();
            bufferedReader.close();
            data3 = arrList;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

    }

}
