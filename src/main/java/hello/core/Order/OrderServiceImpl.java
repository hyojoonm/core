package hello.core.Order;

import hello.core.discount.DiscointPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPocliy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscointPolicy discointPolicy;
//    private final DiscointPolicy discointPolicy = new FixDiscountPolicy();
//    private final DiscointPolicy discointPolicy = new RateDiscountPocliy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discointPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
