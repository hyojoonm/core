package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정정보 , 구성정보
@Configuration
public class AppConfig {

    //@Bean memberService - > new MemoryMemberRepository()

    //@Bean이 붙은 메서드마다 이미 스프링이 존재하며 존재하는 빈을 반환하고, 스프링 빈이 없으면
    // 생성해서 스프링 빈으로 등록하고 반환하는 코드가 동작으로 만들어진다.
    //덕분에 싱글토이 보장된다.
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return  new RateDiscountPolicy();
    }

}
