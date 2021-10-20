package com.example.LeaveManagement.controller;

import com.example.LeaveManagement.model.UserDetails;
import com.example.LeaveManagement.repository.UserRepository;

import com.example.LeaveManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    UserService service;

    @Autowired
    UserRepository repo;
    @GetMapping("/value/{id}")
    public Optional<UserDetails> getByid(@PathVariable int id) {
        Optional<UserDetails> re = service.findById(id);
        return re;
    }

    @GetMapping("/{name}")
    public Optional<UserDetails> getByname(@PathVariable String name) {
        Optional<UserDetails> res = service.findByName(name);
        return res;
    }

    @GetMapping("/reports/{name}")
    public List<UserDetails> getByReports(@PathVariable String name) {
        List<UserDetails> ress = service.findByreportsTo(name);
        return ress;
    }

    @GetMapping("/tutorials")
    public List<UserDetails> getAllreportsTo(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {


            List<UserDetails> tutorials = new ArrayList<UserDetails>();
            Pageable paging = PageRequest.of(page,size,Sort.by("name").ascending());

            Page<UserDetails> pageTuts;
            if (title == null)
                pageTuts = (Page<UserDetails>) repo.findAll();
            else
                pageTuts = repo.findByreportsTo(title, paging);

            tutorials = pageTuts.getContent();
             return tutorials;




    }

    @PostMapping("/add")
    public ResponseEntity<UserDetails> createTutorial(@RequestBody UserDetails tutorial) {
        try {
            UserDetails _tutorial = repo.save(tutorial);
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   @GetMapping("/v1/report")
    public ByteArrayDataSource reportdownload() throws IOException {
       try {
           List<UserDetails> all = repo.findAll();
           ByteArrayDataSource data = service.EmployeeReport(all);
           return data;
       } catch (Exception e) {
           System.out.println(e);
       }
       return null;
   }
}

