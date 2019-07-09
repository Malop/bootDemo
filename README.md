# bootDemo
the SpringBoot demo

+ Boot最好是以初衷不用xml的方式做配置，dubbo的服务注册与发现用@Service与@Reference注解的方式进行服务暴露与发现.
+ 但个人觉得用xml的方式在代码阅读性上更好点,只需配置dubbo-provider.xml并加载进去即可，bean的使用与在spring中的注解使用无差别。