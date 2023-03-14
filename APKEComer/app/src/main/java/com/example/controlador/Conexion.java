package com.example.controlador;

public class Conexion {
    private static String ip="192.168.1.105:8070";
    private static String domin="PHPEComer";
    private static String Serv="Servicio";

    public static String getUrl(String cons){
        return "http://"+ip+"/"+domin+"/"+Serv+"/"+cons;
    }

    public static String getUrlImg(String foto) {
        return "http://" + ip + "/" + domin + "/" + Serv + "/IMG/IMGProducto/"+foto;
    }
}
