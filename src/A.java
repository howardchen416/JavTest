class A {
    public A() {
        foo();
    }

    public void foo() {
        System.out.println("Class A");
    }
}

class B extends A {
    public B() {
    }

    public void foo() {
        System.out.println("Class B");
    }
}

class main {
    public static void main(String[] args) {
        A a = new B();
    }
}
