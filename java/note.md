#### basic concepts
* boxing and unboxing
  - boxing : put a basic type into a class
  - unboxing : translate a class into a basic type
#### classloader

* AppClassLoader->ExtClassLoader->BootStrapClassLoader

#### 加载流程
* 加载
* 链接
  - 验证
  - 准备
  - 解析
* 初始化


#### 装包和解包

* 将基本类型装包为类，将类解包为基本类型。 目前jvm已实现自动装解包
* integerCache类中会有-128-127的integer类缓存。
* ==号针对基本类型比较值，针对类比较引用。
integer(100) == integer(100) true
integer(200) == integer(200) false

