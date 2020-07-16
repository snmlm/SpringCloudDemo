# !/bin/bash
source /etc/profile
STORAGE_TYPE=mysql MYSQL_USER=root MYSQL_PASS=root MYSQL_HOST=10.168.8.67 MYSQL_TCP_PORT=3306 nohup java -jar zipkin-server-2.12.9-exec.jar --server.port=9411 &
pause