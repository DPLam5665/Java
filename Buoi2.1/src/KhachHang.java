import java.util.Scanner;

public class KhachHang {
    private String ten_KH;
    private int so_CCCD;
    private int so_Thang;
    private Goi dichVu;

    public static void KhachHang (){

    }

    public int getSo_CCCD() {
        return so_CCCD;
    }

    public void setSo_CCCD(int so_CCCD) {
        this.so_CCCD = so_CCCD;
    }

    public String getTen_KH() {
        return ten_KH;
    }

    public void setTen_KH(String ten_KH) {
        this.ten_KH = ten_KH;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten khach hang: ");
        this.ten_KH = sc.nextLine();
        System.out.println("Nhap so can cuoc cong dan: ");
        this.so_CCCD = sc.nextInt();
        System.out.println("Nhap so thang: ");
        this.so_Thang = sc.nextInt();


        int flag = 1;
        System.out.println("Chon hinh thuc thanh vien: ");
        System.out.println("1.Premium");
        System.out.println("3.Dang ki khong thanh vien");
        System.out.println("4.Tam thoat");
        System.out.println("#########################");
        System.out.println("Moi ban nhap lua chon");
        flag = sc.nextInt();
        switch (flag){
            case 1:
                this.dichVu = new Goi_Premium();
                break;
            case 2:
                System.out.println("Moi ban nhap so luong lop muon dang ky: ");
                int soLop = sc.nextInt();
                this.dichVu = new Goi_Basic(soLop);
                break;
            case 3:
                this.dichVu = new Goi_NonMember();
                break;
            default:
                break;
        }
    }



    public void xuat() {
        System.out.println("Ten khach hang: " + this.ten_KH);
        System.out.println("So can cuoc cong dan: " + this.so_CCCD);
        System.out.println("So thang dang ki: " + this.so_Thang);
        System.out.println("Goi thanh vien da dang ki: " + this.dichVu);
        System.out.println("Tong tien: " + this.tinhTien());
    }

    public Long tinhTien(){
        return dichVu.tinhTien() * so_Thang;
    };


}
