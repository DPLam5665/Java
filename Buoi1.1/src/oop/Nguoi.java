package oop;

public interface Nguoi {
    void noinhieu();
    default void dungDienThoaiTronglop(){
        System.out.println("1 vai hoc vien co dau hieu su dung dien thoai trong gio hoc");
    }

}
