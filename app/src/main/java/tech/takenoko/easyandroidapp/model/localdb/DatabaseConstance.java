package tech.takenoko.easyandroidapp.model.localdb;

/**
 * Created by takenoko on 2018/04/28.
 */

public interface DatabaseConstance {

    final static String SQL_CREATE_TABLE
        = "CREATE TABLE log ("
            + "_id  integer primary key autoincrement not null,"
            + "text1 text not null,"
            + "text2 text not null"
            + ")";

    final static String SQL_DELETE_ENTRIES
        = "DROP TABLE IF EXISTS log";
}
