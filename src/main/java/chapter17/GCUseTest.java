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
