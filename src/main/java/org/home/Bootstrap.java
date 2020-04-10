package org.home;



import com.alibaba.metrics.integrate.ConfigFields;
import com.alibaba.metrics.integrate.LoggerProvider;
import com.alibaba.metrics.integrate.MetricsIntegrateUtils;
import com.alibaba.metrics.rest.server.MetricsHttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName: Bootstrap
 * @Description:
 * @Author: Donaldhan
 * @Date: 2020-04-08 15:04
 */
public class Bootstrap {
    private final static Logger log = LoggerFactory.getLogger(Bootstrap.class);
    private static final String METRICS_CONFIG_FILE = "metrics-conf.properties";
    public static final String ALI_METRICS_HTTP_PORT = "com.alibaba.metrics.http.port";
    public static final String DEFAULT_PORT = "8006";
    private static  Properties config = new Properties();;
    /**
     *
     */
    private static MetricsHttpServer metricsHttpServer = null;
    /**
     *
     */
    public static void init() {
//        init(System.getProperty(ConfigFields.CONFIG_FILE_NAME));
        init(METRICS_CONFIG_FILE);
    }
    /**
     * @param configFile
     */
    public static void init(String configFile) {
        log.info("start init metrics config...");
        LoggerProvider.initLogger();
//        Properties config = MetricsIntegrateUtils.parsePropertiesFromFile(configFile);
        config = loadMetricsConfig();
        if (configFile != null) {
            config.setProperty(ConfigFields.CONFIG_FILE_NAME, configFile);
        }
        if (MetricsIntegrateUtils.isEnabled(config, "com.alibaba.metrics.http_server.start")) {
            startHttpServer();
        }
        MetricsIntegrateUtils.registerAllMetrics(config);
        log.info("init metrics config finish...");
    }

    /**
     *
     */
    private static Properties loadMetricsConfig(){
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(METRICS_CONFIG_FILE);
        try {
            config.load(inputStream);
//            System.setProperty(ALI_METRICS_HTTP_PORT, String.valueOf(config.getOrDefault(ALI_METRICS_HTTP_PORT, DEFAULT_PORT)));
        } catch (Exception e) {
            log.error("loadMetricsConfig error", e);
        }
        return config;
    }

    /**
     * @param port
     * @return
     */
    public static void setHttpServerPort(String port){
        System.setProperty(ALI_METRICS_HTTP_PORT, port);
    }

    /**
     * @return
     */
    public static String getHttpServerPort(){
          return   System.getProperty(ALI_METRICS_HTTP_PORT, DEFAULT_PORT);
    }
    /**
     *
     */
    private static void startHttpServer() {
        metricsHttpServer = new MetricsHttpServer();
        metricsHttpServer.start();
    }
    /**
     *
     */
    public static void destroy() {
        if (metricsHttpServer != null) {
            metricsHttpServer.stop();
        }
    }
}