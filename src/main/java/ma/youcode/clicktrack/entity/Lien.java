
package ma.youcode.clicktrack.entity;

public class Lien {

    private int id;
    private String offre;
    private String urlDestination;
    private int clicks;
    private int publisherId;
    public Lien() {
    }
    public Lien(int id, String offre, String urlDestination,int clicks, int publisherId) {
        this.id = id;
        this.offre = offre;
        this.urlDestination = urlDestination;
        this.clicks = clicks;
        this.publisherId = publisherId;
    }

    public int getId() {
        return id;
    }

    public String getOffre() {
        return offre;
    }

    public String getUrlDestination() {
        return urlDestination;
    }

    public int getClicks() {
        return clicks;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public synchronized void incrementClicks() {
        clicks++;
    }

}
