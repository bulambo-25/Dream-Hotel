package mc.tech.com.service.entiries;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.domain.room;
import mc.tech.com.domain.user;
import mc.tech.com.repository.repositoryRoom;
import mc.tech.com.service.implementation.roomImpls;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
@Slf4j
@Transactional
@AllArgsConstructor
public class serviceRoom implements roomImpls {
    private final repositoryRoom roomRepository;
    @Override
    public room save(room room) {

        room room1=this.roomRepository.save(room);
        return room1;
    }

    @Override
    public Optional<room> read(Integer integer) {
        return this.roomRepository.findById(integer);
    }

    @Override
    public void delete(int deleteById) {
        this.roomRepository.deleteById(deleteById);
    }

    @Override
    public room findById(int id) {
        return this.roomRepository.findById(id);
    }

    @Override
    public List<room> findByNumberOfBedAndNumberOfBath(int numberOfBed, int numberOfBath) {
        List<room> roomList=this.roomRepository.findByNumberOfBedAndNumberOfBath(numberOfBed,numberOfBath);
        return roomList;
    }

    @Override
    public room findByNumberOfBed(int numOfBed) {
        return this.roomRepository.findByNumberOfBed(numOfBed);
    }

    @Override
    public room findByNumberOfBath(int numOfbath) {
        room room1=this.roomRepository.findByNumberOfBath(numOfbath);
        return room1;
    }


    @Override
    public List<room> findRoomWhereStatusEqualToStatus(String status) {
        List<room> roomList=this.roomRepository.findRoomWhereStatusEqualToStatus(status);
        return roomList;
    }

    @Override
    public long count() {
        long countAll=this.roomRepository.count();
        return countAll;
    }

    @Override
    public int sumNumberOfBedsByNumberOfBedAndStatusNot(int numberOfBed) {
        int sumOfNumberOfBed=this.roomRepository.sumNumberOfBedsByNumberOfBedAndStatusNot(numberOfBed);
        return sumOfNumberOfBed;
    }

    @Override
    public room findFirstRoomByNumberOfBedAndStatus(int numberOfBed) {
        room room1=this.roomRepository.findFirstRoomByNumberOfBedAndStatus(numberOfBed);
        return room1;

    }
    public List<room> findAll() {
        List<room>  List =this.roomRepository.findAll();
        log.info("List of room are in  ......"+List);
        return List;
    }

}
