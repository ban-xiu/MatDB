## 在 `mongo` 目录下执行以下命令以构建 `MongoDB` 数据库 `Docker` 环境

初始化工作相当于 [init-mongo](init-mongo.md) 中的内容。

### 构建 `mongo` 镜像

```Swift
docker build -f Dockerfile-mongo -t mongo .
```

### 构建并在自定义网络下运行容器

```Swift
docker run -d -p 27017:27017 --network matdb --name mongo mongo
```

### 如果只需要本地运行 `APP.java` 测试，或者运行项目 `jar` 包

```Swift
docker run -d -p 27017:27017 --name mongo mongo
```

### 配置数据卷

数据卷挂载点 `/data/db` 包含了数据库内容与日志， `/data/configdb` 是数据库配置文件夹。

如果需要配置数据卷，应该加上：

```Swift
-v 数据卷文件夹 A 路径:/data/db -v 数据卷文件夹 B 路径:/data/configdb
```