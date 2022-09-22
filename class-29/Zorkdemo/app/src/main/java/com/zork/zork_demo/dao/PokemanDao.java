package com.zork.zork_demo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.zork.zork_demo.models.Pokeman;

import java.util.List;

//MORE ANNOTATIONS
@Dao // Think of this like a Spring JPA repository, but we have to implement more stuff ourselves
public interface PokemanDao {
    @Insert
    public void insertAPokeman(Pokeman pokeman);

    // findAll
    @Query("SELECT * FROM Pokeman")
    public List<Pokeman> findAll();

    //findByAll
    @Query("SELECT * FROM Pokeman WHERE type = :type")
    public List<Pokeman> findAllByType(Pokeman.PokemanTypeEnum type);

    //ORDER BY ASC
    @Query("SELECT * FROM Pokeman ORDER BY name ASC")
    public List<Pokeman> findAllSortedByName();

    //Find by id
    @Query("SELECT * FROM Pokeman WHERE id = :id")
    Pokeman findByAnId(long id);

}
