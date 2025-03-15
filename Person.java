
 class Person{
    private String name;

    public Person () {
        this.name = "unknown";
    }

    public Person (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        System.out.println("name return:" + name);
    }
}
  class Main {
    public static void main (String[] args) {
        Person m = new Person("Mariami");
        System.out.println(m.getName());

         m.setName("Anastasia");
        System.out.println(m.getName());

        Person unknown = new Person();
        System.out.println(unknown.getName());
    }
}
