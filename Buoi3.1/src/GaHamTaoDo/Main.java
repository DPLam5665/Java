package GaHamTaoDo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MonAn a = new MonAn();
        a.nhap();
        System.out.println(a.tinhNangLuong(1));
        System.out.println(a.tinhNangLuong(2));
        System.out.println(a.tinhNangLuong(3));
        System.out.println(a.tinhNangLuong(4));
        System.out.println(a.tinhNangLuong(5));
        a.cau2();
    }
}
