package org.spring.client.base;


import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author hitopei
 * compare测试
 */
public class TestComparable implements Comparable{

    private int value;

    public TestComparable(int value){
        this.value = value;
    }

    public TestComparable(){}

    @Override
    public int compareTo(Object o) {
        TestComparable testComparable = (TestComparable)o;
        return testComparable.value - value;
    }

    public int action(int x, Function<Integer, Integer> function){
        int result = function.apply(x);
        return result;
    }

    public int compute(int x, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(x);
    }

    public int compute1(int x, Function<Integer, Integer> function1, Function<Integer, Integer> function2,
                        Function<Integer, Integer> function3){
        return function1.andThen(function2).andThen(function3).apply(x);
    }

    public int compute2(int x, int y, BiFunction<Integer, Integer, Integer> biFunction){
        return biFunction.apply(x, y);
    }

    public static void main(String[] args) {
        TestComparable comparable = new TestComparable();
        int result = comparable.action(5, e -> e*e);
        System.out.println(result);

        int result1 = comparable.compute(-1, e->e*e, e->3*e);
        System.out.println(result1);

        int result2 = comparable.compute1(4, e->e*e, e->3*e, e -> e+3 );
        System.out.println(result2);

        int result3 = comparable.compute2(4, 8, (x, y) -> x+y);
        System.out.println(result3);
    }
}
