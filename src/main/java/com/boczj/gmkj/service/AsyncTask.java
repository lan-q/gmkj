package com.boczj.gmkj.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class AsyncTask {

    @Async("asyncPoolTaskExecutor")
    public void pdfGen(int i ) throws InterruptedException {

            log.info("开始处理第"+i+"个pdf");
        Thread.sleep(1200);
            log.info("处理完成第"+i+"个pdf");
    }
}
