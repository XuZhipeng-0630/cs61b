public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
        this.noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }

}

18 class D {
19 public static void main (String[] args) {
        20 B a0 = new A();X
        21 a0.m1();X
        22 a0.m2(16);X
        23 A b0 = new B();
        24 System.out.println(b0.x);5
        25 b0.m1();Am1 -> 5
        26 b0.m2();Bm2 -> 5
        27 b0.m2(61);X
        28 B b1 = new B();
        29 b1.m2(61);Bm2y -> 61
        30 b1.m3();Bm3->called
        31 A c0 = new C();
        32 c0.m2();Cm2-> 5
        33 C c1 = (A) new C();X
        34 A a1 = (A) c0;
        35 C c2 = (C) a1;
        36 c2.m3();Bm3-> called
        37 c2.m4();Cm4-> 5
        38 c2.m5();Cm5-> 6
        39 ((C) c0).m3();Bm3-> called
        40 (C) c0.m3();X
        41 b0.update();
        42 b0.m1();Am1-> 99
        43 }
44 }



 public class Dog {
    public void bark(Dog d) { /* Method A */ }
 }
 public class Corgi extends Dog {
     public void bark(Corgi c) { /* Method B */ }
     @Override
     public void bark(Dog d) { /* Method C */ }
     public void play(Dog d) { /* Method D */ }
     public void play(Corgi c) { /* Method E */ }
 }

 public static void main(String[] args) {
   2 Dog d = new Corgi();
   3 Corgi c = new Corgi();
   4
   5 d.play(d); Compile-Error
   6 d.play(c); Compile-Error
   7 c.play(d); D
   8 c.play(c); E
   9
   10 c.bark(d); C
   11 c.bark(c); B
   12 d.bark(d); C
   13 d.bark(c); C
   14 }


 public static void main(String[] args) {
 Cat c = new Animal();     compile error
 Animal a = new Cat();
 Dog d = new Cat();        compile error
 Tree t = new Animal();    compile error

 Animal a = (Cat) new Cat();
 Animal a = (Animal) new Cat();
 Dog d = (Dog) new Animal();    runtime error
 Cat c = (Cat) new Dog();       compile error
 Animal a = (Animal) new Tree();    compile error
}

