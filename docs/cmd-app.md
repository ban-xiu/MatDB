## 在项目根目录下执行以下命令以构建 `SpringBoot` 后端 `Docker` 环境

### 构建 `app` 镜像

```Shell
docker build -f Dockerfile-app -t app .
```

### 构建容器并在自定义网络下运行

```Shell
docker run -d -p 8080:8080 --network matdb --name app app
```

### 如果只需要本地运行 `APP.java` 测试，或者运行项目 `jar` 包

注意修改 `application.yml` 文件的 `host` 即可。
