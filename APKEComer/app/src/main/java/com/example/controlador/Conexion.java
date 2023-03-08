package com.example.controlador;

public class Conexion {
    private static String ip="172.56.0.160";
    private static String domin="PHPEComer";
    private static String Serv="Servicio";

    public static String getUrl(String cons){
        return "http://"+ip+"/"+domin+"/"+Serv+"/"+cons;
    }

    public static String getUrlImg(String foto) {
        return "http://" + ip + "/" + domin + "/" + Serv + "/IMG/IMGProducto/"+foto;
    }
}
