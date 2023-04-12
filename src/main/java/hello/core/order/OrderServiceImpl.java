package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

  private  final MemberRepository memberRepository ;
 private final    DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memmberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memmberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return  new Order(memmberId,itemName,itemPrice,discountPrice);
  }
}
