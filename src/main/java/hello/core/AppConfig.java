package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() { // 애플리케이션의 실제 동작에 필요한 구현 객체 생성
        return new MemberServiceImpl(memberRepository()); // 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해 주입(연결)해줌
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//      return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

//    public MemberService memberService() { // 애플리케이션의 실제 동작에 필요한 구현 객체 생성
//        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해 주입(연결)해줌
//    }
//
//    public OrderService orderService() {
//        return new OrderServiceImpl(
//                new MemoryMemberRepository(),
//                new FixDiscountPolicy());
//    }

