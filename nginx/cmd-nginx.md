## 在 `nginx` 目录下执行以下命令以构建前端 `Docker` 环境

### 构建前端 `nginx` 镜像

```Swift
docker build -f Dockerfile-nginx -t nginx .
```

### 构建并在自定义网络下运行容器

```Swift
docker run -d -p 8083:80 --network matdb --name nginx nginx
```

### 如果只需要本地运行 `APP.java` 测试，或者运行项目 `jar` 包

```Swift
docker run -d -p 8083:80 --name nginx nginx
```

### 此时可以选择配置数据卷方便调试

```Swift
docker run -d -p 8083:80 --name nginx -v 数据卷文件夹A路径:/usr/share/nginx/html -v 数据卷文件夹B路径:/etc/nginx/nginx.conf nginx
```