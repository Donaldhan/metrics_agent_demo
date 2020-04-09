package org.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * http://localhost:8006/metrics/list
 * @ClassName: Main
 * @Description:
 * @Author: Donaldhan
 * @Date: 2020-04-08 15:05
 */
public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("start metrics...");
        Bootstrap.init();
//        Bootstrap.init("metrics-conf.properties");
        log.info("metrics servers is listen on 8006");
    }
}