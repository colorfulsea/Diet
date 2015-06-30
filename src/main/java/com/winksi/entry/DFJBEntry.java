package com.winksi.entry;

import com.winksi.util.DFJBParse;

/**
 * Created by zhoulei on 2014/12/8.
 */
public class DFJBEntry {
    public static void main(String[] args) throws InterruptedException {
        DFJBParse dfjbEntry = new DFJBParse();

        dfjbEntry.startParse();
        while(DFJBParse.threadPoolTaskExecutor.getActiveCount() != 0){
            Thread.sleep(1000);
        }

        System.out.println("程序结束");
    }
}
