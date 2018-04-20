package practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        Ihello ihello = (Ihello) Proxy.newProxyInstance(Ihello.class.getClassLoader(), new Class[]{Ihello.class}, new ProxyHello(new HelloImpl()));
        ihello.sayHello();
        System.out.println(ihello);
        Object obj=Proxy.newProxyInstance(Ihello.class.getClassLoader(), new Class[]{Ihello.class}, new ProxyHello(new HelloImpl()));
        System.out.println(obj);

    }

}

interface Ihello {
    void sayHello();
}

class HelloImpl implements Ihello {

    @Override
    public void sayHello() {
        System.out.println("------------HelloImpl:执行say hello!---------------");
    }
}

class ProxyHello implements InvocationHandler {

    private Ihello target;

    public ProxyHello(Ihello target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------invocation before--------------");
        Object result = method.invoke(target, args);
        System.out.println("-------------invocation after---------------------");
        return result;
    }
}
