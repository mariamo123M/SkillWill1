abstract class Car {
    String model;

    public Car(String name) {
        this.model = "Lamborghini";
    }

    abstract void drive();

    public void speedIncrease() {
        System.out.println(model + "speed increase");
    }
}
    class SportsCar extends Car {

        public SportsCar (String model) {
            super(model);
        }

        @Override
            void drive(){
                System.out.println(model + "car speed is fast");
            }
        }
        class Main {
           public static void main(String[] args) {

        SportsCar myCar = new SportsCar("Lamborghini");

        myCar.drive();
        myCar.speedIncrease();

        }
    }
