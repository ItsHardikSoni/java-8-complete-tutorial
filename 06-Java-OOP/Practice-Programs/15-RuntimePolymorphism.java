abstract class AnimalPolymorphism {
    abstract void sound();
}

class DogPoly extends AnimalPolymorphism {
    void sound() {
        System.out.println("Dog: Bark");
    }
}

class CatPoly extends AnimalPolymorphism {
    void sound() {
        System.out.println("Cat: Meow");
    }
}

class RuntimePolymorphism {
    public static void main(String[] args) {
        AnimalPolymorphism dog = new DogPoly();
        AnimalPolymorphism cat = new CatPoly();
        dog.sound();
        cat.sound();
    }
}
