package baiTap_docGia;

import java.util.Scanner;

public class DocGia_NguoiLon extends DocGia{
    private String so_CCCD;

    public DocGia_NguoiLon(){
        this.setGia(10000);
    }

    public String getSo_CCCD() {
        return so_CCCD;
    }

    public void setSo_CCCD(String so_CCCD) {
        this.so_CCCD = so_CCCD;
    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so can cuoc cong dan: ");
        this.so_CCCD = sc.nextLine();
        super.nhap();
    }

    public void xuat(){
        System.out.println("So can cuoc cong dan: " + this.so_CCCD);
        super.xuat();
    }

    @Override
    public long tinhTien(){
        return getGia()*getSoThang();
    }
}
