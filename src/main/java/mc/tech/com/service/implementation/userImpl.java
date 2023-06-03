package mc.tech.com.service.implementation;

import mc.tech.com.domain.user;

public interface userImpl extends IService<user,Integer> {

    user findById(int id);
    user findByEmail(String email);
    user findByName(String CustomerName);
    boolean existsByPhoneNumber(String PhoneNumber);
    boolean existsByEmail(String email);
    long countUser();

}
