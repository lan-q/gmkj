package com.boczj.gmkj.service;

import com.boczj.gmkj.domain.QueryDTO;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class BatchQueryService {

    @Resource
    AsyncTask asyncTask;

    public HashMap countAndCode(QueryDTO queryDTO){
        HashMap<String, String> ans = new HashMap<>();
        if (queryDTO.getTestFlag().equals("1")){
            ans.put("code","20241111");
            ans.put("count","9");
        }else{
            ans.put("code","20242222");
            ans.put("count","20");
        }
        return ans;
    }

    public void pdfGen(QueryDTO queryDTO,HashMap ans) throws InterruptedException {
        String  count = (String) ans.get("count");
        int Num = Integer.parseInt(count);

        HashMap<String, String> dataBO = new HashMap<>();
        dataBO.put("test1","1");
        dataBO.put("test2","2");
        List<HashMap> dataBolist = new ArrayList<>();
        if (queryDTO.getTestFlag().equals("1")){
            dataBolist.add(dataBO);
        }


        for (int i = 0;i<Num;i++){
            asyncTask.pdfGen(i);
        }

    }

}
