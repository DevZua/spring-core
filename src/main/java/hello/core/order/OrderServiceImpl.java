package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 추상화에만 의존

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId); // 멤버를 찾는다.
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일 책임 원칙을 지킨 것. 할인할 때 멤버를 넘긴다.

        return new Order(memberId, itemName, itemPrice, discountPrice); // 최종 생성된 주문을 반환
    }
}
