# MatDB

## 一个快速构建的材料模板数据库

- 前端基于：`jQuery` `Bootstrap` 等
- 后端基于：`SpringBoot` `MongoDB` 等

## 1. 基于 `Docker-Compose` 快速创建服务

在项目根目录下，按 [build](./build.md) 的要求操作即可。

## 2. 测试与手动创建服务

### ① 创建数据库 `MongoDB` 服务

在 `mongo` 目录下，按 [cmd-mongo](./mongo/cmd-mongo.md) 的要求操作即可。

### ② 创建后端 `SpringBoot` 服务

在项目根目录下，按 [cmd-app](./cmd-app.md) 的要求操作即可。

### ③ 创建前端 `Nginx` 服务

在 `nginx` 目录下，按 [cmd-nginx](./nginx/cmd-nginx.md) 的要求操作即可。

## 3. 开始使用

各服务运行成功后，访问 `127.0.0.1:8083` 即可。

这里 [use](./use.md) 是详细的使用说明。

## 4. 开发环境

`Maven: 3.9.3`

`Docker: 23.0.5`

`Docker-Compose: 2.17.3`


