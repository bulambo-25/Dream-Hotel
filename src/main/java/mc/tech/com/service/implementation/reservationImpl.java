package mc.tech.com.service.implementation;

import mc.tech.com.domain.reservation;


import java.util.List;

public interface reservationImpl  extends IService<reservation,Integer> {
    reservation findByReservationID(int id);
    reservation findByRoomNumber(int roomNumber);
    reservation findByCheckInDate(String CheckInDate);
    long count();
}
