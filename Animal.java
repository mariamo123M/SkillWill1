
class Animal {
    String name;

    public Animal( String name) {
        this.name = name;
    }
    public void makeSound () {
        System.out.println("sound");
    }
}
class Horse extends Animal {
    public Horse (String name) {
        super(name);
    }
    public void makeSound(){
        System.out.println(name  +  " says: iuhuu!");
    }
}
 class Main {
    public static void main(String[] args) {

        Horse myHorse = new Horse("Prutu");
        myHorse.makeSound();
    }
}