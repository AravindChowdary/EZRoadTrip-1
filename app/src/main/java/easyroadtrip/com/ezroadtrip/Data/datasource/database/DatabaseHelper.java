package easyroadtrip.com.ezroadtrip.Data.datasource.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import easyroadtrip.com.ezroadtrip.Domain.MappedPosition;
import easyroadtrip.com.ezroadtrip.Domain.OriginalPosition;
import easyroadtrip.com.ezroadtrip.Domain.Route;
import easyroadtrip.com.ezroadtrip.Domain.Summary;
import easyroadtrip.com.ezroadtrip.Domain.Trip;
import easyroadtrip.com.ezroadtrip.Domain.Waypoint;

/**
 * Created by aravindchowdary on 7/29/17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String DATABASE_NAME = "ezroadtrip.db";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper mDatabaseHelper;

    private RuntimeExceptionDao<Route, Integer> mRouteDao;
    private RuntimeExceptionDao<Summary, Integer> mSummaryDao;
    private RuntimeExceptionDao<Trip, Integer> mTripDao;
    private RuntimeExceptionDao<Waypoint, Integer> mWaypointDao;
    private RuntimeExceptionDao<MappedPosition, Integer> mMappedPositionDao;
    private RuntimeExceptionDao<OriginalPosition, Integer> mOriginalPositionDao;

    private DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(Context context){
        if(mDatabaseHelper==null)
            mDatabaseHelper = new DatabaseHelper(context);
        return mDatabaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource){
        try{
            TableUtils.createTable(connectionSource, Route.class);
            TableUtils.createTable(connectionSource, Summary.class);
            TableUtils.createTable(connectionSource, Trip.class);
            TableUtils.createTable(connectionSource, Waypoint.class);
            TableUtils.createTable(connectionSource, MappedPosition.class);
            TableUtils.createTable(connectionSource, OriginalPosition.class);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion){
        if(newVersion > oldVersion){
            try{
                TableUtils.dropTable(connectionSource, Route.class, true);
                onCreate(database, connectionSource);

                TableUtils.dropTable(connectionSource, Summary.class, true);
                onCreate(database, connectionSource);

                TableUtils.dropTable(connectionSource, Trip.class, true);
                onCreate(database, connectionSource);

                TableUtils.dropTable(connectionSource, Waypoint.class, true);
                onCreate(database, connectionSource);

                TableUtils.dropTable(connectionSource, MappedPosition.class, true);
                onCreate(database, connectionSource);

                TableUtils.dropTable(connectionSource, OriginalPosition.class, true);
                onCreate(database, connectionSource);
            }
            catch(SQLException e){
                e.printStackTrace();
            }

        }
    }

    public RuntimeExceptionDao<Route, Integer> getRouteDao(){
        if(mRouteDao == null){
            mRouteDao = getRuntimeExceptionDao(Route.class);
        }
        return mRouteDao;
    }

    public RuntimeExceptionDao<Summary, Integer> getSummaryDao(){
        if(mSummaryDao == null){
            mSummaryDao = getRuntimeExceptionDao(Summary.class);
        }
        return mSummaryDao;
    }

    public RuntimeExceptionDao<Trip, Integer> getTripDao(){
        if(mTripDao == null){
            mTripDao = getRuntimeExceptionDao(Trip.class);
        }
        return mTripDao;
    }

    public RuntimeExceptionDao<Waypoint, Integer> getWaypointDao(){
        if(mWaypointDao == null){
            mWaypointDao = getRuntimeExceptionDao(Waypoint.class);
        }
        return mWaypointDao;
    }

    public RuntimeExceptionDao<MappedPosition, Integer> getMappedPositionDao(){
        if(mMappedPositionDao == null){
            mMappedPositionDao = getRuntimeExceptionDao(MappedPosition.class);
        }
        return mMappedPositionDao;
    }

    public RuntimeExceptionDao<OriginalPosition, Integer> getOriginalPositionDao(){
        if(mOriginalPositionDao == null){
            mOriginalPositionDao = getRuntimeExceptionDao(OriginalPosition.class);
        }
        return mOriginalPositionDao;
    }


    public boolean isRouteRecordExisted(){
        if(getRouteDao().countOf()>0){
            return true;
        }
        return false;
    }

    public boolean isSummaryRecordExisted(){
        if(getSummaryDao().countOf()>0){
            return true;
        }
        return false;
    }

    public boolean isTripRecordExisted(){
        if(getTripDao().countOf()>0){
            return true;
        }
        return false;
    }

    public boolean isWaypointRecordExisted(){
        if(getWaypointDao().countOf()>0){
            return true;
        }
        return false;
    }

    public boolean isMappedPositionRecordExisted(){
        if(getMappedPositionDao().countOf()>0){
            return true;
        }
        return false;
    }

    public boolean isOriginalPositionRecordExisted(){
        if(getOriginalPositionDao().countOf()>0){
            return true;
        }
        return false;
    }


}
