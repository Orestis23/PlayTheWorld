package co.TashaBrianRusty.PlayTheWorld.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.Attraction;
import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;

public interface FavoritesRepo extends JpaRepository<Favorites, Long>{

}
