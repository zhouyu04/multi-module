package com.zzyy.rs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>gridData complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="gridData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="records" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="rows" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gridData", propOrder = {
    "page",
    "total",
    "records",
    "rows"
})
public class GridData
    implements Serializable
{

    protected int page;
    protected int total;
    protected long records;
    @XmlElement(nillable = true)
    protected List<Object> rows;

    /**
     * 获取page属性的值。
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置page属性的值。
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

    /**
     * 获取total属性的值。
     * 
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置total属性的值。
     * 
     */
    public void setTotal(int value) {
        this.total = value;
    }

    /**
     * 获取records属性的值。
     * 
     */
    public long getRecords() {
        return records;
    }

    /**
     * 设置records属性的值。
     * 
     */
    public void setRecords(long value) {
        this.records = value;
    }

    /**
     * Gets the value of the rows property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rows property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRows().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRows() {
        if (rows == null) {
            rows = new ArrayList<Object>();
        }
        return this.rows;
    }

}
