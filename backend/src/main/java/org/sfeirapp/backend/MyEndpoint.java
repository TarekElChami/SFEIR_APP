package org.sfeirapp.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(name = "myApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.sfeirapp.org", ownerName = "backend.sfeirapp.org", packagePath=""))
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "getMonument")
    public MonumentBean getMonument(){
        MonumentBean monumentBean = new MonumentBean();
        monumentBean.setNomMonument("Arc de la Defense");
        monumentBean.setLieuMonument("La defense");
        monumentBean.setDescMonument("arc");

        return monumentBean;
    }

}
