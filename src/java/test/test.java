package test;

import ec.org.camariweb.entidades.clsCliente;
import ec.org.camariweb.entidades.clsDfacturaProducto;
import ec.org.camariweb.entidades.clsFactura;
import ec.org.camariweb.entidades.clsProducto;
import ec.org.camariweb.funciones.crudCliente;
import ec.org.camariweb.funciones.crudDfactura_producto;
import ec.org.camariweb.funciones.crudFactura;
import ec.org.camariweb.funciones.crudProducto;


public class test {
    public static void main(String[] args) {
        clsCliente a=new clsCliente(0,"1802015196","rocby","Shell");
//        crudCliente b=new crudCliente();
//        b.save(a);
        clsProducto p=new clsProducto(1,"chupete",12,0.3);
//        crudProducto p1=new crudProducto();
//        p1.save(p);
        clsFactura f=new clsFactura(1,a,null,12,0.12,13);  
//        crudFactura f1=new crudFactura();
//        f1.save(f);
        clsDfacturaProducto df=new clsDfacturaProducto(0,f,p,232,325);
        crudDfactura_producto df1=new crudDfactura_producto();
        df1.save(df);
    }
}
