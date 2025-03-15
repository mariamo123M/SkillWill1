class Swimmer {
    public void swim(){
        System.out.println("Swimming");
    }
}
class Dolphin extends Swimmer {
    @Override
    public void swim() {
        System.out.println("Dolphin swims  with tail.");
    }
}
class  Mermaid extends Swimmer {
    @Override
    public void swim() {
        System.out.println("Mermaid swims with tail");
    }
}
class Fish extends Swimmer{
    @Override
    public void swim() {
        System.out.println(" Fish swims  with tail ");
    }
}
   class Main {
    public static void main(String[] args) {
        Swimmer dolphin = new Dolphin();
        Swimmer mermaid = new Mermaid();
        Swimmer fish = new Fish();

        dolphin.swim();
        mermaid.swim();
        fish.swim();

    }
}