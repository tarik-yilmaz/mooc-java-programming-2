public class Data implements Comparable<Data> {
    
    private String name;
    private String population;
    private String gender;
    private String country;
    private int year;
    private double literacy;

    public Data(String name, String population, String gender, String country, int year, double literacy)  {
        this.name = name;
        this.population = population;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacy = literacy;
    }

    public double getLiteracy() {
        return this.literacy;
    }
    
    @Override
    public int compareTo(Data other) {
        return Double.compare(this.literacy, other.getLiteracy());
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacy;
    }
}
