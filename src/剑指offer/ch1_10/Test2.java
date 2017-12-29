package 剑指offer.ch1_10;

/**
 * 面试题2：实现单例模式
 * Created by Cyhui on 2017/12/29 0029.
 */
public class Test2{

}
//懒汉式
class Singleton1{
    private static Singleton1 singleton1;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if (singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

//饿汉式
class Singleton2{
    private static Singleton2 singleton2 = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return singleton2;
    }
}

//双重校验锁
class Singleton3{
    private static volatile Singleton3 singleton3;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if (singleton3 == null){
            synchronized (Singleton3.class){
                if (singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}

class Singleton4{
    private static Singleton4 singleton4;
    private Singleton4(){}
    static {
        singleton4 = new Singleton4();
    }
    public static Singleton4 getInstance(){
        return singleton4;
    }
}

// 静态内部类
class Singleton5{
    private final static class SingletonHolder{
        private static final Singleton5 sinleton5 = new Singleton5();
    }
    private Singleton5(){}
    private static Singleton5 getInstance(){
        return SingletonHolder.sinleton5;
    }
}

// 枚举
enum Singleton6{
    INSTANCE;

}