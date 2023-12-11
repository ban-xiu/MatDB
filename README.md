# MatDB

## 一个快速构建的材料模板数据库。

### 前端基于：jQuery Bootstrap Axios JSmol Tensorflow.js等。
### 后端基于：SpringBoot MongoDB等。

## 1.创建数据库

### 拉取镜像
docker pull mongo:6.0.8

### 初始化
docker run -itd --name mongo -v 数据卷文件夹路径:/data/db -p 27017:27017 mongo:6.0.8 --auth

容器名字为：mongo，同时配置了数据卷实现数据持久化，容器端口为：27017

### 进入容器中的 admin 数据库
docker exec -it mongo mongosh admin

### 查看当前数据库
db

### 查看用户信息
show users

### 创建 root 用户
进入容器的 admin 数据库后，如果没有 root 用户：db.createUser({user:"root",pwd:"root",roles:[{role:"root",db:"admin"}]})

### 登录
进入容器的 admin 数据库后：db.auth("root","root")

### 查看当前数据库中的所有集合
登录成功后：show collections

### 创建 matData 集合
如果 admin 数据库中不存在 matData 集合：db.createCollection("matData")

### 创建 matTemplates 集合
如果 admin 数据库中不存在 MatTemplates 集合：db.createCollection("matTemplates")

### 创建 matUsers 集合
如果 admin 数据库中不存在 matUsers 集合：db.createCollection("matUsers")

### 查看 matUsers 集合中的所有内容
db.matUsers.find()

### 创建 root 账户
如果 matUsers 集合中不存在root账户：db.matUsers.insertOne({username:"root", password:"root"})

### 创建 user 账户
如果 matUsers 集合中不存在user账户：db.matUsers.insertOne({username:"user", password:"user"})

## 2.创建前端 Nginx 服务
在 nginx 目录下，按 cmd.txt 的要求操作即可。

## 3.启动项目
保证数据库正常连接，通过 Maven（开发版本为3.9.3）更新 pox.xml 文件中的依赖后，运行 APP.java，访问127.0.0.1:8080即可。


