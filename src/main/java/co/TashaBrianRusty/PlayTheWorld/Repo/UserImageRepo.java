package co.TashaBrianRusty.PlayTheWorld.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.UserImage;


public interface UserImageRepo extends JpaRepository<UserImage, Integer>{

//	List<UserImage> findByUserImages(Integer id);

	List<UserImage> findAllByUserId(Integer id);
}
