## 创建 `MongoDB` 数据库容器

### 拉取镜像

```Shell
docker pull mongo:6.0.8
```

### 初始化

容器内默认有数据卷挂载点： `/data/db` 用于存储数据信息与日志信息， `/data/configdb` 用于存储副本集和分片集群的配置信息。

创建并运行容器，同时配置了数据卷：

```Shell
docker run -d --name mongo -v 数据卷文件夹 A 路径:/data/db -v 数据卷文件夹 B 路径:/data/configdb -p 27017:27017 mongo:6.0.8 --auth
```

或者不配置数据卷：

```Shell
docker run -d --name mongo -p 27017:27017 mongo:6.0.8 --auth
```

使用自定义网络需要加上:

```
--network matdb
```

### 进入容器中的 `admin` 数据库

```Shell
docker exec -it mongo mongosh admin
```

### 查看当前数据库

```Shell
db
```

### 查看用户信息

```Shell
show users
```

### 创建 `root` 管理员

进入容器的 `admin` 数据库后，如果没有 `root` 管理员：

```Shell
db.createUser({user:"root",pwd:"root",roles:[{role:"root",db:"admin"}]})
```

### 登录

进入容器的 `admin` 数据库后：

```Shell
db.auth("root","root")
```

### 查看当前数据库中的所有集合

登录成功后：

```Shell
show collections
```

### 创建 `matData` 集合

如果 `admin` 数据库中不存在 `matData` 集合：

```Shell
db.createCollection("matData")
```

### 创建 `matTemplates` 集合

如果 `admin` 数据库中不存在 `matTemplates` 集合：

```Shell
db.createCollection("matTemplates")
```

### 创建 `matUsers` 集合

如果 `admin` 数据库中不存在 `matUsers` 集合：

```Shell
db.createCollection("matUsers")
```

### 查看 `matUsers` 集合中的所有内容

```Shell
db.matUsers.find()
```

### 创建 `root` 账户

如果 `matUsers` 集合中不存在 `root` 用户：

```Shell
db.matUsers.insertOne({username:"root", password:"root"})
```

### 创建 `user` 账户

如果 `matUsers` 集合中不存在 `user` 用户：

```Shell
db.matUsers.insertOne({username:"user", password:"user"})
```
