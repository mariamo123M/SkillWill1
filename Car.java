
abstract class Car {
    abstract void speed();
    abstract void color();
}
class FerrariF40 extends Car {
    @Override
    void speed() {
        System.out.println("Ferrari F40 speed is: 360 km/h");
    }
    @Override
    void color() {
        System.out.println("Ferrari F40 color is: red");
    }
    }
    class Main {
      public static void main(String[] args) {
            Car myFerrari = new FerrariF40();
            myFerrari.speed();
            myFerrari.color();
        }
    }
