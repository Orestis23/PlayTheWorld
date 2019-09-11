package co.TashaBrianRusty.PlayTheWorld.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	User findByeMail(String eMail);

	User findByeMail(String eMail);

}
