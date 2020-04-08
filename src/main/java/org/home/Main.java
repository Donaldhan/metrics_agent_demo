package org.home;

import java.util.logging.Logger;

/**
 * @ClassName: Main
 * @Description:
 * @Author: Donaldhan
 * @Date: 2020-04-08 15:05
 */
public class Main {
    private final static Logger log = Logger.getLogger("org.home.Main");
    public static void main(String[] args) {
        log.info("start metrics...");
        Bootstrap.init();
        log.info("metrics servers is listen on 8006");
    }
}