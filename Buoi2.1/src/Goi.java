public class Goi {
    protected Long phiCoban;
    protected Long phiLopHoc;
    protected Boolean phiXongHoi;
    protected Long phiPT;

    public Long tinhTien(){
        return phiCoban + phiLopHoc + phiPT;
    }


}
