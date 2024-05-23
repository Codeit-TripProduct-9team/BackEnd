package CodeIt.Ytrip.user.repository;

import CodeIt.Ytrip.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    @Query("select u.id from User u where u.email =: email")
    Long findUserIdByEmail(String email);

}
