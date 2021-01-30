package thread;

public class Signle {
    private volatile static  Signle instanle = null;

    public static  Signle getInstanle() {
        if (instanle == null) {
            synchronized (Signle.class) {
                if (instanle == null) {
                    instanle = new Signle();
                }
            }
        }
        return instanle;
    }
}