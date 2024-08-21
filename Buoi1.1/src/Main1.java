import oop.SinhVien;

public class Main1 {
    public static void main (String[] args){
        SinhVien Lan = new SinhVien();
        Lan.Xuat();
        SinhVien Dat = new SinhVien("Dat", 4, 5);
        Dat.Xuat();
        System.out.println("DTB: " + Dat.dtb());
        System.out.println("DTB Lan va Dat: " + Lan.dtb(Dat));
        System.out.println("DTB Lan va Dat: " + Lan.dtb(Dat,Lan));
    }
}
