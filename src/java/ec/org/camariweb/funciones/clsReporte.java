/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.org.camariweb.funciones;

import ec.org.camariweb.accesodatos.AccesoDatos;
import ec.org.camariweb.accesodatos.ConjuntoResultado;
import ec.org.camariweb.accesodatos.Parametro;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.funciones.crudCliente;
import java.util.ArrayList;

public class clsReporte {
    public ArrayList<clsFactura> mayorcf() {
        ArrayList<clsFactura> listado = new ArrayList<>();
        String sql = "SELECT  cliente.ruc, factura.clienteid,cliente.nombre,factura.fecha," +
        "  factura.total,factura.n FROM  public.cliente INNER JOIN public.factura ON" +
        "  cliente.id = factura.clienteid ";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsFactura factura = null;
            while (cres.next())
            {
                factura = new clsFactura();
                factura.setClienteid(crudCliente.findbyId(cres.getInt("cliente.id")));
                factura.setFecha(cres.getDate("fecha"));
                factura.setTotal(cres.getDouble("total"));
                factura.setN(cres.getInt("n"));
                listado.add((factura));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
}
