package test;




//import org.openqa.selenium.chrome.ChromeDriver;

public class test_selenium {

  public static void main(String[] args) {
    String potolok="2.7 v";
String d="";
       for(int i=0;i<potolok.length();i++){
         if(potolok.charAt(i)==' ')
           break;
           d+=potolok.charAt(i);
       }
       System.out.println(d+"kl");

  }
}
