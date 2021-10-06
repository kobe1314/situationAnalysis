
package com.situation.analysis.webservices.expenseinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>readExpenseinfoResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="readExpenseinfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.webservice.invoice.app.eweaver.com/}readExpenseinfoResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readExpenseinfoResponse", propOrder = {
    "_return"
})
public class ReadExpenseinfoResponse {

    @XmlElement(name = "return")
    protected ReadExpenseinfoResult _return;

    /**
     * 获取return属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReadExpenseinfoResult }
     *     
     */
    public ReadExpenseinfoResult getReturn() {
        return _return;
    }

    /**
     * 设置return属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReadExpenseinfoResult }
     *     
     */
    public void setReturn(ReadExpenseinfoResult value) {
        this._return = value;
    }

}
