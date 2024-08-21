package oop;

public class SinhVienVN extends SinhVien{
    private float trietHoc;

    public SinhVienVN(){
        super();
    }

    public SinhVienVN(float trietHoc){
        super();
        this.trietHoc = trietHoc;
    }

    @Override
    public void Xuat(){
        super.Xuat();
        System.out.println("Triet Hoc: " + trietHoc);
    }


}
