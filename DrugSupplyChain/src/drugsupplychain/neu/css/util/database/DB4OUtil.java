package drugsupplychain.neu.css.util.database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import drugsupplychain.neu.css.model.FDI.ConfigureSupplyChainSystem;
import drugsupplychain.neu.css.model.FDI.FDISystem;

/**
 *
 * @author laksh
 */
public class DB4OUtil {

    private static final String FILENAME = "D:\\DataBank10.db4o"; // path to the data store
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth/level of updation of Object
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(FDISystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public synchronized void storeSystem(FDISystem fDISystem) {
        ObjectContainer conn = createConnection();
        conn.store(fDISystem);
        conn.commit();
        conn.close();
    }
    
    public FDISystem retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<FDISystem> systems = conn.query(FDISystem.class); // Change to the object you want to save
        FDISystem fDISystem;
        if (systems.size() == 0){
            fDISystem = ConfigureSupplyChainSystem.configure();  // If there's no System in the record, create a new one
        }
        else{
            fDISystem = systems.get(0);
        }
        conn.close();
        return fDISystem;
    }
}
