package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefilServiceTest {


    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefilService statefilService1 = ac.getBean(StatefilService.class);
        StatefilService statefilService2 = ac.getBean(StatefilService.class);

        //A사용자 만원 주문
        int userAPrice = statefilService1.order("userA", 10000);
        //B사용자 만원 주문
        int userBPrice = statefilService2.order("userB", 20000);


        //ThreadA: A사용자 주문 금액 조회
//        int price = statefilService1.getPrice();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(statefilService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefilService statefulService() {
            return new StatefilService();
        }
    }

}