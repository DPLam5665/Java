package QuanLyDienLuc;

import java.util.Scanner;

public class KhachHang {
    protected String maKH;
    protected String tenKH;
    protected double chiSoCu;
    protected double chiSoMoi;


    public KhachHang(String maKH, double chiSoMoi, double chiSoCu, String tenKH) {
        this.maKH = maKH;
        this.chiSoMoi = chiSoMoi;
        this.chiSoCu = chiSoCu;
        this.tenKH = tenKH;
    }

    public void HoaDon(){

    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public double getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(double chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public double getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(double chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }


    public KhachHang nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi nhap ma khach hang: ");
        this.maKH = sc.nextLine();
        System.out.println("Moi nhap ten khach hang: ");
        this.tenKH = sc.nextLine();
        System.out.println("Moi nhap chi so cu: ");
        this.chiSoCu = sc.nextDouble();
        System.out.println("Moi nhap chi so moi: ");
        this.chiSoMoi = sc.nextDouble();

        int flag = 1;
        System.out.println("Chon loai hoa don: ");
        System.out.println("1.Ho binh thuong ");
        System.out.println("2.Ho kinh doanh ");
        flag = sc.nextInt();
        switch (flag) {
            case 1:
                return new HoBinhThuong();
            case 2:
                return new HoKinhDoanh();
            default:
                return new HoBinhThuong();
        }
    }

    public void xuat(){
        System.out.println("Ma khach hang: " + this.maKH);
        System.out.println("Ten khach hang: " + this.tenKH);
    }

    public void thanhToan() {
        System.out.println("running...");
    }
}
