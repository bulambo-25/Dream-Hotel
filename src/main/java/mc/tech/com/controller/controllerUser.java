package mc.tech.com.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.domain.user;
import mc.tech.com.service.entiries.serviceUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("dream-hotel/user/")
public class controllerUser {

        private final serviceUser serviceUser;

        @PostMapping("add")
        public ResponseEntity<user> save(@RequestBody user user1)
        {
            user save=this.serviceUser.save(user1);
            return  ResponseEntity.ok(save);
        }
        @GetMapping("read/{id}")
        public ResponseEntity<user> read(@PathVariable  int id) {
            user read= serviceUser.read(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
            return ResponseEntity.ok(read);
        }

        @GetMapping("findByEmail/{email}")
        public ResponseEntity<user> findByEmail(@PathVariable  String email) {
            user read= this.serviceUser.findByEmail(email);
            return ResponseEntity.ok(read);
        }
       @GetMapping("findByName/{name}")
        public ResponseEntity<user> findByName(@PathVariable  String name) {
        user read= this.serviceUser.findByName(name);
        return ResponseEntity.ok(read);
       }
       @GetMapping("findByName/{number}")
        public ResponseEntity<Boolean> existsByPhoneNumber(@PathVariable  String number) {
        Boolean read= this.serviceUser.existsByPhoneNumber(number);
        return ResponseEntity.ok(read);
        }
        @GetMapping("existsByEmail/{email}")
        public ResponseEntity<Boolean> existsByEmail(@PathVariable  String email) {
        Boolean read= this.serviceUser.existsByEmail(email);
        return ResponseEntity.ok(read);
        }
        @GetMapping("countUser")
        public ResponseEntity<Long> countUser(){
        long numberOfUser= this.serviceUser.countUser();
        return ResponseEntity.ok(numberOfUser);
        }

        @GetMapping("all")
        public ResponseEntity<List<user>> findALL(){

            List<user> addressType= this.serviceUser.findAll();
            return ResponseEntity.ok(addressType);
        }

        @DeleteMapping("delete/{id}")
        public  ResponseEntity<Void> deleteById(@PathVariable int id)
        {
            this.serviceUser.delete(id);

            return  ResponseEntity.noContent().build();
        }}