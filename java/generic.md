* 首先java中的泛型是伪泛型和python字典类似，因为在编译期的时候，JVM会**擦除类型数据**，所有的类型都是Object reference。\
导致JVM不会对泛型的作隐式编译检查（c++有; 即 T tar; tar.zhao\(\); 必须传入类型实现了zhao()才能编译通过。）\
也导致不能实例化。
* 不能以基本类型作类型参数
* 类型参数不能作为静态成员变量或者被静态方法调用。因为所有不同类型的的泛型类都是 class generic\<Object\>; 会被所有类型共享。
* 但是可以限制类型参数的范围，\<T extends super_class\> 。只能是其子类。


### 下面是一个例子解释vector， 其实是可以放各种类型的数据的。jvm在编译的时候都是编译成vector\<Object\>;




      import java.util.Vector;

      public class dddddddd {


        static class zhaojjj {
          public String toString() {
            return "zhaojjjjj";

          }
        }

        public static void main(String[] args) {

          Long a1 = (long) 10;
          Short b = (short) 8;

          Vector a = new Vector();
          a.add(a1);
          a.add(b);
          a.add(new zhaojjj());
          for (Object i : a) {
            System.out.println(i);
          }

        }
      }
