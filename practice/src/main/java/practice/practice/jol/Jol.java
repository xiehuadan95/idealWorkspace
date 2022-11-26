package practice.practice.jol;

import org.openjdk.jol.info.ClassLayout;

public class Jol {
    public static void main(String[] args) {
        Object o = new Object();
//        User o = new User();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("--------------------------");
    }
}
 /*
 OFF  SZ   TYPE DESCRIPTION               VALUE
  0   8        (object header: mark)     0x000000fb186ff5e8 (thin lock: 0x000000fb186ff5e8)
  8   4        (object header: class)    0xf80001e5
 12   4        (object alignment gap)
Instance size: 16 bytes
        * 0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
          8   4        (object header: class)    0xf800c143
          12   4    int User.age                  0
          Instance size: 16 bytes
* *//*  OFF  SZ                TYPE DESCRIPTION               VALUE
        0   8                     (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
        8   4                     (object header: class)    0xf800c143
        12   4                 int User.age                  0
        16   4    java.lang.String User.name                 (object)
        20   4   java.lang.Boolean User.person               null
        Instance size: 24 bytes
*//*
0   8                     (object header: mark)     0x00000010f65ff5b8 (thin lock: 0x00000010f65ff5b8)
  8   4                     (object header: class)    0xf800c143
 12   4                 int User.age                  0
 16   4    java.lang.String User.name                 (object)
 20   4   java.lang.Boolean User.person               null
 24   4      java.lang.Long User.score                null
 28   4                     (object alignment gap)
Instance size: 32 bytes
*/


