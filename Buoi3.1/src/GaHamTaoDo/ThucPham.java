package GaHamTaoDo;

import java.util.Scanner;

public class ThucPham {
    protected int carb;
    protected int fat;
    protected int fatBaoHoa;
    protected int protein;
    protected int calo;
    protected int khoiLuong;

    public ThucPham(){

    }

    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap khoi luong: ");
        this.khoiLuong = sc.nextInt();
    }


    public int getCarb() {
        return carb;
    }

    public void setCarb(int carb) {
        this.carb = carb;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getFatBaoHoa() {
        return fatBaoHoa;
    }

    public void setFatBaoHoa(int fatBaoHoa) {
        this.fatBaoHoa = fatBaoHoa;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCalo() {
        return calo;
    }

    public void setCalo(int calo) {
        this.calo = calo;
    }

    public int getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(int khoiLuong) {
        this.khoiLuong = khoiLuong;
    }
}
