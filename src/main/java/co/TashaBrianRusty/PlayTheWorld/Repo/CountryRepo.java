package co.TashaBrianRusty.PlayTheWorld.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

}
