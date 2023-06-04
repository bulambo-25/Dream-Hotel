package mc.tech.com.service.entiries;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mc.tech.com.domain.reservation;
import mc.tech.com.domain.user;
import mc.tech.com.repository.repositoryUser;
import mc.tech.com.service.implementation.userImpl;
import mc.tech.com.validation.isValid;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@org.springframework.stereotype.Service
@Slf4j
@Transactional
@AllArgsConstructor
public class serviceUser implements userImpl {

    private final repositoryUser userRepository;

    @Override
    public user save(user user)  {

          isValid.isEmptyOrNull(user.getName());
          isValid.IsValidEmail(user.getEmail());
          isValid.checkNumber(user.getPhoneNumber(),user.getPhoneNumber());
          isValid.isEmptyOrNull(user.getAddress());
        user user1=this.userRepository.save(user);
        log.info("saving this controllerUser ......"+user1);
        return user1;
    }

    @Override
    public Optional<user> read(Integer integer) {
        if(integer.equals(null) && integer.equals("")){
            log.info("please check id is empty");
        }
        Optional<user> readingUserById=this.userRepository.findById(integer);
        log.info("find this controllerUser ......"+readingUserById);
        return readingUserById;
    }
    public user updateUser(user user1) {
        user user2=this.userRepository.save(user1);
        log.info("saving this User ......"+user2);
        return user1;
    }

    @Override
    public void delete(int deleteById) {
      log.info("deleting this controllerUser ......"+deleteById);
     this.userRepository.deleteById(deleteById);
    }

    @Override
    public user findById(int id) {
        user findingUserByID=this.userRepository.findById(id);;
        log.info("find this controllerUser ......"+findingUserByID);
        return findingUserByID;
    }

    @Override
    public user findByEmail(String email) {
        user findingUserByEmail=this.userRepository.findByEmail(email);
        log.info("find this controllerUser ......"+findingUserByEmail);
        return findingUserByEmail;
    }

    @Override
    public user findByName(String name) {
        user findingUserByName=this.userRepository.findByName(name);
        log.info("findingByName this controllerUser ......"+findingUserByName);
        return findingUserByName;
    }

    @Override
    public boolean existsByPhoneNumber(String PhoneNumber) {
        isValid.checkNumber(PhoneNumber,PhoneNumber);
        boolean isTrue=this.userRepository.existsByPhoneNumber(PhoneNumber);
        log.info("is the number valid ......"+isTrue);
        return isTrue;
    }

    @Override
    public boolean existsByEmail(String email) {
        boolean existsByEmail =this.userRepository.existsByEmail(email);
        log.info("is the email valid ......"+existsByEmail);
        return existsByEmail;
    }

    @Override
    public long countUser() {
        long countUser =this.userRepository.count();
        log.info("how many controllerUser are in  ......"+countUser);
        return countUser;
    }
    public List<user> findAll() {
        List<user>  List =this.userRepository.findAll();
        log.info("List of User are in  ......"+List);
        return List;
    }
}