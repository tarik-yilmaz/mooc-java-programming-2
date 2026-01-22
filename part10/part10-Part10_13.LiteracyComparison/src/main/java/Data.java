public class Data implements Comparable<Data> {
    
    String name;
    String population;
    String gender;
    String country;
    int year;
    double literacy;

    public Data(String name, String population, String gender, String country, int year, double literacy)  {
        this.name = name;
        this.population = population;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacy = literacy;
    }

    @Override
    public int compareTo(Data other) {
        return Double.compare(this.literacy, other.literacy);
    }

    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacy;
    }
}
