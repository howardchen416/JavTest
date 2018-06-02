import java.io.Serializable;

public class Singleton implements Serializable {
    private static Singleton instance;

    private Singleton() {
    }

/*    public static Singleton getInstanceUsingDoubleLocking(){
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }*/

    private static class SingleonHelper {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingleonHelper.instance;
    }

    protected Singleton readResolve() {
        return SingleonHelper.instance;
    }

}
