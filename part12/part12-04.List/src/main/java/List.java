public class List<Type> {
    
    private Type[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    // First we're adding values to the list
    // public void add(Type value) {
    //     this.values[this.firstFreeIndex] = value;
    //     this.firstFreeIndex++;
    // }

    // As our list does grow automatically, we need to resize it
    // with the usual resizing formula which results in a growth factor of 1.5
    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        
        Type[] newValues = (Type[]) new Object[newSize];
        
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }

        this.values = newValues;
    }

    // Now we change our add() method
    public void add(Type value) {
        if (this.firstFreeIndex == this.values.length) {
            grow();
        }

        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    // Checking the existence of a value
    // public boolean contains(Type value) {
    //     for (int i = 0; i < this.firstFreeIndex; i++) {
    //         if (this.values[i].equals(value)) {
    //             return true;
    //         }
    //     }
        
    //     return false;
    // }


    // Removing a value from our list
    // We split this the functionality of the remove method because we need to 
    // handle the indexing and spacing after removing an elemenent from a list

    // First we find the index of the element to be removed
    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        
        return -1;
    }

    // Now we implement the method which moves values from the given index one place to the left
    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    // Now we can implement the method remove using these two methods
    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        
        if (indexOfValue < 0) {
            return;
        }

        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }

    // As the method contains looks very similar to the method indexOfValue,
    // we can modify it using the method indexOfValue
    public boolean contains(Type value) {
        return indexOfValue(value) >= 0;
    }

    // Searching from an index
    public Type value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index" + index + " outside of [0, " + this.firstFreeIndex + "]");
        }

        return this.values[index];
    }

    // Size of the list
    public int size() {
        return this.firstFreeIndex;
    }




}
