package mc.tech.com.service.entiries;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.domain.reservation;
import mc.tech.com.domain.room;
import mc.tech.com.domain.user;
import mc.tech.com.repository.repositoryReservation;
import mc.tech.com.service.implementation.reservationImpl;
import mc.tech.com.validation.isValid;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
@Slf4j
@Transactional
@AllArgsConstructor
public class serviceReservation implements reservationImpl {

    private final repositoryReservation reservationRepository;
    private final serviceUser serviceUser;
    private final serviceRoom serviceRoom;
    @Override
    public reservation save(reservation reservation){
        isValid.isEmptyOrNull(reservation.getCheckInDate());
        isValid.isEmptyOrNull(reservation.getCheckOutDate());
        isValid.IsValidEmail(reservation.getEmail());
        this.serviceUser.existsByEmail(reservation.getEmail());
        user user1=this.serviceUser.findByEmail(reservation.getEmail());
        LocalDate currentDate = LocalDate.now();
        int numberOfBedsAvailable = serviceRoom.sumNumberOfBedsByNumberOfBedAndStatusNot(reservation.getNumberOfBed());
        if (numberOfBedsAvailable == 0) {
            log.error("The room with numberOfBed " + reservation.getNumberOfBed() + " is full.");
        }
        room room1=this.serviceRoom.findFirstRoomByNumberOfBedAndStatus(reservation.getNumberOfBed());
        reservation reservation1=new reservation(reservation.getEmail(),reservation.getCheckInDate(),reservation.getCheckOutDate(),
        currentDate,"",room1.getRoomNumber(),user1.getId(),reservation.getNumberOfBed(),
                reservation.getSpecialRequest());
        reservation reservation2= this.reservationRepository.save(reservation1);
        return reservation2;
    }

    @Override
    public Optional<reservation> read(Integer integer) {
        return this.reservationRepository.findById(integer);
    }

    @Override
    public void delete(int deleteById) {

         this.reservationRepository.deleteById(deleteById);
    }

    @Override
    public reservation findByReservationID(int id) {
        reservation reservation=this.reservationRepository.findByReservationID(id);
        return reservation;
    }


    @Override
    public reservation findByRoomNumber(int roomNumber) {
        reservation reservation =this.reservationRepository.findByRoomNumber(roomNumber);
        return reservation;
    }

    @Override
    public reservation findByCheckInDate(String CheckInDate) {
        reservation reservation =this.reservationRepository.findByCheckInDate(CheckInDate);
        return reservation;
    }

    @Override
    public long count() {
        long count =this.reservationRepository.count();
        return count;
    }
}
