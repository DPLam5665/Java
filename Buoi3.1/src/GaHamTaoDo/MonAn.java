package GaHamTaoDo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonAn {
    private List<ThucPham> array;
    public MonAn (){
        this.array = new ArrayList<>();
    }

    public void nhap(){
        System.out.println("Moi ban nhap ga");
        ThucPham ga = new Ga();
        ga.nhap();
        this.array.add(ga);

        System.out.println("Moi ban nhap hat sen");
        ThucPham hatsen = new HatSen();
        hatsen.nhap();
        this.array.add(hatsen);

        System.out.println("Moi ban nhap nam dong co");
        ThucPham nam = new NamDongCo();
        nam.nhap();
        this.array.add(nam);

        System.out.println("Moi ban nhap tao do");
        ThucPham tao = new TaoDo();
        tao.nhap();
        this.array.add(tao);

        System.out.println("Moi ban nhap ca rot");
        ThucPham carot = new CaRot();
        carot.nhap();
        this.array.add(carot);
    }

    public float tinhNangLuong(int flag){
        float tongNangLuong = 0;
        for (ThucPham a : this.array){
            switch (flag){
                case 1:
                    tongNangLuong += a.getKhoiLuong()/100f * a.getCarb();
                    break;
                case 2:
                    tongNangLuong += a.getKhoiLuong()/100f * a.getFat();
                    break;
                case 3:
                    tongNangLuong += a.getKhoiLuong()/100f * a.getFatBaoHoa();
                    break;
                case 4:
                    tongNangLuong += a.getKhoiLuong()/100f * a.getProtein();
                    break;
                case 5:
                    tongNangLuong += a.getKhoiLuong()/100f * a.getCalo();
                    break;
                default:
                    break;
            }
        }
        return tongNangLuong*0.8f;
    }

    public void cau2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap chi so carbonhydrate can thiet cho 1 bua an: ");
        int carb = sc.nextInt();
        float nangLuong = tinhNangLuong(1);
        if(carb > nangLuong){
            System.out.printf("\nCo the ban can them khoang %f gam Carbonhydrate nua\n",carb-nangLuong);
        }

        System.out.println("Moi ban nhap chi so chat beo can thiet cho 1 bua an: ");
        int fat = sc.nextInt();
        nangLuong = tinhNangLuong(2);
        if(fat > nangLuong){
            System.out.printf("\nCo the ban can them khoang %f gam chat beo nua\n",fat-nangLuong);
        }

        System.out.println("Moi ban nhap chi so chat beo bao hoa can thiet cho 1 bua an: ");
        int fatBaoHoa = sc.nextInt();
        nangLuong = tinhNangLuong(3);
        if(fatBaoHoa > nangLuong){
            System.out.printf("\nCo the ban can them khoang %f gam chat beo bao hoa nua\n",fatBaoHoa-nangLuong);
        }

        System.out.println("Moi ban nhap chi so Protein can thiet cho 1 bua an: ");
        int protein = sc.nextInt();
        nangLuong = tinhNangLuong(4);
        if(protein > nangLuong){
            System.out.printf("\nCo the ban can them khoang %f gam Protein nua\n",protein-nangLuong);
        }

        System.out.println("Moi ban nhap chi so Calo can thiet cho 1 bua an: ");
        int calo = sc.nextInt();
        nangLuong = tinhNangLuong(5);
        if(calo > nangLuong){
            System.out.printf("Co the ban can them khoang %f gam Calo nua\n",calo-nangLuong);
        }
    }
}
