import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;

public class Mianshi {
    @Test
    public void selfIncre() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i:" + i);
        System.out.println("j:" + j);
        System.out.println("k:" + k);
    }
}
