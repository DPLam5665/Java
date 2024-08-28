package QuanLyDienLuc;

import java.util.Scanner;

public class HoBinhThuong extends KhachHang {
    private double soKWTieuThu = this.getChiSoMoi() - this.getChiSoCu();
    private long tienDien =  (long)(soKWTieuThu * 3000);
    private long thueGTGT = tienDien / 10 * 1;
    private long M1 = 1500;
    private long M2 = 2000;
    private long M3 = 2800;

    long tongTienThanhToan;

    public HoBinhThuong(String maKH, double chiSoMoi, double chiSoCu, String tenKH) {
        super(maKH, chiSoMoi, chiSoCu, tenKH);
    }

//    public void nhap(){
//
//    }




    public void thanhToan() {
        super.thanhToan();
        if(soKWTieuThu <= 50 && soKWTieuThu >= 0 ){
            tienDien = (long) (soKWTieuThu * M1);
        }else if(soKWTieuThu > 50 && soKWTieuThu <= 100 ){
            tienDien = (long) (50 * M1 + (soKWTieuThu - 50) * M2);
        }else{
            tienDien = (long) (50 * M1 + 50 * M2 + (soKWTieuThu - 100) * M3);
        }
        tongTienThanhToan = thueGTGT + tienDien;
        System.out.println("Tong tien can thanh toan la: " + this.tongTienThanhToan);
    }

}
