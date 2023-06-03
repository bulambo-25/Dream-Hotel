package mc.tech.com.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.domain.room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@Controller
@RequiredArgsConstructor
@RequestMapping("dream-hotel/room/")
public class controllerRoom {

    private final mc.tech.com.service.entiries.serviceRoom room;

    @PostMapping("save")
    public ResponseEntity<room> save(@RequestBody room room1)
    {
        room save=this.room.save(room1);
        return  ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Optional<room>> read(@PathVariable  int id) {
        Optional<room> roomOptional = Optional.ofNullable(room.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResponseEntity.ok(roomOptional);
    }
    @GetMapping("findById/{id}")
    public ResponseEntity<room> findById(@PathVariable  int id) {
        room roomOptional =this.room.findById(id);
        return ResponseEntity.ok(roomOptional);
    }

    @GetMapping("getByNumberOfBedAndNumberOfBath/{numberOfBed}")
    public ResponseEntity<List<room>> findByNumberOfBedAndNumberOfBath(@PathVariable  int numberOfBed,@PathVariable  int numberOfBath) {
        List<room> read= this.room.findByNumberOfBedAndNumberOfBath(numberOfBed,numberOfBath);
        return ResponseEntity.ok(read);
    }
    @GetMapping("findByNumberOfBed/{numOfBed}")
    public ResponseEntity<room> findByNumberOfBed(@PathVariable  int numOfBed) {
        room read= this.room.findByNumberOfBed(numOfBed);
        return ResponseEntity.ok(read);
    }
    @GetMapping("findByNumberOfBath/{numberOfBath}")
    public ResponseEntity<room> findByNumberOfBath(@PathVariable  int numberOfBath) {
        room read= this.room.findByNumberOfBed(numberOfBath);
        return ResponseEntity.ok(read);
    }
    @GetMapping("findRoomWhereStatusEqualToStatus/{status}")
    public ResponseEntity<List<room>> findRoomWhereStatusEqualToStatus(@PathVariable String status) {
        List<room> roomList= this.room.findRoomWhereStatusEqualToStatus(status);
        return ResponseEntity.ok(roomList);
    }
    @GetMapping("countUser/{numberOfBed}")
    public ResponseEntity<Integer> sumNumberOfBedsByNumberOfBedAndStatusNot(@PathVariable int numberOfBed){
        int numberOfRoom= this.room.sumNumberOfBedsByNumberOfBedAndStatusNot(numberOfBed);
        return ResponseEntity.ok(numberOfRoom);
    }
    @GetMapping("FirstRoomByNumber/{numberOfBed}")
    public ResponseEntity<room>findFirstRoomByNumberOfBedAndStatus(@PathVariable int numberOfBed) {
        room read= this.room.findByNumberOfBed(numberOfBed);
        return ResponseEntity.ok(read);
    }
    @GetMapping("countUser")
    public ResponseEntity<Long> countUser(){
        long numberOfRoom= this.room.count();
        return ResponseEntity.ok(numberOfRoom);
    }

    @GetMapping("all")
    public ResponseEntity<List<room>> findALL(){

        List<room>  roomList= this.room.findAll();
        return ResponseEntity.ok(roomList);
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void> deleteById(@PathVariable int id)
    {
        this.room.delete(id);

        return  ResponseEntity.noContent().build();
    }
}
