package com.zork.zork_demo.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.zork.zork_demo.dao.PokemanDao;
import com.zork.zork_demo.models.Pokeman;

//Database annotation
//TypeConverter -> for the util.Date
// extend RoomDatabase
@TypeConverters({GameDatabaseConverters.class})
@Database(entities = {Pokeman.class}, version = 1) // if we update the version, it will delete the db!
public abstract class GameDatabase extends RoomDatabase {
    // add our dao's
    public abstract PokemanDao pokemanDao();
}
