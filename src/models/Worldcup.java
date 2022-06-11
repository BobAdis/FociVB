package models;

public class Worldcup {
    private int year;
    private String host;
    private String confederation;
    private String date_from;
    private String date_to;

    public Worldcup() {
    }

    public Worldcup(int year, String host, String confederation, String date_from, String date_to) {
        this.year = year;
        this.host = host;
        this.confederation = confederation;
        this.date_from = date_from;
        this.date_to = date_to;
    }

    public Worldcup(String line) {
        String[] Data = line.split(";");
        this.year = Integer.parseInt(Data[0]);
        this.host = Data[1];
        this.confederation = Data[2];
        this.date_from = Data[3];
        this.date_to = Data[4];
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConfederation() {
        return confederation;
    }

    public void setConfederation(String confederation) {
        this.confederation = confederation;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    @Override
    public String toString() {
        return "Worldcup{" +
                "year=" + year +
                ", host='" + host + '\'' +
                ", confederation='" + confederation + '\'' +
                ", date_from='" + date_from + '\'' +
                ", date_to='" + date_to + '\'' +
                '}';
    }
}
