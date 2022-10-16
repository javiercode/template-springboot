package ubilapaz.edu.bo.template.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ubilapaz.edu.bo.template.domain.User;
import ubilapaz.edu.bo.template.domain.dto.UserDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {

//    @Query("SELECT r FROM User r order by id desc")
//    Optional<List<User>> getLista();

    @Query(value = "SELECT new ubilapaz.edu.bo.template.domain.dto.UserDto(r.username, r.password, r.nombre) FROM User r order by id desc")
//    @Query(value = "SELECT new UserDto(r.username, r.password, r.nombre) FROM user r order by id desc",nativeQuery = true)
    List<UserDto> obtenerLista();

}
