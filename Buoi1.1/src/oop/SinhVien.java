package oop;

public class SinhVien {
    private String ten;
    private float toan;
    private float van;

    public SinhVien () {

    }

    public SinhVien(String ten, float toan, float van){
        this.ten = ten;
        this.toan = toan;
        this.van = van;
    }

    public String getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten = ten;
    }

    public float getToan(){
        return toan;
    }

    public void setToan(float toan){
        this.toan = toan;
    }

    public float getVan(){
        return van;
    }

    public void setVan(float van){
        this.van = van;
    }

    public void Xuat () {
        System.out.print("Ho Ten: " + this.ten + "Toan: " + this.toan + "Van: " + this.van);
    }

    public float dtb () {
        return (this.toan + this.van)/2;
    }

    public float dtb (SinhVien a){
        return (this.dtb() + a.dtb())/2;
    }

    public float dtb (SinhVien a, SinhVien b){
        return (this.dtb() + a.dtb() + b.dtb()) / 3;
    }
}


