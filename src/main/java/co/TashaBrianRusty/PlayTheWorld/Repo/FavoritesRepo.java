package co.TashaBrianRusty.PlayTheWorld.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;

public interface FavoritesRepo extends JpaRepository<Favorites, Long>{

	List<Favorites> findByUserName(String userName);
}
