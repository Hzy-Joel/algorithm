package thread;

import java.util.ArrayList;
import java.util.List;

/***
 * 测试协变逆变
 */
public class TestT {

    public static void main(String[] args) {
        // List<? extends Fruit> shop = new ArrayList<Apple>();
        // 指定上界 协变
        // 导致失去了添加功能，因为此时 List<? extends Fruit>可以等同于 List<Apple>
        // 也可以等同于List<Orange>，插入不同的类型会有风险，因此直接不给你插入了
        // shop.add(new Fruit()); //报错
        // 可以获取，但是得到的值都是Fruit或其父类
       

        List<? super Apple> shop = new ArrayList<Fruit>();
        // 指定下界 逆变 表示存储类型为Apple及其父类
        // 导致失去了获取功能，因为此时 List<? super Apple> 可以等同于 List<SweetApple> List<Apple>
        // ，查询到的值有可能是SweetApple、Apple不能确定类型，因此不允许获取值
        // 只允许插入Apple及其子类，获取只能获取到Object类，因为Object为所有类的父类
        shop.add(new Apple());
        shop.add(new SweetApple());
        // shop.get(0); // 只能获取到Object类，因为Object为所有类的父类
    }

    static class Fruit {

    }

    static class Apple extends Fruit {

    }

    static class SweetApple extends Apple {

    }

    static class Orange extends Fruit {

    }

}