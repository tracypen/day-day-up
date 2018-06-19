### Java反射
1. Class类
 Java程序在运行时，Java运行时系统一直对所有的对象进行所谓的运行时类型标识。这项信息纪录了每个对象所属的类。虚拟机通常使用运行时类型信息选准正确方法去执行，用来保存这些类型信息的类是Class类。Class类封装一个对象和接口运行时的状态，当装载类时，Class类型的对象自动创建。
      Class 没有公共构造方法。Class 对象是在加载类时由Java 虚拟机以及通过调用类加载器中的 defineClass 方法自动构造的，因此不能显式地声明一个Class对象。 
      虚拟机为每种类型管理一个独一无二的Class对象。也就是说，每个类（型）都有一个Class对象。运行程序时，Java虚拟机(JVM)首先检查是否所要加载的类对应的Class对象是否已经加载。如果没有加载，JVM就会根据类名查找.class文件，并将其Class对象载入。
      基本的 Java 类型（boolean、byte、char、short、int、long、float 和 double）和关键字 void 也都对应一个 Class 对象。 
      每个数组属于被映射为 Class 对象的一个类，所有具有相同元素类型和维数的数组都共享该 Class 对象。
 一般某个类的Class对象被载入内存，它就用来创建这个类的所有对象。
			
	        package com.lxqn.jiapeng.reflect;
	    import java.lang.reflect.Method;
	    public class Test {
	    private int sum = 1;
	    private void function(){
	    }
        public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("com.lxqn.jiapeng.reflect.Test");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
        }
        }
> *  JVM在类加载后，会生成类的字节码文件，同时会生成一个同名Class类文件。这个类文件存放这在jvm的方法区。
> *  Class类封装一个对象和接口运行时的状态，当装载类时，Class类型的对象自动创建。
> * 虚拟机为每种类型管理一个独一无二的Class对象。也就是说，每个类都有一个Class对象。运行程序时，Java虚拟机(JVM)首先  检查是否所要加载的类对应的Class对象是否已经加载。如果没有加载，JVM就会根据类名查找.class文件，并将其Class对象载 入。
> * Class 没有公共构造方法，只有个private修饰的构造方法。Class 对象是在加载类时由Java 虚拟机以及通过调用类加载器中的 defineClass 方法自动构造的，因此不能显式地声明一个Class对象。
> *  基本的 Java 类型（boolean、byte、char、short、int、long、float 和 double）和关键字 void 也都对应一个 Class 对象。

#### 如何获取类的Class对象
 1. 使用对象的getClass方法
 2. 使用Class类的静态方法forName，入参必须是类的包名全称。
 3. 如果T是一个Java类型，那么T.class就代表了匹配的Class类对象。

	public class Test {
    public static void main(String[] args) throws Exception{

        //1.使用对象的getClass方法
        Test test = new Test();
        Class clazz1 = test.getClass();
        //2.使用Class类的静态方法forName
        Class clazz2 = Class.forName("com.lxqn.jiapeng.reflect.Test");
        //3.如果T是一个Java类型，那么T.class就代表了匹配的类对象
        Class clazz3  = Test.class;
        Method[] methods = clazz1.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
        }
    }
    } 
[具体事例点击这里](http://blog.csdn.net/ljphhj/article/details/12858767)