package co.TashaBrianRusty.PlayTheWorld.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.TashaBrianRusty.PlayTheWorld.entity.LocVisited;

public interface LocVisitedRepo extends JpaRepository<LocVisited, Long>{

	List<LocVisited> findByUserName(String userName);
}
