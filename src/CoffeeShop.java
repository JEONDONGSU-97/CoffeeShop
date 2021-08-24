import java.util.Scanner;

public class CoffeeShop {

   public static void main(String[] args) {
      Menu menu=new Menu();
      //menu.showMenu();
      
      // "m": 메뉴관리
      // "o": 주문받기
      // "s": 실적보기
      // "x": 프로그램 종료.
      Scanner sc1 = new Scanner(System.in);
      Scanner sc2 = new Scanner(System.in);
      System.out.println("작업을 선택하시오 (m:메뉴관리,o:주문,s:실적보기,x:프로그램 종료)");
      String str = sc1.nextLine();
      
      while(!str.equals("x")) {
         switch(str) {
         case "m":
            System.out.println("메뉴관리");
            menu.showMenu();
            // CRUD (추가/수정/삭제)
            System.out.println("메뉴작업을 선택하시오. (c:추가,r:목록보기,u:수정,d:삭제,q:메뉴관리 종료)");
            str = sc1.nextLine();
            while(!str.equals("q")) {
               switch(str) {
               case "c":
                  menu.appendMenu(sc1,sc2);               
                  break;
               case "r":
                  menu.showMenu();
                  break;
               case "u":
                  menu.changeMenu(sc1,sc2);
                  break;
               case "d":
                  menu.deleteMenu(sc2);
                  break;
               }
               System.out.println("메뉴작업을 선택하시오. (c:추가,r:목록보기,u:수정,d:삭제,q:메뉴관리 종료)");
               str = sc1.nextLine();
            }
            menu.save();                  
            break;
         case "o":
            System.out.println("주문받기");
            menu.showMenu();
            Order order = new Order();
            // 출력 "메뉴번호를 선택하세요"
            System.out.println("메뉴 번호:");
            // 값을 읽는다.
            String menu_num = sc1.nextLine();
            // 메뉴번호가 ""이 아닌 동안
            int total_cost = 0;
            while(!menu_num.equals("")) {
               // 출력 "수량을 입력하세요"
               System.out.println("수량:");
               // 값(주문 수량)을 읽는다.
               int order_menu_count = sc2.nextInt();
               total_cost = order.addOrder(menu.getName(menu_num), menu.getPrice(menu_num), order_menu_count);
               System.out.println(menu.getName(menu_num)+": 총"+order_menu_count+"잔, "+total_cost+"원");
               // menu.showMenu();
               menu.showMenu();
               // 출력 "메뉴번호를 선택하세요"
               System.out.println("메뉴 번호:");
               // 값을 읽는다.
               menu_num = sc1.nextLine();
            }            
            // 전체총액: 9999999
            // 각 메뉴의 총액을 더한 전체총액을 출력(getTotatlSum())
            order.orderList();
            // 출력 "모바일번호를 입력하세요."
            System.out.println("모바일번호를 입력하세요.");
            // 주문고객의 모바일 번호 입력받는다.
            String mobile = sc1.nextLine();
            order.getMobile(mobile);
            order.orderCheck();
            // 실적에 추가한다.(나중에)
            break;
         case "s":
            System.out.println("실적보기");
            break;
         }
         System.out.println("작업을 선택하시오 (m:메뉴관리,o:주문,s:실적보기,x:프로그램 종료)");
         str = sc1.nextLine();               
      }
      System.out.println("프로그램 종료");
      sc1.close();
      sc2.close();
//      menu.load();
//      Scanner s1 = new Scanner(System.in);
//      Scanner s2 = new Scanner(System.in);
//      
//      System.out.println("메뉴명 입력:");
//      String name=s1.nextLine();
//      while(!name.equals("")) { // 빈 문자열 입력.
//         System.out.println("가격입력:");
//         int price = s2.nextInt();
//         menu.addName(name);
//         menu.addPrice(price);
//         System.out.println("메뉴명 입력:");
//         name=s1.nextLine();
//      }
//      System.out.println("메뉴목록");   
//      s1.close(); s2.close();      
   }
}