import org.junit.Test;

public class SingletonTest {
    /**
     * 饿汉
     */
    static class SingleTonLazy {
        public static final SingleTonLazy INSTANCE = new SingleTonLazy();

        private SingleTonLazy() {

        }
    }
    static class SingleTonHungery{

    }

    @Test
    public void singleton() {

    }
}
