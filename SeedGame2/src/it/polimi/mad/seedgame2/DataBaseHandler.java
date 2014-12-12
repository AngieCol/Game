/**
 * 
 */
package it.polimi.mad.seedgame2;

import java.io.File;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import android.R.integer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.drm.DrmStore.Playback;
import android.util.Log;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DataBaseHandler extends OrmLiteSqliteOpenHelper {


	public static final String TABLE_NAME="player";
	private static final String DB_NAME="SeedGame.db";
	private static final int VERSION=1;
	private Dao<Player, integer> playerDAO=null;
	private RuntimeExceptionDao<Player, integer>playerRuntimeDAO=null;
	
	
	private Context context;
	/**
	 * @param context
	 * @param databaseName
	 * @param factory
	 * @param databaseVersion
	 */
	public DataBaseHandler(Context context) {
		super(context, DB_NAME, null, VERSION, R.raw.ormlite_config);
		
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase, com.j256.ormlite.support.ConnectionSource)
	 */
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {
		

		try {
			
			TableUtils.createTable(connectionSource, Player.class);
			Log.d( "GameConsola","table created");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
		
	
	
	/* (non-Javadoc)
	 * @see com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, com.j256.ormlite.support.ConnectionSource, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource cs, int oldVersion,
			int newVersion) {
		try {
			
			TableUtils.dropTable(connectionSource, Player.class, true);
			onCreate(db,cs);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 */
	public Dao<Player, integer> getDao() throws SQLException{
		
		if(playerDAO==null){
			playerDAO= getDao(Player.class);
		}
		
		
		return playerDAO;
		
	}

	/**
	 * 
	 */
	public RuntimeExceptionDao<Player, integer> getPlayerRuntimeExceptionDao() {
		
		if(playerRuntimeDAO==null){
			playerRuntimeDAO= getRuntimeExceptionDao(Player.class);
		}
		
		
		return playerRuntimeDAO;
		
	}
}
