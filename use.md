## 使用说明

### 用户与权限

- 默认有：用户名与密码同为 `root` 的用户，享有最高权限，可以 `查看和操作所有的数据库`
- 默认有：用户名与密码同为 `user` 的用户，受到限制，可以 `查看所有的数据库而不能操作任何数据库`
- 新注册的用户可以 `查看所有的数据库，但是只能操作自己的数据库`

### 模板数据库

可以基于以下模板快速构建数据库：

- 二维铁弹材料 `2D FEM` ，专有属性为：弹性转变势垒 `ETB(ev/atom)` ，标量
- 二维负泊松比材料 `2D NPB` ，专有属性为：最小泊松比 `NPR` ，标量
- 二维双极性磁性半导体材料 `BMS` ，专有属性为：`3` 个能带差 `Delta(ev)`，标量
- 二维五角形结构材料 `Penta` ，暂无专有属性
- 二维碳材料 `2D-Carbon` ，暂无专有属性

同时可以自定义模板：通过 `Self-defined` 实现。

在创建模板数据库时，可以 `新增` 专有属性和 `编辑` 已有的专有属性，具体来说，可以 `设置专有属性的名称与类型` 。

专有属性的类型分为：

- 标量 `Scalar`
- 矢量 `Vector`
- 张量 `Tensor`

其中矢量和张量必须满足一维矩阵或多维矩阵的标准形式以通过基于 `Tensorflow.js` 的校验。

数据库的共有属性有：

- 数据编号 `ID`
- VASP 结构`Structure`
- 结构公式 `Formula`
- 结构名称 `Name`
- 对称性 `Symmetry`
- 金属 `Metal`
- 带隙-PBE `Bandgap-PBE(ev)`
- 带隙-HSE `Bandgap-HSE(ev)`
- 参考文献识别符 `DOI`
- 参考文献地址 `URL`
- 参考文献发表时间 `Publication`

它们都是标量。

数据库创建成功后，可以执行以下操作：

- 增加数据
- 删除数据
- 修改数据
- 查看数据

增加数据时可以选择:

- 通过 `Add` 手动输入
- 通过 `File` 上传 `.xlsx` 文件 
- 通过 `File` 上传 `.json` 文件

删除数据时可以选择：

- 通过 `Delete` 删除单条数据
- 通过 `Burn` 删除整个数据库

可以通过 `Update` 修改数据内容。

可以通过 `Detail` 查看数据细节，包括基于 `JSmol` 的 `3D` 可交互图像，同时可以导出对应的 `.vasp` 文件和 `.json` 文件。
