## 在 `nginx` 目录下执行以下命令以构建 `Nginx` 前端 `Docker` 环境

### 构建 `nginx` 镜像

```
docker build -f Dockerfile-nginx -t nginx .
```

### 构建容器并在自定义网络下运行

```
docker run -d -p 8083:80 --network matdb --name nginx nginx
```

### 如果只需要本地运行 `APP.java` 测试，或者运行项目 `jar` 包

```
docker run -d -p 8083:80 --name nginx nginx
```

### 配置数据卷

如 `Dockerfile-nginx` 所示，数据卷挂载点 `/usr/share/nginx/html` 包含了前端页面， `/etc/nginx` 包含了 `nginx.conf` 配置文件。 

为了方便调试，可以配置数据卷：

```
-v 数据卷文件夹 A 路径: /usr/share/nginx -v 数据卷文件夹 B 路径: /etc/nginx
```
