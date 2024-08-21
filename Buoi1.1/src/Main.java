import java.util.*;
public class Main{
    public static int Sum(int a , int b){
        return (a+b);
    };

    public static int inputNumber (String name){
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        int value = 0;
        while(!validInput){
              try {
                  float a = 0;
                  double b = 0;
                  System.out.printf("Nhap %s cua ban: " + name);
                  value = sc.nextInt();
                  sc.nextLine();
                  validInput = true;

              }
              catch (InputMismatchException e) {
                  System.out.println("Loi: Ban can nhap 1 so nguyen hop le!!");
                  sc.next();
            }
        }
        return value;
    }
    public static void zodiac(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hay nhap ngay sinh cua ban: ");
        int day = sc.nextInt();
        System.out.println("Hay nhap thang sinh cua ban: ");
        int month = sc.nextInt();
        System.out.print("Cung hoang dao cua ban la: ");
        switch (month){
            case 1:
                if (day<20){
                    System.out.printf("Capricorn");
                }else if(day>=20){
                    System.out.printf("Aquarius");
                }
                break;
            case 2:
                if (day<19){
                    System.out.printf("Aquarius");
                }else if(day>=19){
                    System.out.printf("Pisces");
                }
                break;
            case 3:
                if (day<21){
                    System.out.printf("Pisces");
                }else if(day>=20){
                    System.out.printf("Aries");
                }
                break;
            case 4:
                if (day<20){
                    System.out.printf("Aries");
                }else if(day>=20){
                    System.out.printf("Taurus");
                }
                break;
            case 5:
                if (day<21){
                    System.out.printf("Taurus");
                }else if(day>=21){
                    System.out.printf("Gemini");
                }
                break;
            case 6:
                if (day<21){
                    System.out.printf("Gemini");
                }else if(day>=21){
                    System.out.printf("Cancer");
                }
                break;
            case 7:
                if (day<23){
                    System.out.printf("Cancer");
                }else if(day>=23){
                    System.out.printf("Leo");
                }
                break;
            case 8:
                if (day<23){
                    System.out.printf("leo");
                }else if(day>=23){
                    System.out.printf("Virgo");
                }
                break;
            case 9:
                if (day<23){
                    System.out.printf("Virgo");
                }else if(day>=23){
                    System.out.printf("Libra");
                }
                break;
            case 10:
                if (day<23){
                    System.out.printf("Libra");
                }else if(day>=23){
                    System.out.printf("Scorpio");
                }
                break;
            case 11:
                if (day<22){
                    System.out.printf("Scorpio");
                }else if(day>=22){
                    System.out.printf("Sagittarius");
                }
                break;
            case 12:
                if (day<22){
                    System.out.printf("Sagittarius");
                }else if(day>=22){
                    System.out.printf("Capricorn");
                }
                break;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        String name;
//        try {
//            System.out.println("Hay nhap ten cua ban: ");
//            name = sc.nextLine();
//            System.out.println("Ten cua ban la: " + name);
//        }
//        catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        finally {
//            System.out.println("Code loi roi!");
//        }
//        System.out.println("Hay nhap tuoi cua ban: ");
//        int age = sc.nextInt();
//        System.out.println("Hay nhap chieu cao cua ban: ");
//        double height = sc.nextDouble();
//
//        System.out.println("Tuoi cua ban la: " + age);
//        System.out.println("Chieu cao cua ban la: " + height);


//        System.out.println("Hay so a : ");
//        int a = sc.nextInt();
//        System.out.println("Hay so b: ");
//        int b = sc.nextInt();
//        int kq;
//        kq = Sum(a,b);
//        System.out.println("a+b= " + kq);
//        System.out.println("a+b= " + (a+b));
//        System.out.println("a-b= " + (a-b));
//        System.out.println("a*b= " + (a*b));
//        System.out.println("a%b= " + (a%b));
//        System.out.println("a/b= " + (float)(a/b));
//        System.out.println("a/b= " + ((float)a/b));
//        System.out.println("a/b= " + (a/(float)b));
//        System.out.println("a/b= " + (a/(double)b));
//        System.out.println("a/b= " + (a*1.0/b));
//        System.out.println("a/b= " + (a/b*1.0));
//
        System.out.println("Nhap chieu dai hcn: ");
        int d = sc.nextInt();
        System.out.println("Nhap chieu rong hcn: ");
        int r = sc.nextInt();
        HCN a = new HCN(d,r);
        System.out.println("Chieu dai hcn la: " + a.dai);
        System.out.println("Chieu rong hcn la: " + a.rong);
        System.out.println("Chu vi hcn la: " + a.chuvi());
        System.out.println("Dien tich hcn la: " + a.dientich());
    }
}