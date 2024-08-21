package baiTap_docGia;

import java.sql.SQLOutput;
import java.util.Scanner;

public abstract class DocGia {
    private int soThang;
    private long gia;

    public DocGia() {
    }

    public int getSoThang() {
        return soThang;
    }

    public void setSoThang(int soThang) {
        this.soThang = soThang;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so tha thang: ");
        this.soThang = sc.nextInt();
    }

    public void xuat(){
        System.out.println("So thang la: " + this.soThang);
        System.out.println("Gia la: " + this.gia);
    }

    abstract long tinhTien();
}
