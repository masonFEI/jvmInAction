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
 * -XX:+UseConcMarkSweepGC 参数可以指定年轻代使用并行收集器，老年代使用CMS收集器
 * 
 * 二者可以相互激活：
 * -XX:+UseParallelGC 参数可以指定年轻代和老年代都使用并行收集器，等价于新生代用Parallel GC且老年代用Parallel Old收集器
 * -XX:+UseParallelOldGC 参数可以指定年轻代使用并行收集器，老年代使用Parallel Old收集器
 * -XX:MaxGCPauseMillis=200 设置最大暂停时间为200ms
 * -XX:GCTimeRatio=9 设置GC时间与程序运行时间的比例=1/(N+1)
 * 取值范围是0~99，默认值是99，表示GC时间占1%，程序运行时间占99%，不要超过99，否则会出现频繁GC，影响程序运行效率
 * -XX:+UseAdaptiveSizePolicy 开启自适应调整堆内存大小策略
 * 
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
