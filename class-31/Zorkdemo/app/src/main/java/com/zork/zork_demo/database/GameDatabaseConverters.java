package com.zork.zork_demo.database;


import java.util.Date;

public class GameDatabaseConverters {
    //MORE ANNOS
//    @TypeConverter
    public static Date fromTimeStamp(Long value){
        return value == null ? null : new Date(value);
    }

//    @TypeConverter
    public static Long dateToTimeStamp(Date date){
        return date == null ? null : date.getTime();
    }
}
