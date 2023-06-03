package mc.tech.com.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@ToString
public class reservation {
    @Id
    @SequenceGenerator(name = "userAccount", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 23, initialValue = 9982)
    @GeneratedValue(strategy = SEQUENCE, generator = "userAccount")
    private int reservationID;
    @NonNull
    private String email;
    @NonNull
    private String checkInDate;
    @NonNull
    private String checkOutDate;
    @NonNull
    private LocalDate createdDate;
    private String modifierDate;
    @NonNull
    private int roomNumber;
    @NonNull
    private int userID;
    @NonNull
    private int numberOfBed;

    public reservation(@NonNull String email, @NonNull String checkInDate, @NonNull String checkOutDate, @NonNull LocalDate createdDate, String modifierDate, @NonNull int roomNumber, @NonNull int userID, @NonNull int numberOfBed, @NonNull String specialRequest) {
        this.email = email;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.createdDate = createdDate;
        this.modifierDate = modifierDate;
        this.roomNumber = roomNumber;
        this.userID = userID;
        this.numberOfBed = numberOfBed;
        this.specialRequest = specialRequest;
    }

    @NonNull
    private String specialRequest;


    public reservation() {

    }
}
