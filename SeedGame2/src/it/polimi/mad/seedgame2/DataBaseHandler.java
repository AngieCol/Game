/**
 * 
 */
package it.polimi.mad.seedgame2;

import java.sql.SQLException;
import android.R.integer;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


public class DataBaseHandler extends OrmLiteSqliteOpenHelper {


	public static final String TABLE_NAME_P="player";
	public static final String TABLE_NAME_M="match";
	public static final String TABLE_NAME_S="statistics";
	private static final String DB_NAME="SeedGame.db";
	private static final int VERSION=1;
	private Dao<Player, String> playerDAO=null;
	private RuntimeExceptionDao<Player, String> playerRuntimeDAO=null;
	private Dao<Match, integer> matchDAO=null;
	private RuntimeExceptionDao<Match, integer> matchRuntimeDAO=null;
	private Dao<Statistics, integer> statisticsDAO=null;
	private RuntimeExceptionDao<Statistics, integer> statisticsRuntimeDAO=null;
	
	private Context context;
	/**
	 * @param context
	 * @param databaseName
	 * @param factory
	 * @param databaseVersion
	 */
//	public DataBaseHandler(Context context) {
//		super(context, DB_NAME, null, VERSION, R.raw.ormlite_config);
//		
//		this.context = context;
//	}

	public DataBaseHandler(Context context) {
		super(context, DB_NAME, null, VERSION);
		
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase, com.j256.ormlite.support.ConnectionSource)
	 */
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {
		

		try {
			
			TableUtils.createTable(connectionSource, Player.class);
			TableUtils.createTable(connectionSource, Match.class);
			TableUtils.createTable(connectionSource, StatisticsUI.class);
			Log.d( "GameConsola","tables created");
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
			TableUtils.dropTable(connectionSource, Match.class, true);
			TableUtils.dropTable(connectionSource, StatisticsUI.class, true);
			onCreate(db,cs);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 
	 */
	public Dao<Player, String> getDaoPlayer() throws SQLException{
		
		if(playerDAO==null){
			playerDAO= getDao(Player.class);
		}
		
		
		return playerDAO;
		
	}

	/**
	 * 
	 */
	public RuntimeExceptionDao<Player, String> getPlayerRuntimeExceptionDao() {
		
		if(playerRuntimeDAO==null){
			playerRuntimeDAO= getRuntimeExceptionDao(Player.class);
		}
		
		
		return playerRuntimeDAO;
		
	}


	/**
	 * 
	 */
	public Dao<Match, integer> getDaoMatch() throws SQLException{
		
		if(matchDAO==null){
			matchDAO= getDao(Match.class);
		}
		
		
		return matchDAO;
		
	}

	/**
	 * 
	 */
	public RuntimeExceptionDao<Match, integer> getMatchRuntimeExceptionDao() {
		
		if(matchRuntimeDAO==null){
			matchRuntimeDAO= getRuntimeExceptionDao(Match.class);
		}
		
		
		return matchRuntimeDAO;
		
	}

	/**
	 * 
	 */
	public Dao<Statistics, integer> getDaoStatistics() throws SQLException{
		
		if(statisticsDAO==null){
			statisticsDAO= getDao(Statistics.class);
		}
		
		
		return statisticsDAO;
		
	}

	/**
	 * 
	 */
	public RuntimeExceptionDao<Statistics, integer> getStatisticsRuntimeExceptionDao() {
		
		if(statisticsRuntimeDAO==null){
			statisticsRuntimeDAO= getRuntimeExceptionDao(Statistics.class);
		}
		
		
		return statisticsRuntimeDAO;
		
	}






}
