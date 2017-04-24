package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Knjiga;
import model.Oblast;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 20.4.17..
 */
public class Zadatak2DodavanjeVrednosti {

    static Dao<Oblast, Integer> oblastDao;
    static Dao<Knjiga, Integer> knjigaDao;


    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        // create our data-source for the database
        try{
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:knjigaOblast.db");

            oblastDao = DaoManager.createDao(connectionSource, Oblast.class);
            knjigaDao = DaoManager.createDao(connectionSource, Knjiga.class);


            TableUtils.clearTable(connectionSource, Oblast.class);
            TableUtils.clearTable(connectionSource, Knjiga.class);


            //System.out.println("faihfhbsfugbaifhailfhai;lfjli");

            Knjiga k1 = new Knjiga("Java programiranje", 650, new Date());
            knjigaDao.create(k1);
            Knjiga k2 = new Knjiga("Android programiranje", 500, new Date());
            knjigaDao.create(k2);

            Oblast o1 = new Oblast("Uvod", 2, k1);
            oblastDao.create(o1);
            Oblast o2 = new Oblast("Naredbe", 10, k1);
            oblastDao.create(o2);
            Oblast o3 = new Oblast("Aritmeticki operatori", 20, k1);
            oblastDao.create(o3);
            Oblast o4 = new Oblast("Android operativni sistem", 2, k2);
            oblastDao.create(o4);
            Oblast o5 = new Oblast("Activity klasa", 30, k2);
            oblastDao.create(o5);

            System.out.println("-----------------");
            List<Knjiga> knjige = knjigaDao.queryForAll();
            for(Knjiga k : knjige)
                System.out.println("[knjige] = " + k);
            System.out.println("-----------------");

            System.out.println("-----------------");
            List<Oblast> oblasti = oblastDao.queryForAll();
            for(Oblast o : oblasti)
                System.out.println("[oblasti] = " + o);
            System.out.println("-----------------");



        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
