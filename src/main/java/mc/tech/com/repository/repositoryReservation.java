package mc.tech.com.repository;


import mc.tech.com.domain.reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface repositoryReservation extends JpaRepository<reservation,Integer> {

    reservation findByReservationID(int id);
    reservation findByRoomNumber(int roomNumber);
    reservation findByCheckInDate(String CheckInDate);
    long count();
}
