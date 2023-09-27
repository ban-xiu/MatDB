# MatDB

## 一个快速构建的材料模板数据库。

### 前端基于：jquery,bootstrap,axios,jsmol等。
### 后端基于：springboot,mogodb等。

## 1.创建数据库

### 拉取镜像
docker pull mongo:6.0.8

### 初始化
docker run -itd --name mongo -v 数据卷文件路径:/data/db -p 27017:27017 mongo --auth

### 进入容器并创建root用户
docker exec -it mongo mongosh admin

db.createUser({user:”root”,pwd:”root”,roles:[{role:”root”,db:”root”}]})

### 进入容器并连接数据库
docker exec -it mongo mongosh admin

db.auth(“root”,”root”)

## 2.启动项目
更新maven依赖后，运行APP.java，访问127.0.0.1:8080即可。


