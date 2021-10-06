
package com.situation.analysis.webservices.expenseinfo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.situation.analysis.webservices.expenseinfo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReadExpenseinfoResponse_QNAME = new QName("http://service.webservice.invoice.app.eweaver.com/", "readExpenseinfoResponse");
    private final static QName _ReadExpenseinfo_QNAME = new QName("http://service.webservice.invoice.app.eweaver.com/", "readExpenseinfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.situation.analysis.webservices.expenseinfo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReadExpenseinfo }
     * 
     */
    public ReadExpenseinfo createReadExpenseinfo() {
        return new ReadExpenseinfo();
    }

    /**
     * Create an instance of {@link ReadExpenseinfoResponse }
     * 
     */
    public ReadExpenseinfoResponse createReadExpenseinfoResponse() {
        return new ReadExpenseinfoResponse();
    }

    /**
     * Create an instance of {@link ReadExpenseinfoResult }
     * 
     */
    public ReadExpenseinfoResult createReadExpenseinfoResult() {
        return new ReadExpenseinfoResult();
    }

    /**
     * Create an instance of {@link ReadExpensesDetail }
     * 
     */
    public ReadExpensesDetail createReadExpensesDetail() {
        return new ReadExpensesDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadExpenseinfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.invoice.app.eweaver.com/", name = "readExpenseinfoResponse")
    public JAXBElement<ReadExpenseinfoResponse> createReadExpenseinfoResponse(ReadExpenseinfoResponse value) {
        return new JAXBElement<ReadExpenseinfoResponse>(_ReadExpenseinfoResponse_QNAME, ReadExpenseinfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadExpenseinfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.invoice.app.eweaver.com/", name = "readExpenseinfo")
    public JAXBElement<ReadExpenseinfo> createReadExpenseinfo(ReadExpenseinfo value) {
        return new JAXBElement<ReadExpenseinfo>(_ReadExpenseinfo_QNAME, ReadExpenseinfo.class, null, value);
    }

}
