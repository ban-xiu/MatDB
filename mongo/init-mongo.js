// 数据库初始化
  
// 切换到 admin 数据库
db = db.getSiblingDB("admin");
  
// 创建集合 matData
db.createCollection("matData");
  
// 创建集合 matTemplates
db.createCollection("matTemplates");
  
// 创建集合 matUsers
db.createCollection("matUsers");
  
// 创建用户 root
db.matUsers.insertOne({ username: "root", password: "root" });
  
// 创建用户 user
db.matUsers.insertOne({ username: "user", password: "user" });