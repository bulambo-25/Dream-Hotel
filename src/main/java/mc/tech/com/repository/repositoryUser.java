package mc.tech.com.repository;

import mc.tech.com.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositoryUser  extends JpaRepository<user,Integer> {
    user findById(int id);
    user findByEmail(String email);
    user findByName(String CustomerName);
    boolean existsByPhoneNumber(String PhoneNumber);
    boolean existsByEmail(String email);
    long count();

}
