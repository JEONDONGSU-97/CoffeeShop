import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu { // 선언(정의) only. not 실행코드 
   private ArrayList<String> alName;
   private ArrayList<Integer> alPrice;
   
   Menu() {
      alName=new ArrayList<String>();
      alPrice=new ArrayList<Integer>();
      this.load();
   }   
//      addName("Americano");
//      addName("Espresso");
//      addName("Latte   ");
//      addPrice(2000);
//      addPrice(2500);
//      addPrice(3000);
      
//      showMenu();
   
   /* 생성자 - 일종의 메소드
    *         용도: 주로 초기화 작업용. 
              명명법: 이름이 클래스와 같아야 함.
              반환값: 반환값이 없다.(반환할 수 없이, 작업만 실행)
              실행/호출: new연산자가 실행된 직후, 자동실행
              다른 메소드/생성자를 호출할 수 있다.
   */
   void addName(String name) {
      this.alName.add(name);
   }
   
   void addPrice(int price) {
      this.alPrice.add(price);
   }
   
   void addPrice(String price) {
      this.alPrice.add(Integer.parseInt(price));
   }
   String getName(String menu_num) {
      return this.alName.get(Integer.parseInt(menu_num)-1);
   }
   int getPrice(String menu_num) {
      return this.alPrice.get(Integer.parseInt(menu_num)-1);
   }
   
   void appendMenu(Scanner sc1,Scanner sc2) {
      System.out.println("새 메뉴명:");
//      Scanner sc1 = new Scanner(System.in);
      String new_menu = sc1.nextLine();
      if(new_menu==null || new_menu.equals("")) {
         System.out.println("메뉴명이 비어있습니다.");
         return;         
      }
      System.out.println("새 가격:");
//      Scanner sc2 = new Scanner(System.in);
      int new_price = sc2.nextInt();
      if(new_price<0) {
         System.out.println("가격이 유효하지 않습니다.");
         return;
      }
      this.addName(new_menu);
      this.addPrice(new_price);
      System.out.println("새 메뉴가 추가 됐습니다.");
   }
   
   void changeMenu(Scanner sc1, Scanner sc2 ) {
      System.out.println("수정할 메뉴 번호:");
//      Scanner sc2 = new Scanner(System.in);
      int ch_num = sc2.nextInt();
      if(ch_num<1 || ch_num>this.alName.size()) {
         System.out.println("메뉴 번호가 올바르지 않습니다.");
         return;
      }
      System.out.println("새 메뉴명:");
//      Scanner sc1 = new Scanner(System.in);
      String new_menu = sc1.nextLine();
      if(new_menu==null || new_menu.equals("")) {
         System.out.println("메뉴명이 비어있습니다.");
         return;         
      }
      System.out.println("새 가격:");
      int new_price = sc2.nextInt();
      if(new_price<0) {
         System.out.println("가격이 유효하지 않습니다.");
         return;
      }
      this.alName.set(ch_num-1, new_menu);
      this.alPrice.set(ch_num-1, new_price);
      System.out.println("새 메뉴로 대체 됐습니다."); 
   }
   
   void deleteMenu(Scanner sc2) {
     System.out.println("삭제할 메뉴 번호:");
//     Scanner sc2 = new Scanner(System.in);
      int del_menu_num = sc2.nextInt();
      if(del_menu_num<1 || del_menu_num>this.alName.size()) {
         System.out.println("메뉴길이보다 큰 번호가 입력됐습니다.");
         return;
      }
      this.alName.remove(del_menu_num-1);
      System.out.println("메뉴 삭제 완료");
   }
   
   void showMenu() {
      for(int i=0;i<this.alName.size();i++) {
         System.out.println((i+1)+" "+this.alName.get(i)+"\t"+this.alPrice.get(i));
      }
   }
   
   void save() { //arraylist alName,alPrice를 파일(menu.txt)에 저장
      String fileNm = "c:/temp/menu.txt";
        try{
        File file = new File(fileNm);
        FileWriter fileWrite = new FileWriter(file, false);
        for(int i=0; i<alName.size(); i++) {
           fileWrite.write(alName.get(i)+","+alPrice.get(i)+"\n");
        }
        fileWrite.flush(); 
        fileWrite.close();
        } catch (Exception e){
        e.printStackTrace(); 
        }
   }
   
   void load() { //파일(menu.txt)을 읽어서 arraylist alName,alPrice에 로드.
      File file = new File("c:/temp/menu.txt");
      if(file.exists()) {
         BufferedReader inFile = null;
         try {
            inFile = new BufferedReader(new FileReader(file));
         } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         String line;
         try {
            line = inFile.readLine();
            while(line!=null) {
               String[] parts = line.split(",");
               addName(parts[0]);
               addPrice(parts[1]);
               line = inFile.readLine();
            }
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
   }
}