package mc.tech.com.service.implementation;

import java.io.IOException;
import java.util.Optional;

public interface IService<T,ID>  {

    T save(T t) throws IOException;
    Optional<T > read(ID id);
    void delete(int deleteById);

}