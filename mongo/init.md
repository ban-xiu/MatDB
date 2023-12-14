## 创建 `MongoDB` 数据库容器

### 拉取镜像

```Swift
docker pull mongo:6.0.8
```

### 初始化

```Swift
docker run -d --name mongo -v 数据卷文件夹A路径:/data/db -v 数据卷文件夹B路径:/data/configdb -p 27017:27017 mongo:6.0.8 --auth
```

容器名字为：mongo，同时配置了数据卷实现数据持久化，容器端口为：27017

### 或者不再配置数据卷

```Swift
docker run -d --name mongo -p 27017:27017 mongo:6.0.8 --auth
```

### 若要使用自定义网络需要加上

```Swift
--network matdb
```

### 进入容器中的 `admin` 数据库

```Swift
docker exec -it mongo mongosh admin
```

### 查看当前数据库

```Swift
db
```

### 查看用户信息

```Swift
show users
```

### 创建 `root` 用户

进入容器的 `admin` 数据库后，如果没有 `root` 用户：

```Swift
db.createUser({user:"root",pwd:"root",roles:[{role:"root",db:"admin"}]})
```

### 登录

进入容器的 `admin` 数据库后：

```Swift
db.auth("root","root")
```

### 查看当前数据库中的所有集合

登录成功后：

```Swift
show collections
```

### 创建 `matData` 集合

如果 `admin` 数据库中不存在 `matData` 集合：

```Swift
db.createCollection("matData")
```

### 创建 `matTemplates` 集合

如果 `admin` 数据库中不存在 `matTemplates` 集合：

```Swift
db.createCollection("matTemplates")
```

### 创建 `matUsers` 集合

如果 `admin` 数据库中不存在 `matUsers` 集合：

```Swift
db.createCollection("matUsers")
```

### 查看 `matUsers` 集合中的所有内容

```Swift
db.matUsers.find()
```

### 创建 `root` 账户

如果 `matUsers` 集合中不存在 `root` 账户：

```Swift
db.matUsers.insertOne({username:"root", password:"root"})
```

### 创建 `user` 账户

如果 `matUsers` 集合中不存在 `user` 账户：

```Swift
db.matUsers.insertOne({username:"user", password:"user"})
```
