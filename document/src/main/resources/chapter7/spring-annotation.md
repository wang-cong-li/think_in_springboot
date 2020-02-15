# Spring注解场景分类

### Spring模式注解

| Sp+ring注解   |     场景说明      | 起始版本 |
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

### Spring Bean定义注解

| Spring注解 | 场景说明                                  | 起始版本 |
| ---------- | ----------------------------------------- | -------- |
| @Bean      | 替换xml元素<bean>                         | 3.0      |
| @DependsOn | 替换xml属性<bean depends-on="">           | 3.0      |
| @Lazy      | 替换xml属性<bean lazy-init="true\|false"> | 3.0      |
| @Primary   | 替换xml属性<bean primary="true\|false">   | 3.0      |
| @Role      | 替换xml属性<bean role="">                 | 3.1      |
| @Lookup    | 替换xml属性<bean lookup-method="">        | 4.1      |

### Spring条件装配注解

| Spring注解   | 场景说明       | 起始版本 |
| ------------ | -------------- | -------- |
| @Conditional | 编程条件装配   | 3.1      |
| @Profile     | 配置化条件配置 | 3.1      |

### Spring配属属性注解

| Spring注解       | 场景说明                             | 起始版本 |
| ---------------- | ------------------------------------ | -------- |
| @PropertySource  | 配置属性抽象```PropertySource```注解 | 3.1      |
| @PropertySources | @PropertySource的集合属性            | 4.0      |

### Spring生命周期注解

| Spring注解     | 场景说明                                                    | 起始版本 |
| -------------- | ----------------------------------------------------------- | -------- |
| @PostConstruct | 替换xml元素<bean init-method="">或实现InitializingBean接口  | 2.5      |
| @PreDestory    | 替换xml元素<bean destory-method="">或实现DesposableBean接口 | 2.5      |

### Spring注解属性注解

| Spring注解 | 场景说明                     | 起始版本 |
| ---------- | ---------------------------- | -------- |
| @AliasFor  | 别名注解属性，实现复用的目的 | 4.2      |

### Spring性能注解

| Spring注解 | 场景说明                                           | 起始版本 |
| ---------- | -------------------------------------------------- | -------- |
| @Indexed   | 定义各个组件装配顺序，提升Spring模式注解的扫描效率 | 5.0      |

## Spring注解编程模型

主要议题如下

- 元注解，Meta Annotation
- Spring模式注解，Steretype Annotation
- Spring组合注解，Composed Annotation
- Spring注解属性别名和覆盖 Attribute Aliases and Overrides

### 元注解

指可以声明在其他注解上的注解。比如```@Documented```可以声明在所有的注解上的元注解，Java注解：````@Inherited```,```@Reeatable```，```@Rentation```,```@Target```等，Spring的```@Component```都是元注解，但是Spring的 ```@Component```注解在Spring注解编程模型中也叫Spring模式注解

### Spring模式注解

#### @Component注解"派生性"

Spring Framework 2.5新引入了XML元素```<context:component-scan/>```,而```@Controller```,```@Service```,```@Repository```,```@RestController```就是```@Component```的派生注解

示例代码：

[代码]: https://github.com/wang-cong-li/think_in_springboot/tree/master/springboot-2.x-samples/springboot-2.0.2.RELEASE

### @Component派生的原理

首先，在Spring2.X的时代，通过```<context:component-scan/>```元素来进行Component扫描，进而将Spring组件变成Spring的组件或Bean。

通过XML Schema,引入可扩展的XML编写（Extensible XML authoring）扩展机制，框架内建了```<context:component-scan/>```元素，该元素包含两部分信息:元素前缀context和local元素component-scan。根据XML Schema规范，元素前缀需要显式的关联命名空间（namespace），如XML配置文件中的 ```xmlns:context="http://www.springframework.org/schema/context"```.而命名空间是预先约定好的；同时，按照规范，元素XML Schema命名空间需要与处理类建立







