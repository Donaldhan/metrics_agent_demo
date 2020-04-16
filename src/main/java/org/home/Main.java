package org.home;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * http://localhost:8006/metrics/list
 * @ClassName: Main
 * @Description:
 * @Author: Donaldhan
 * @Date: 2020-04-08 15:05
 */
public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    private final static String PORT_ARGS = "-p";
    public static void main(String[] args) {
        log.info("args is:{}", JSONObject.toJSONString(args));
        if(null != args && args.length%2 != 0){
            log.error("params is not match , please check the args, args:{}",args);
            return;
        }
        if(null != args && args.length%2 == 0){
            Map<String ,String> argsMap = new HashMap<String ,String>();
            for (int i=0 ; i< args.length; i=i+2){
                argsMap.put(args[i], args[i+1]);
            }
            if(argsMap.containsKey(PORT_ARGS)){
                Bootstrap.setHttpServerPort(argsMap.get(PORT_ARGS));
            }
        }

        log.info("start metrics...");
        Bootstrap.init();
        log.info("metrics servers is listen on :{}",Bootstrap.getHttpServerPort());
    }
}