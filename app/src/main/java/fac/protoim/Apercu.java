package fac.protoim;

/**
 * Created by Sylvain on 18/04/2016.
 */
public class Apercu {

    private String jour;
    private String mois;
    private String type;
    private String description;

    public Apercu(String jour, String mois, String type, String description) {
        this.jour = jour;
        this.mois = mois;
        this.type = type;
        this.description = description;
    }



    public String getJour() {
        return jour;
    }
    public String getMois() {
        return mois;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }


    public void setJour(String text) {
        this.jour = text;
    }
    public void setMois(String text) {
        this.mois = text;
    }
    public void setType(String text) {
        this.type = text;
    }
    public void setDescription(String text) {
        this.description = text;
    }

}
