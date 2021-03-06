
package com.freimanvs.company.soapjaxws.database.fromwsdl;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SalaryPort", targetNamespace = "http://database.soapjaxws.company.freimanvs.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SalaryPort {


    /**
     * 
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "max", targetNamespace = "http://database.soapjaxws.company.freimanvs.com/", className = "com.freimanvs.company.soapjaxws.database.fromwsdl.Max")
    @ResponseWrapper(localName = "maxResponse", targetNamespace = "http://database.soapjaxws.company.freimanvs.com/", className = "com.freimanvs.company.soapjaxws.database.fromwsdl.MaxResponse")
    public double max();

    /**
     * 
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "avg", targetNamespace = "http://database.soapjaxws.company.freimanvs.com/", className = "com.freimanvs.company.soapjaxws.database.fromwsdl.Avg")
    @ResponseWrapper(localName = "avgResponse", targetNamespace = "http://database.soapjaxws.company.freimanvs.com/", className = "com.freimanvs.company.soapjaxws.database.fromwsdl.AvgResponse")
    public double avg();

}
