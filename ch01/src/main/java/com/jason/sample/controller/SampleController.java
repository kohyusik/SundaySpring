package com.jason.sample.controller;

import com.jason.sample.domain.SampleDTO;
import com.jason.sample.domain.SampleDTOList;
import com.jason.sample.domain.TodoDTO;
import com.jason.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Name;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {

    final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    // domain class
    @RequestMapping("/json")
    @ResponseBody
    public SampleDTO json(SampleDTO user) {

        log.info("SampleDTO : {}", user);
        return user;
    }

    // string
    @RequestMapping("/string")
    @ResponseBody
    public String string(String str) {

        log.info("String : {}", str);

        return str;
    }

    // @RequestParam
    @RequestMapping("/ex02")
    @ResponseBody
    public String ex02(
            String name,
            Integer age) {

        log.info("name : {}", name);
        log.info("age : {}", age);

        return "asfas";
    }

    // List collection
    @GetMapping("/ex02List")
    @ResponseBody
    public List ex02List(
            @RequestParam("ids") ArrayList<String> ids) {

        log.info("param array : {}", ids);

        return ids;
    }

    // array
    @GetMapping("/ex02Array")
    @ResponseBody
    public int[] ex02Array(
            @RequestParam("ids") int[] ids) {

        log.info("param array : {}", Arrays.toString(ids));

        return ids;
    }

    // VO array
    // http://localhost:8081/sample/ex02Beans?list[0].name=first&list[1].name=2nd&list[0].age=19&list[3].age=19
    @GetMapping("/ex02Beans")
    @ResponseBody
    public List<SampleDTO> ex02Beans(
            SampleDTOList list) {

        log.info("param list : {}", list.getList());

        return list.getList();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        log.info("Init Binder!!");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

    }

    // date format
    @GetMapping("/ex03")
    @ResponseBody
    public TodoDTO ex03(
            TodoDTO todo) {

        log.info("To do : {}", todo);

        return todo;
    }

    // model
    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("serverTime", new Date());
        log.info("model : {}", model.asMap());

        return "sample/home";
    }

    // java bean은 자동으로 전달 (SampleDTO)
    @GetMapping("/ex04")
    public String ex04(SampleDTO sampleDTO, @ModelAttribute("page") int page) {

        log.info("SampleDTO : {}", sampleDTO);
        log.info("page : {}", page);

        return "sample/ex04";
    }

    // redirect
    @GetMapping("/redirect")
    public String redirect(SampleDTO sampleDTO, @ModelAttribute("page") int page) {

        log.info("SampleDTO : {}", sampleDTO);
        log.info("page : {}", page);

        return "redirect:/sample/ex04";
    }

    // json
    @GetMapping("/json2")
    public SampleDTO json2(SampleDTO sampleDTO, @ModelAttribute("page") int page) {

        log.info("SampleDTO : {}", sampleDTO);
        log.info("page : {}", page); // model.addAttribute("page", page);

        return sampleDTO;
    }

    // entity
    @GetMapping("/entity")
    public ResponseEntity<String> entity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Test-Header", "test header value");
        log.info("header : {}", headers);

        return new ResponseEntity<>("test body value", headers, HttpStatus.OK);
    }

    // file upload jsp
    @GetMapping("/exUpload")
    public void exUpload() {
    }

    // file upload
    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {

        files.forEach(f -> {
            log.info("file size : {}", f.getSize());
            log.info("file name : {}", f.getOriginalFilename());
            getName(f.getOriginalFilename(), name -> UUID.randomUUID().toString() + name);
        });
    }

    public String getName(String name, NameConverter converter) {
        return converter.convert(name);
    }

    // error
    @GetMapping("/errorTest")
    @ResponseBody
    public String errorTest() {

        String testNull = null;
        testNull.hashCode();
        try {

            testNull.hashCode();

        } catch (Exception e) {

            log.error("error catch : {}", e.getMessage());
        }

        return "home";
    }

    // call service
    @GetMapping("/service")
    @ResponseBody
    public SampleDTO callService() {

        return sampleService.findAll();
    }

}
