package mc.tech.com.repository;

import mc.tech.com.domain.room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface repositoryRoom extends JpaRepository<room,Integer> {
    room findById(int id);
    List<room> findByNumberOfBedAndNumberOfBath(int numberOfBed, int numberOfBath);
    room findByNumberOfBed(int numOfBed);
    @Query("SELECT SUM(r.numberOfBed) FROM room r WHERE r.numberOfBed = :numberOfBed AND r.status != 'book'")
    int sumNumberOfBedsByNumberOfBedAndStatusNot(int numberOfBed);
    room findByNumberOfBath(int numOfBed);
    @Query("SELECT r FROM room r WHERE r.status = :status")
    List<room> findRoomWhereStatusEqualToStatus(@Param("status") String status);
    long count();
    @Query("SELECT r FROM room r WHERE r.numberOfBed = :numberOfBed AND r.status = 'book' ORDER BY r.roomId ASC")
    room findFirstRoomByNumberOfBedAndStatus(int numberOfBed);
}
