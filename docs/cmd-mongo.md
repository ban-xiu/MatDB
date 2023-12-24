## 在 `mongo` 目录下执行以下命令以构建 `MongoDB` 数据库 `Docker` 环境

初始化工作相当于 [init-mongo](init-mongo.md) 中的内容。

### 构建 `mongo` 镜像

```Shell
docker build -f Dockerfile-mongo -t mongo .
```

### 构建容器并在自定义网络下运行

```Shell
docker run -d -p 27017:27017 --network matdb --name mongo mongo
```

### 如果只需要本地运行 `APP.java` 测试，或者运行项目 `jar` 包

```Shell
docker run -d -p 27017:27017 --name mongo mongo
```

### 配置数据卷

数据卷挂载点 `/data/db` 用于存储数据信息与日志信息， `/data/configdb` 用于存储副本集和分片集群的配置信息。

如果需要配置数据卷，应该加上：

```
-v 数据卷文件夹 A 路径:/data/db -v 数据卷文件夹 B 路径:/data/configdb
```