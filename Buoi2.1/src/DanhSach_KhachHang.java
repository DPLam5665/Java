import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSach_KhachHang {
    Scanner sc = new Scanner(System.in);
    public List<KhachHang> array;

    public DanhSach_KhachHang(){
        this.array = new ArrayList<>();
    }

    public void nhap (){
        int soLuong;
        System.out.println("Moi ban nhap so luong khach hang: ");
        soLuong = sc.nextInt();
        for(int i = 0; i < soLuong; i++){
            KhachHang a = new KhachHang();
            a.nhap();
            array.add(a);
        }
    }

    public void xuat(){
        for(KhachHang a: this.array){
            a.xuat();
            System.out.println("Tinh tien: " + a.tinhTien());
        }
    }


}
