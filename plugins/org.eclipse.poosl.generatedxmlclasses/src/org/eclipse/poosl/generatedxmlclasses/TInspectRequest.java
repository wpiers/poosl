//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.11.16 at 11:04:04 AM CET 
//

package org.eclipse.poosl.generatedxmlclasses;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for t_inspect_request complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="t_inspect_request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="name" type="{uri:poosl}t_instance_name"/>
 *           &lt;element name="type" type="{uri:poosl}t_inspect_type"/>
 *         &lt;/sequence>
 *         &lt;element name="handle" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "t_inspect_request", propOrder = { "name", "type", "handle" })
public class TInspectRequest {

    protected String name;

    @XmlSchemaType(name = "string")
    protected TInspectType type;

    protected BigInteger handle;

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link TInspectType }
     * 
     */
    public TInspectType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *            allowed object is {@link TInspectType }
     * 
     */
    public void setType(TInspectType value) {
        this.type = value;
    }

    /**
     * Gets the value of the handle property.
     * 
     * @return possible object is {@link BigInteger }
     * 
     */
    public BigInteger getHandle() {
        return handle;
    }

    /**
     * Sets the value of the handle property.
     * 
     * @param value
     *            allowed object is {@link BigInteger }
     * 
     */
    public void setHandle(BigInteger value) {
        this.handle = value;
    }

}