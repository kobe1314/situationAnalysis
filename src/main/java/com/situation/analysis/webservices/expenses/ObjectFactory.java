
package com.situation.analysis.webservices.expenses;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.situation.analysis.webservices.expenses package. 
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

    private final static QName _SearchExpenses_QNAME = new QName("http://service.webservice.invoice.app.eweaver.com/", "searchExpenses");
    private final static QName _SearchExpensesResponse_QNAME = new QName("http://service.webservice.invoice.app.eweaver.com/", "searchExpensesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.situation.analysis.webservices.expenses
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchExpensesResponse }
     * 
     */
    public SearchExpensesResponse createSearchExpensesResponse() {
        return new SearchExpensesResponse();
    }

    /**
     * Create an instance of {@link SearchExpenses }
     * 
     */
    public SearchExpenses createSearchExpenses() {
        return new SearchExpenses();
    }

    /**
     * Create an instance of {@link ExpensesResult }
     * 
     */
    public ExpensesResult createExpensesResult() {
        return new ExpensesResult();
    }

    /**
     * Create an instance of {@link ExpensenDetail }
     * 
     */
    public ExpensenDetail createExpensenDetail() {
        return new ExpensenDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchExpenses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.invoice.app.eweaver.com/", name = "searchExpenses")
    public JAXBElement<SearchExpenses> createSearchExpenses(SearchExpenses value) {
        return new JAXBElement<SearchExpenses>(_SearchExpenses_QNAME, SearchExpenses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchExpensesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservice.invoice.app.eweaver.com/", name = "searchExpensesResponse")
    public JAXBElement<SearchExpensesResponse> createSearchExpensesResponse(SearchExpensesResponse value) {
        return new JAXBElement<SearchExpensesResponse>(_SearchExpensesResponse_QNAME, SearchExpensesResponse.class, null, value);
    }

}
