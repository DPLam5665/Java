
import baiTap_docGia.*;
public class main2{
    public static void main (String[]args) {
        DanhSach_DocGia a=new DanhSach_DocGia();
        a.nhap();
        a.xuat();
        System.out.println("Tổng tiền = "+a.tinhTien());

    }
}

