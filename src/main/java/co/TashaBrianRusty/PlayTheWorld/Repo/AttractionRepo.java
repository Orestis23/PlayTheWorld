package co.TashaBrianRusty.PlayTheWorld.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.Favorites;

public interface AttractionRepo extends JpaRepository<Favorites, Integer>{

}
