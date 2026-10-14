package TDA;

public class Auto {
    private String marcaAuto;
    private String colorAuto;
    private String modeloAuto;
    private float tamAuto;


    public Auto() {

    }
    public Auto(String marcaAuto, String colorAuto, String modeloAuto, float tamAuto) {
     this.marcaAuto=marcaAuto;
     this.colorAuto=colorAuto;
     this.modeloAuto=modeloAuto;
     this.tamAuto=tamAuto;
    }


    //Encapsulamiento
    public void setMarcaAuto(String marcaAuto){
        this.marcaAuto=marcaAuto;
    }
    
    public void setColorAuto(String colorAuto){

        this.colorAuto = colorAuto;
    }
    public void setModeloAuto(String modeloAuto)
    {
        this.modeloAuto = modeloAuto;

    }
    public void setTamAuto(float tamAuto)
    {
        this.tamAuto = tamAuto;

    }

    //Converitr el objeto a cadena
    //Uso el metodo tostring conecta con los atributos
    public String informacion(){
        return "Auto [marca=" + marcaAuto + ", colorAuto=" + colorAuto + "," + "modeloAuto="
                + modeloAuto + ", tamAuto=" + tamAuto + "]";
    }
}
