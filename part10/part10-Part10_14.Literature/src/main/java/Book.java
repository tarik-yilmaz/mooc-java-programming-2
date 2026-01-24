public class Book implements Comparable<Book> {
    
    private String name;
    private int recommendedAge;


    public Book(String name, int recommendedAge) {
        this.name = name;
        this.recommendedAge = recommendedAge;
    }

    public String getName() {
        return this.name;
    }

    public int getRecommendedAge() {
        return this.recommendedAge;
    }

    @Override
    public String toString() {
        return this.name + "(recommended for " + this.recommendedAge + " year-olds or older)";
    }

    @Override
    public int compareTo(Book other) {
        if (this.recommendedAge > other.recommendedAge) {
            return 1;
        } else if ((this.recommendedAge == other.recommendedAge) && (this.name.compareTo(other.getName()) > 0))  {
            return 1;
        } else {
            return -1;
        }
    }
}
