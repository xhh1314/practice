package practice.designmode.factory;

/**
 * 单例实现
 *
 * @author lh
 * @date 2018/2/26
 * @since
 */
public class Singleton {

    private Singleton() {
    }

    private static class InnerSingleton {
        private static final Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return InnerSingleton.singleton;
    }
}
