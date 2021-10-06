
package com.situation.analysis.webservices.error;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.situation.analysis.webservices.error package. 
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

    private final static QName _SendExpenseErrorResponse_QNAME = new QName("http://service.webservice.invoice.app.eweaver.com/", "sendExpenseErrorResponse");
    private final static QName _SendExpenseError_QNAME = new QName("http://service.webservice.invoice.app.eweaver.com/", "sendExpenseError");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.situation.analysis.webservices.error
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendExpenseError }
     * 
     */
    public SendExpenseError createSendExpenseError() {
        return new SendExpenseError();
    }

    /**
     * Create an instance of {@link SendExpenseErrorResponse }
     * 
     */
    public SendExpenseErrorResponse createSendExpenseErrorResponse() {
        return new SendExpenseErrorResponse();
    }

    /**
     * Create an instance of {@link SendExpenseResult }
     * 
     */
    public SendExpenseResult createSendExpenseResult() {
        return new SendExpenseResult();
    }

    /**
     * Create an instance of {@link InvoiceException }
     * 
     */
    public InvoiceException createInvoiceException() {
        return new InvoiceException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendExpenseErrorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.invoice.app.eweaver.com/", name = "sendExpenseErrorResponse")
    public JAXBElement<SendExpenseErrorResponse> createSendExpenseErrorResponse(SendExpenseErrorResponse value) {
        return new JAXBElement<SendExpenseErrorResponse>(_SendExpenseErrorResponse_QNAME, SendExpenseErrorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendExpenseError }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.invoice.app.eweaver.com/", name = "sendExpenseError")
    public JAXBElement<SendExpenseError> createSendExpenseError(SendExpenseError value) {
        return new JAXBElement<SendExpenseError>(_SendExpenseError_QNAME, SendExpenseError.class, null, value);
    }

}
