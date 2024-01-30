package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    ;

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();// 모든 Bean 파일을 등록함.
        for (String beanDefinitionName : beanDefinitionNames) {  // key
            Object bean = ac.getBean(beanDefinitionName);  // value
            System.out.println("name = " + beanDefinitionName + ", object = " + bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();// 모든 Bean 파일을 등록함.
        for (String beanDefinitionName : beanDefinitionNames) {  // key
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);// Bean 하나하나에 대한 정보를 가져옴

            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // 내가 애플리케이션 등록하거나 외부에서 가져온 것
                Object bean = ac.getBean(beanDefinitionName);  // value
                System.out.println("name = " + beanDefinitionName + ", object = " + bean);
            }
            }


    }


}
