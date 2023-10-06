# MatDB

## 一个快速构建的材料模板数据库。

### 前端基于：jquery bootstrap axios jsmol等。
### 后端基于：springboot mongodb等。

## 1.创建数据库

### 拉取镜像
docker pull mongo:6.0.8

### 初始化
docker run -itd --name mongo -v 数据卷文件夹路径:/data/db -p 27017:27017 mongo:6.0.8 --auth

容器名字为：mongo，同时配置了数据卷实现数据持久化，容器端口为：27017

### 进入容器中的admin数据库
docker exec -it mongo mongosh admin

### 查看当前数据库
db

### 查看用户信息
show users

### 创建root用户
进入容器的admin数据库后，如果没有root用户：db.createUser({user:"root",pwd:"root",roles:[{role:"root",db:"admin"}]})

### 登录
进入容器的admin数据库后：db.auth("root","root")

### 查看当前数据库中的所有集合
登录成功后：show collections

### 创建mongodata集合
如果admin数据库中不存在mongodata集合：db.createCollection("mongodata")

### 创建templatedata集合
如果admin数据库中不存在templatedata集合：db.createCollection("templatedata")

### 创建matusers集合
如果admin数据库中不存在matusers集合：db.createCollection("matusers")

### 查看matusers集合中的所有内容
db.matusers.find()

### 创建root账户
如果matusers集合中不存在root账户：db.matusers.insertOne({username:"root", password:"root"})

### 创建user账户
如果matusers集合中不存在user账户：db.matusers.insertOne({username:"user", password:"user"})

## 2.启动项目
保证数据库正常连接，通过maven更新pox.xml文件中的依赖后，运行APP.java，访问127.0.0.1:8080即可。


