/**
 * 
 */
package it.polimi.mad.seedgame2;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * 
 *
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil{
	
	private static final Class<?>[] classes= new Class[]{Player.class};
	

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, IOException {
		writeConfigFile("ormlite_config.txt", classes);
		
	}

}
