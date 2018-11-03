package zjh.codecraft.ioc;

/**
 * 对于应用程序来说，应该尽量减少对Sping Api的耦合程度，然而有些时候为了运用Spring所提供的一些功能，
 * 有必要让Bean了解Spring容器对其进行管理的细节信息，如让Bean知道在容器中是以那个名称被管理的，
 * 或者让Bean知道BeanFactory或者ApplicationContext的存在，也就是产让该Bean可以取得BeanFactory或者ApplicationContext的实例，
 * 如果Bean可以意识到这些对象，那么就可以在Bean的某些动作发生时，做一些如事件发布等操作。
 *
 * Spring提供一些Aware接口：
 * beanNameAware接口：如果某个bean需要访问配置文件中本身bean的id属性，这个Bean类通过实现该接口，在依赖关系确定之后，初始化方法之前，
 * 提供回调自身的能力，从而获得本身bean的id属性，该接口提供了void setBeanName(String name)方法实现，
 * 需要指出的是该方法的name参数就是该bean的id属性，加调该setBeanName方法可以让bean获取得自身的id属性
 *
 *
 * BeanFactoryAware接口：实现了BeanFactoryAware接口的bean，可以直接通过beanfactory来访问spring的容器，当该bean被容器创建以后，
 * 会有一个相应的beanfactory的实例引用，该接口有一个方法void setBeanFactory(BeanFactory beanFactory)方法通过这个方法的参数创建它的BeanFactory实例，
 * 实现了BeanFactoryAware接口，就可以让Bean拥有访问Spring容器的能力。
 * 缺点：导致代码与spring的api耦合在一起，这种方式不推荐。
 *
 * ApplicationContextAware接口：在Bean类被初始化后，将会被注入applicationContext实例，
 * 该接口有一个方法，setApplicationContext(ApplicationContext context),使用其参数context用来创建它的applicationContext实例，
 * 缺点：导致代码与spring的api耦合在一起，这种方式不推荐。
 *
 *
 * @author zhengjianhui on 11/2/18
 */
public interface Aware {
}
