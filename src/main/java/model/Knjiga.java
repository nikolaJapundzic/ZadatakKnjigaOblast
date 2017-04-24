package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by androiddevelopment on 20.4.17..
 */
@DatabaseTable(tableName="knjiga")
public class Knjiga {

    public static final String POLJE_NASLOV = "polje_naslov";
    public static final String POLJE_BROJ_STRANA = "broj_strana";
    public static final String POLJE_DATUM_IZDAVANJA = "datum_izdavanja";

    //private int id;
    private String naslov;
    private int brojStrana;
    private Date datum;

    private boolean prisutna;

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NASLOV,canBeNull = false)
    private Date polje_naslov;
    @DatabaseField(columnName = POLJE_BROJ_STRANA,canBeNull = false)
    private String broj_strana;
    @DatabaseField(columnName = POLJE_DATUM_IZDAVANJA,canBeNull = false)
    private String datum_izdavanja;

    @ForeignCollectionField(foreignFieldName = "knjiga",eager=false,maxEagerLevel = 1)
    private ForeignCollection<Oblast> oblasti;

    Knjiga(){

    }

    Knjiga(String naslov, int brojStrana, Date datum){
        this.naslov = naslov;
        this.brojStrana = brojStrana;
        this.datum = datum;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(int brojStrana) {
        this.brojStrana = brojStrana;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public ForeignCollection<Oblast> getOblasti() {
        return oblasti;
    }

    public void setOblasti(ForeignCollection<Oblast> oblasti) {
        this.oblasti = oblasti;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "naslov='" + naslov + '\'' +
                ", brojStrana=" + brojStrana +
                ", datum=" + datum +
                ", id=" + id +
                '}';
    }
}
