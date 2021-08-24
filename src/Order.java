import java.util.ArrayList;

public class Order {
   ArrayList<String> alMobile;
   ArrayList<String> alMenu;
   ArrayList<Integer> alCount;
   ArrayList<Integer> alTotal;
   
   Order() {
      this.alMobile = new ArrayList<String>();
      this.alMenu = new ArrayList<String>();
      this.alCount = new ArrayList<Integer>();
      this.alTotal = new ArrayList<Integer>();
   }
   
   int addOrder(String name, int cost, int cnt) {
      // 주문메뉴명 추가
      this.alMenu.add(name);
      // 주문수량 추가
      this.alCount.add(cnt);
      // 합계 비용(메뉴가격*수량) 추가
      this.alTotal.add(cost*cnt);
      // 합계 비용 리턴
      return cost*cnt;
   }
   
   int getTotalSum() {
      // 주문리스트의 총액을 모두 더해서 합계를 반환
      int sum = 0;
      for(int i=0; i<alMenu.size(); i++) {
         sum += alTotal.get(i);
      }
      return sum;
   }
   
   void getMobile(String mobile) {
      for(int i=0; i<alMenu.size(); i++) {
         alMobile.add(mobile);
      }
   }
   
   void orderList() {
      int sum = 0;
      for(int i=0; i<alMenu.size(); i++) {
         sum += alTotal.get(i);
         System.out.println(alMenu.get(i)+" 총 "+alCount.get(i)+"잔 "+alTotal.get(i)+"원 입니다.");
      }
      System.out.println("합계는 "+ sum + " 원 입니다.");
   }
   
   void orderCheck() {
      System.out.println(alMenu);
      System.out.println(alCount);
      System.out.println(alTotal);
      System.out.println(alMobile);
   }
}