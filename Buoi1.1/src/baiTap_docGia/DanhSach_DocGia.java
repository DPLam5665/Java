package baiTap_docGia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSach_DocGia {
    public List<DocGia> array;

    public DanhSach_DocGia(){
        this.array = new ArrayList<>();
    }

    public void nhap(){
//        DocGia a = new DocGia_TreEm();
//        a.nhap();
//        array.add(a);
//
//        DocGia b = new DocGia_TreEm();
//        b.nhap();
//        array.add(b)
//
        int flag = 1;
        System.out.println("1.Nhap doc gia tre em");
        System.out.println("2.Nhap doc gia nguoi lon");
        System.out.println("3.Exit");
        System.out.println("#########################");

        while(true){
            System.out.println("Moi ban nhap lua chon");
            Scanner sc = new Scanner(System.in);
            flag = sc.nextInt();
            DocGia a    ;
        }
    }

    public void xuat(){
        for(DocGia d: this.array){
            d.xuat();
        }
    }

    public long tinhTien(){
        long tong = 0;
        for(DocGia d: this.array){
            tong += d.tinhTien();
        }
        return tong;
    }


}
