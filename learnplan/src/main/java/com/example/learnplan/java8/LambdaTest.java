package com.example.learnplan.java8;

import com.example.learnplan.model.User;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

/** @author wangfk */
public class LambdaTest {
  public static void main(String[] args) {
    /** 示例 原始方式 */
    Runnable runnable =
        new Runnable() {
          @Override
          public void run() {
            System.out.println("原始方式");
          }
        };
    /** lambda表达式写法 简化代码 */
    Runnable lambdaRunnable = () -> System.out.println("java8 lambda表达式");

    /**
     * 语法学习 Lambda表达式在Java 语言中引入了一个新的语法元素和操作符。这个操作符为 “->” ， 该操作符被称为 Lambda 操作符或剪头操作符。 它将 Lambda
     * 分为两个部分： 左侧： 指定了 Lambda 表达式需要的所有参数 右侧： 指定了 Lambda 体，即 Lambda 表达式要执行的功能
     *
     * <p>语法格式一：无参，无返回值，Lambda 体只需一条语句
     */
    Runnable r1 = () -> System.out.println("无参，无返回值，Lambda 体只需一条语句");
    /** 语法格式二：Lambda 需要一个参数，无返回值 */
    Consumer<String> con = (x) -> System.out.println("Lambda 需要一个参数" + x + "，无返回值");
    /** 语法格式三：Lambda 只需要一个参数时，参数的小括号可以省略 */
    Consumer<String> con1 = x -> System.out.println("Lambda 只需要一个参数时，参数的小括号可以省略");
    /** 语法格式四：Lambda 需要两个参数，并且有返回值 */
    Comparator<Integer> com =
        (x, y) -> {
          System.out.println("Lambda 需要两个参数，并且有返回值 ");
          return Integer.compare(x, y);
        };
    /** 语法格式五：当 Lambda 体只有一条语句时，return 与大括号可以省略 */
    Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
    /**
     * Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断“ 类型推断：Lambda表达式中的参数类型都是由编译器推断得出的。
     * Lambda表达式中无需指定类型，程序依然可以编译，这是因为javac根据程序的上下文，在后台推断出了参数的类型。 Lambda 表达式的类型依赖于上下文环境，是由编译器推断出来的。
     */
    Comparator<Integer> com2 =
        (Integer x, Integer y) -> {
          // 参数类型可以省略 Integer
          System.out.println("类型推断");
          return Integer.compare(x, y);
        };

    runnable.run();
    lambdaRunnable.run();
    LambdaTest lambdaTest = new LambdaTest();
    lambdaTest.consumerTest();
    lambdaTest.supplierTest();
    lambdaTest.functionTest();
    lambdaTest.predicateTest();
    lambdaTest.methodReferenceTest();
    lambdaTest.classStaticReferenceTest();
    lambdaTest.classReferenceTest();
    lambdaTest.constructorReferenceTest();
    lambdaTest.listFor();
  }

  /**
   * 函数式接口 只包含一个抽象方法的接口，称为函数式接口。 可以通过 Lambda 表达式来创建该接口的对象。（若 Lambda
   * 表达式抛出一个受检异常，那么该异常需要在目标接口的抽象方法上进行声明）。 可以在任意函数式接口上使用 @FunctionalInterface 注解，
   * 这样做可以检查它是否是一个函数式接口，同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口
   *
   * <p>常用的四种函数式接口 Consumer<T> : 消费型接口 void accept(T t);
   */
  public void consumerTest() {
    money(1000, m -> System.out.println("ym喜欢买口红每次至少要花" + m + "元"));
  }

  public void money(double money, Consumer<Double> consumer) {
    consumer.accept(money);
  }

  /** Supplier<T> : 供给型接口 T get(); */
  public void supplierTest() {
    List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
    numList.forEach(System.out::println);
  }

  public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
    List<Integer> list = new ArrayList();
    for (int i = 0; i < num; i++) {
      Integer n = supplier.get();
      list.add(n);
    }
    return list;
  }

  /** Function<T, R> : 函数型接口 R apply(T t); 参数类型 T 返回类型 R */
  public void functionTest() {
    String newStr1 = strHandler("la ji ym \t\t", p -> p.trim());
    System.out.println(newStr1);
    String newStr2 = strHandler("la ji ym", p -> p.substring(0, 1));
    System.out.println(newStr2);
  }

  public String strHandler(String str, Function<String, String> function) {
    return function.apply(str);
  }

  /** Predicate<T> : 断定型接口 boolean test(T t); */
  public void predicateTest() {
    List<String> list = Arrays.asList("ym", "bu", "shi", "la", "ji");
    List<String> listDeal = strList(list, p -> p.length() > 1);
    listDeal.forEach(System.out::println);
  }

  public List<String> strList(List<String> list, Predicate<String> predicate) {
    List<String> stringList = new ArrayList<>();
    list.stream().filter(p -> predicate.test(p)).forEach(p -> stringList.add(p));
    return stringList;
  }

  /**
   * 方法引用 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！ 方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！
   * 方法引用：使用操作符 “::” 将方法名和对象或类的名字分隔开来。
   *
   * <p>三种情形： （1）对象::实例方法
   */
  public void methodReferenceTest() {
    // 原始
    PrintStream ps = System.out;
    Consumer<String> con = (str) -> ps.println(str);
    con.accept("原始的 ym");
    // 方法引用
    Consumer consumer = System.out::println;
    consumer.accept("进化后的 ym");

    User user = new User("ym");
    // 原始
    Supplier<String> sup = () -> user.getUserName();
    System.out.println("原始的 " + sup.get());
    // 方法引用
    Supplier<String> supplier = user::getUserName;
    System.out.println("进化后的 " + supplier.get());
  }

  /** （2）类::静态方法 */
  public void classStaticReferenceTest() {
    // 原始
    BiFunction<Double, Double, Double> fun = (x, y) -> Math.max(x, y);
    System.out.println(fun.apply(11.1, 22.2));
    // 方法引用
    BiFunction<Double, Double, Double> fun2 = Math::max;
    System.out.println(fun2.apply(11.1, 22.2));
  }

  /** （3）类::实例方法 */
  public void classReferenceTest() {
    // 原始
    BiPredicate<String, String> bp = (x, y) -> x.equals(y);
    System.out.println(bp.test("ym", "ym"));
    // 方法引用
    BiPredicate<String, String> biPredicate = String::equals;
    System.out.println(biPredicate.test("ym", "ym"));
  }

  /** 构造器引用 构造器的参数列表，需要与函数式接口中参数列表保持一致！ */
  public void constructorReferenceTest() {
    Function<String, User> function = User::new;
    System.out.println(function.apply("ym").getUserName());
  }

  /**
   * lambda表达式使用实例！
   *
   * <p>1.替代匿名内部类 2.集合操作 forEach map ... 3.函数式接口实现
   */
  public void listFor() {
    List<User> userList = getUserList();
    // forEach
    userList.forEach(System.out::println);
    userList.stream()
        .filter(p -> "ym".equals(p.getUserName()))
        .limit(2)
        .forEach(System.out::println);
    userList.stream()
        .sorted(Comparator.comparingInt(User::getAge))
        .filter(p -> p.getAge() > 17)
        .forEach(System.out::println);
    // max 最大值如果有很多，只会返回一个
    userList.stream().max(Comparator.comparingInt(User::getAge)).ifPresent(System.out::println);
    // map 遍历集合，对符合条件的每一个对象做处理，转化为其他对象
    userList.stream()
        .filter(p -> p.getAge() > 18)
        .map(
            p -> {
              p.setAge(p.getAge() + 3);
              return p;
            })
        .forEach(System.out::println);
    // reduce 遍历集合 对某个属性的值进行求和
    // collect 根据条件重新生成集合对象
    userList.stream().map(User::getAge).collect(Collectors.toList()).stream()
        .reduce(Integer::sum)
        .ifPresent(System.out::println);
  }

  private List<User> getUserList() {
    List<User> list = new ArrayList<>();
    list.add(new User("ym", 18));
    list.add(new User("wlh", 17));
    list.add(new User("wfk", 20));
    list.add(new User("zys", 21));
    list.add(new User("zpc", 21));
    return list;
  }
}
