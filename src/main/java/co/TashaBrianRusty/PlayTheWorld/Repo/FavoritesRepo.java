package co.TashaBrianRusty.PlayTheWorld.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.Attraction;
import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;
import co.TashaBrianRusty.PlayTheWorld.entity.User;

public interface FavoritesRepo extends JpaRepository<Favorites, Long>{

}
