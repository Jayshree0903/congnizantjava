//18
class Animal {
    void makeSound() {
        System.out.println("Some sound...");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        genericAnimal.makeSound();

        Dog dog = new Dog();
        dog.makeSound();
    }
}
