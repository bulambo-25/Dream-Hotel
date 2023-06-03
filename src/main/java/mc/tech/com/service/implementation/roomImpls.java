package mc.tech.com.service.implementation;

import mc.tech.com.domain.room;
import mc.tech.com.domain.user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface roomImpls  extends IService<room,Integer> {
    room findById(int id);
    List<room> findByNumberOfBedAndNumberOfBath(int numberOfBed, int numberOfBath);
    room findByNumberOfBed(int numOfBed);
    room findByNumberOfBath(int numOfBed);
    List<room> findRoomWhereStatusEqualToStatus(String status);
    long count();
    int sumNumberOfBedsByNumberOfBedAndStatusNot(int numberOfBed);
    room findFirstRoomByNumberOfBedAndStatus(int numberOfBed);
}

