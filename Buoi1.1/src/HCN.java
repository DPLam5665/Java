public class HCN {
    public float dai;
    public float rong;
    public float chuvi(){
        return (dai + rong) * 2;
    };
    public float dientich(){
        return dai * rong;
    };
    public HCN(float d, float r){
        this.dai = d;
        this.rong = r;

    }
}
