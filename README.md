# MatDB

## 一个快速构建的材料模板数据库。

### 前端基于：jquery bootstrap axios jsmol等。
### 后端基于：springboot mogodb等。

## 1.创建数据库

### 拉取镜像
docker pull mongo:6.0.8

### 初始化
docker run -itd --name mongo -v 数据卷文件夹路径:/data/db -p 27017:27017 mongo --auth

容器名字为：mongo，同时配置了数据卷实现数据持久化，容器端口为：27017

### 进入容器的admin数据库
docker exec -it mongo mongosh admin

### 查看当前数据库
db

### 查看用户
show users

### 创建root用户
进入容器的admin数据库后，如果没有root用户：db.createUser({user:"root",pwd:"root",roles:[{role:"root",db:"root"}]})

### 登录
进入容器的admin数据库后：db.auth("root","root")

### 查看当前数据库下的所有集合
登录成功后：show collections

### 创建mongodata集合
如果不存在mongodata集合：db.createCollection("mongodata")

### 创建matusers集合
如果不存在matusers集合：db.createCollection("matusers")

### 创建templatedata集合
如果不存在templatedata集合：db.createCollection("templatedata")

## 2.启动项目
通过maven更新pox.xml文件中的依赖后，运行APP.java，访问127.0.0.1:8080即可。


