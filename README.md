# ProjectHive
## Lệnh chạy demo
git clone https://github.com/mylinh01/ProjectHive.git

#### Trên máy Client 
Run file SpringBootWebApplication.java

#### Trên hệ thống Hive chạy các lệnh
cd ProjectHive/YouTubeDataAnalysis/src/main/resources/data

sh HiveCreateTable.sh

sh YoutubeAnalysis.sh “ip máy client”  8888 
