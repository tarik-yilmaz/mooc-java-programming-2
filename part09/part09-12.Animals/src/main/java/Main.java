
public class Main {

    public static void main(String[] args) {
        // you can test how your classes work here

        // Test for class Dog (part 2)
        Dog dog = new Dog();
        dog.bark();
        dog.eat();

        Dog fido = new Dog("Fido");
        fido.bark();
        System.out.println();


        // Test for class Cat (part 3)
        Cat cat = new Cat();
        cat.purr();
        cat.eat();

        Cat garfield = new Cat("Garfield");
        garfield.purr();
        System.out.println();

        // Test of interface NoiseCapable (part 4)
        NoiseCapable dog1 = new Dog();
        dog1.makeNoise();

        NoiseCapable cat2 = new Cat("Garfield");
        cat2.makeNoise();
        Cat c = (Cat) cat2;
        c.purr();
    }

}
