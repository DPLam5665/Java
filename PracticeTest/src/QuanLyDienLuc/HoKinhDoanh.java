package QuanLyDienLuc;

import java.util.Scanner;

public class HoKinhDoanh extends KhachHang {
    private double soKWTieuThu;
    private long tienDien =  (long)(soKWTieuThu * 3000);
    private long thueGTGT = tienDien / 10 * 1;
    private long tienUuDai;
    private int loaiCongTy;
    long tongTienThanhToan;

    public double tinhSoKWTieuThu(){
        return (this.getChiSoMoi() - this.getChiSoCu());
    }

    public void nhapCongTy(){
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Hay nhap loai cong ty: ");
        System.out.println("1.Cong ty nha nuoc ");
        System.out.println("2.Cong ty tu nhan ");
        this.loaiCongTy = sc.nextInt();
        switch (loaiCongTy){
            case 1:
                this.tienUuDai = tienDien / 5 * 1;
                break;
            case 2:
                this.tienUuDai = 0;
                break;
            default:
                this.tienUuDai = 0;
        }
    }


    public void thanhToan() {
        super.thanhToan();
        tongTienThanhToan = thueGTGT + tienDien - tienUuDai;
        System.out.println("Tong tien can thanh toan la: " + this.tongTienThanhToan);
    }
}
