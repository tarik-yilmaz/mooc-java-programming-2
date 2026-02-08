public class OneItemBox extends Box {

    private Item stored;

    public OneItemBox() {
        this.stored = null;
    }

    @Override
    public void add(Item item) {
        if (stored == null) {
            stored = item;
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return stored != null && stored.equals(item);
    }
}
