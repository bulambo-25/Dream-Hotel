package mc.tech.com.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.SEQUENCE;
@Entity
@Setter
@Getter
@ToString
public class room {
    @Id
    @SequenceGenerator(name = "userAccount", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 17, initialValue = 23082)
    @GeneratedValue(strategy = SEQUENCE, generator = "userAccount")
    private int roomId;
    @NonNull
    private int  numberOfBed;
    @NonNull
    private int numberOfBath;
    @NonNull
    private String Wifi;
    @NonNull
    private String description;
    @SequenceGenerator(name = "roomNumber", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 1, initialValue = 0002)
    @GeneratedValue(strategy = SEQUENCE, generator = "roomNumber")
    @NonNull
    private int roomNumber;
    @NonNull
    private int numberOfAdult;
    @NonNull
    private int numberOfChild;
    @Column( columnDefinition="LONGBLOB")
    @Lob
    private String roomPhoto1;
    @NonNull
    private String status;
    @NonNull
    private double price;
    @NonNull
    private int rate;
}
