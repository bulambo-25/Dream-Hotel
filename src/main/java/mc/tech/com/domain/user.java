package mc.tech.com.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@ToString
public class user {

    @Id
    @SequenceGenerator(name = "userAccount", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 13, initialValue = 2080)
    @GeneratedValue(strategy = SEQUENCE, generator = "userAccount")
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String password;

    public user(@NonNull String name, @NonNull String email, @NonNull String phoneNumber, @NonNull String password, @NonNull String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
    }

    @NonNull
    private String address;

    public user() {

    }
}
