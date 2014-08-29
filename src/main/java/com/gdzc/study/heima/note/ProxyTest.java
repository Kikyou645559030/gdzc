package com.gdzc.study.heima.note;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-8-29.
 * 动态代理、动态类
 */
public class ProxyTest {
    public static void main(String[] args){
        //通过反射创建动态类，第一个参数一般和后面参数接口的类加载器一致，后面可以添加多个接口类型的参数
        Class clazz1 = Proxy.getProxyClass(Collection.class.getClassLoader(),Collection.class);
        System.out.println(clazz1.getName());

        //循环遍历，获取所有的构造方法以及参数类型
        System.out.println("------begin constructors list------");
        Constructor[] constructors = clazz1.getConstructors();
        for (Constructor c : constructors){
            String name = c.getName();
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            //获取所有的参数类型
            Class[] classes1 = c.getParameterTypes();
            for (Class c1 : classes1){
                sb.append(c1.getName()).append(',');
            }
            if (classes1 != null && classes1.length != 0){
                sb.substring(classes1.length - 1);
            }
            sb.append(')');
            System.out.println(sb);
        }

        //循环遍历，获取所有的成员方法以及参数类型
        System.out.println("------begin methods list------");
        Method[] methods = clazz1.getMethods();
        for (Method m : methods){
            String name = m.getName();
            StringBuilder sb = new StringBuilder(name);
            sb.append('(');
            Class[] classes1 = m.getParameterTypes();
            for (Class c1 : classes1){
                sb.append(c1.getName()).append(',');
            }
            if (classes1 != null && classes1.length != 0){
                sb.substring(classes1.length - 1);
            }
            sb.append(')');
            System.out.println(sb);
        }

        //获取唯一一个有参构造方法，并创建实例对象
        System.out.println("------begin new instance Object------");
        try {
            //传递InvocationHandler参数及实现这个接口的实例对象
            Constructor constructor = clazz1.getConstructor(InvocationHandler.class);
            //可以直接new匿名内部类
            Collection proxy1 = (Collection)constructor.newInstance(new ClassLoaderAttachment());
            System.out.println(proxy1);//toString()方法返回的null，不是对象null
            proxy1.clear();
//            proxy1.size();//货报错，因为代理返回的值是null，而实际返回的应该是int，所以出现空指针异常

            //对于创建的动态代理类，从Object继承的方法，只有hashcod()、equals()和toString()委托给了
            // 实现InvocationHandler接口的实例对象，其他继承的不通过代理

            //传递是三个参数直接创建动态代理类的实例对象，第一个是类加载器，
            // 第二个是被创建的类所实现的接口的数组，第三个实现了InvocationHandler()接口的实例化对象
            Collection proxy2 = (Collection)Proxy.newProxyInstance(Collection.class.getClassLoader(),new Class[]{Collection.class},new InvocationHandler(){
                List list = new ArrayList();
                @Override
                //invoke()的三个参数分别是代表对象、方法、方法参数，proxy2调用的任何方法都是通过invoke()方法来执行的
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    List list = new ArrayList();//放在里面调用add()方法时，size()不增加
                    long startTime = System.currentTimeMillis();
                    Object rerult = method.invoke(list,args);//代理类的特点，调用原类的方法，加上一些系统的操作
                    long endTime = System.currentTimeMillis();
                    System.out.println(method.getName() + "():" +(startTime - endTime));
                    return rerult;
                }
            });
            proxy2.add("aaa");
            proxy2.add("bbb");
            proxy2.add("ccc");
            System.out.println(proxy2.size());

            //抽取方法
            final ArrayList target = new ArrayList();
            Collection proxy3 = (Collection)getProxy(target,new MyAdvice());
            proxy3.add("eee");
            proxy3.add("ddd");
            System.out.println(proxy3.size());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static Object getProxy(final Object target,final Advice advice){
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.beforeMethod(method);
                Object result = method.invoke(target,args);
                advice.afterMethod(method);
                return result;
            }
        });
        return proxy;
    }
}