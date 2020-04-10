# metrics_demo
https://github.com/alibaba/metrics/wiki

# metric server
test metric agent demo  
https://github.com/Donaldhan/metrics_server_demo

## http接口查询
https://github.com/alibaba/metrics/wiki/query-from-http


启动程序，访问：http://localhost:8006/metrics/list

### 某个group下的所有metrics指标

http://localhost:8006/metrics/system

### 某一个group下指定的metrics   

http://localhost:8006/metrics/system/system.cpu.idle

## 初步想法
根据不同的ip进行打标tag处理，一般处理；

## DB选型

时序数据库，InfluxDB， TSDB， 关系数据mysql， nosql：Hbase

从技术栈和操作习惯上来看， 选择关系数据mysql


### 数据量大的问题的解决方案
针对数据量大的问题，只保留3个月的数据
