##Spring注解场景分类
###Spring模式注解

| Spring注解    |     场景说明      | 起始版本 |
| :------------ | :---------------: | :------: |
| @Repository   | 数据仓储模式注解  |   2.0    |
| @Component    | 通用组件模式注解  |   2.5    |
| @Service      |  服务层模式注解   |   2.5    |
| @Controller   | Web控制层模式注解 |   2.5    |
| @Configration |   配置模式注解    |   3.0    |

### Spring装配注解

| Spring注解      | 场景说明                                | 起始版本 |
| --------------- | --------------------------------------- | -------- |
| @ImportResource | 替换xml元素<import/>                    | 2.5      |
| @Import         | 限定@Autowired依赖注入范围              | 2.5      |
| @ComponentScan  | 扫描指定package下标注Spring模式注解的类 | 3.1      |

### Spring依赖注入注解

| Spring注解   | 场景说明                           | 起始版本 |
| ------------ | ---------------------------------- | -------- |
| @Autowired   | Bean依赖注入，支持多种依赖查找方式 | 2.5      |
| @Qualifier   | 细粒度的@Autowired依赖查找         | 2.5      |
| **Java注解** | **场景说明**                       | 起始版本 |
| @Resource    | Bean依赖注入方式，仅支持按名称查找 | 2.5      |

