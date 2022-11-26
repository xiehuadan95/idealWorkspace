package practice.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS Compare And Swap(Compare And Exchange)自旋锁、乐观锁的实现，无锁（无重量锁）
 * 是一个轻量级锁，不需要经过操作系统就可以实现，不意味着一定快，
 * ABA问题，两个解决办法：
 * 通过版本号（AtomicStampedReference ，基础类型简单值不需要版本号,一种是数字 一种是 bollean
 */
class CasTest {
    // 原子操作
    AtomicInteger count = new AtomicInteger();
    /* synchronized */void method() {
        for (int i = 0; i < 1000; i++) {
      //进行自增操作 不需要加锁 底层用的CAS来实现，最后是native方法
            count.incrementAndGet();
            //最终 lock cmpxchg指令 ，通过lock来保证原子性（会用缓存锁 或者 总线锁）
         }
    }


}
