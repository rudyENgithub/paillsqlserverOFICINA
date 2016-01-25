
package com.rudysorto.ws;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;







/**
 *
 * @author rsorto
 */
@Stateless
@Path("/guardarMM")
public class GuardarRegistrosMMWSRF {
    
    @GET
    public String guardarRegistrosMM(@QueryParam("req") String req) {
        System.out.println(req);
        return req;
    }
    
}
