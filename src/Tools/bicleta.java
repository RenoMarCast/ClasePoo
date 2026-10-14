package Tools;

public class bicleta {
    private String marcaBicleta;
    private String tipoDeBicleta;
    private double costoBase;
    private double porcentajeMantenimineto;

    private bicleta(String marcaBicleta,String tipoDeBicleta
            ,double costoBase,double porcentajeMantenimineto) {
     this.marcaBicleta=marcaBicleta;
     this.tipoDeBicleta=tipoDeBicleta;
     this.costoBase=costoBase;
     this.porcentajeMantenimineto=porcentajeMantenimineto;
    }
}
