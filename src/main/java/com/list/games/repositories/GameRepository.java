package com.list.games.repositories;

import com.list.games.entities.Game;
import com.list.games.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
		SELECT game_table.id, game_table.title, game_table.game_year AS `year`, game_table.img_url AS imgUrl,
		game_table.short_description AS shortDescription, belonging_table.position
		FROM game_table
		INNER JOIN belonging_table ON game_table.id = belonging_table.game_id
		WHERE belonging_table.list_id = :listId
		ORDER BY belonging_table.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}
