package mc.tech.com.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Setter
@Getter
@ToString
public class hotel {
    @Id
    @SequenceGenerator(name = "userAccount", sequenceName = "ORACLE_DB_SEQ_ID",
            allocationSize = 23, initialValue = 82)
    @GeneratedValue(strategy = SEQUENCE, generator = "userAccount")
    private int ID;
    private String name;
    private String email;
    private String mobile;

    public hotel(String name, String email, String mobile, String address) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    private String address;

    public hotel() {
        
    }
}
