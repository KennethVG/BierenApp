package masterdetail.pxl.be.bierenapp.model;

/**
 * Created by vangike on 20/01/2017.
 */
public class Bier {

    private String naam;
    private Soort soort;
    private double sterkte;
    private String info;

    public Bier(String naam, Soort soort, double sterkte, String info) {
        this.naam = naam;
        this.soort = soort;
        this.sterkte = sterkte;
        this.info = info;
    }

    public Bier(String naam, String soort, double sterkte, String info) {
        this.naam = naam;
        switch (soort.toLowerCase()) {
            case "blond":
                this.soort = Soort.BLOND;
                break;
            case "bruin":
                this.soort = Soort.BRUIN;
                break;
            case "goud":
                this.soort = Soort.GOUD;
                break;
            case "amber":
                this.soort = Soort.AMBER;
                break;
            case "oker":
                this.soort = Soort.OKER;
                break;
        }
        this.sterkte = sterkte;
        this.info = info;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Soort getSoort() {
        return soort;
    }

    public void setSoort(Soort soort) {
        this.soort = soort;
    }

    public double getSterkte() {
        return sterkte;
    }

    public void setSterkte(double sterkte) {
        this.sterkte = sterkte;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


    @Override
    public String toString() {
        return "Bier{" +
                "naam='" + naam + '\'' +
                ", soort=" + soort +
                ", sterkte=" + sterkte +
                ", info='" + info + '\'' +
                '}';
    }
}
