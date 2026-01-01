/**
 * LY.com Inc.
 * Copyright (c) 2004-2025 All Rights Reserved.
 */
package chapter17;

import java.util.ArrayList;

/**
 * GCUseTest
 * -XX:+PrintCommandLineFlags
 * -XX:+UseSerialGC 参数可以指定年轻代和老年代都使用串行收集器，等价于新生代用Serial GC且老年代用Serial Old收集器
 * -XX:+UseParNewGC 参数可以指定年轻代使用并行收集器，老年代使用Serial Old收集器
 *
 * -XX:+UseConcMarkSweepGC 参数可以指定年轻代使用并行收集器（ParNewGC），老年代使用CMS收集器
 * -XX:CMSLnitiatingOccupancyFraction=70 设置老年代使用CMS收集器的启动阈值为70%
 * -XX:+UseCMSCompactAtFullCollection 设置在CMS收集器进行Full GC时是否压缩碎片;停顿时间会增长
 * -XX:+CMSFullGCsBeforeCompaction 设置在CMS收集器进行Full GC时，多少次Full GC后进行压缩碎片
 * -XX:ParallelCMSThreads=4 设置CMS收集器的并发线程数为4
 * 
 * 二者可以相互激活：
 * -XX:+UseParallelGC 参数可以指定年轻代和老年代都使用并行收集器，等价于新生代用Parallel GC且老年代用Parallel Old收集器
 * -XX:+UseParallelOldGC 参数可以指定年轻代使用并行收集器，老年代使用Parallel Old收集器
 * -XX:MaxGCPauseMillis=200 设置最大暂停时间为200ms
 * -XX:GCTimeRatio=9 设置GC时间与程序运行时间的比例=1/(N+1)
 * 取值范围是0~99，默认值是99，表示GC时间占1%，程序运行时间占99%，不要超过99，否则会出现频繁GC，影响程序运行效率
 * -XX:+UseAdaptiveSizePolicy 开启自适应调整堆内存大小策略
 *
 * -XX:+UseG1GC 参数可以指定使用G1收集器
 * -XX:G1HeapRegionSize=16m 设置G1收集器的堆区域大小为16MB，取值范围是1MB~32MB，必须是2的N次方,目标是根据堆内存大小来设置区域大小，以保证区域数量在2048个左右；默认是堆内存的1/2048
 * -XX:MaxGCPauseMillis=200 设置最大暂停时间为200ms，jvm会尽力实现，但不保证一定能实现
 * -XX:ParallelGCThreads=8 设置并行GC线程数为8,最多设置为8
 * -XX:ConcGCThreads=4 设置并发GC线程数为4，最多设置为4
 * -XX:InitiatingHeapOccupancyPercent=45 设置G1收集器的并发标记周期的启动阈值为45%。默认值是45
 *
 * @author feixuanyu
 * @version 1.0.0
 * @since 2025-12-31 19:36
 */
public class GCUseTest {

    public static void main(String[] args) {

        ArrayList<byte[]> list = new ArrayList<>();

        while (true) {
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
