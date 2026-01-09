public class TripleTacoBox implements TacoBox {

    private int tacos;

    public TripleTacoBox() {
        this.tacos = 3;
    }

    public int tacosRemaining() {
        return this.tacos;
    }

    public void eat() {
        this.tacos--;
        if (this.tacos < 0) {
            this.tacos = 0;
        }
    }

}
