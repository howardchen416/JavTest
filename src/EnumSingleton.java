public enum EnumSingleton {
    firstINSTANCE,
    secondINSTANCE;
    private EnumSingleton() {
        System.out.println("This is where I am instantiated");
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.firstINSTANCE);
    }

}
