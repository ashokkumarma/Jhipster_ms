package com.sls.products.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.ZonedDateTime;

/**
 * A Products.
 */
@Entity
@Table(name = "products")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "productid", nullable = false)
    private Integer productid;

    @NotNull
    @Column(name = "shopifyproductid", nullable = false)
    private Integer shopifyproductid;

    @NotNull
    @Column(name = "shopifyvariantid", nullable = false)
    private Integer shopifyvariantid;

    @NotNull
    @Column(name = "imageid", nullable = false)
    private Integer imageid;

    @Column(name = "sku")
    private String sku;

    @Column(name = "price")
    private Double price;

    @Column(name = "salesprice")
    private Double salesprice;

    @Column(name = "handlingcharges")
    private Double handlingcharges;

    @Column(name = "transactioncharges")
    private Double transactioncharges;

    @Column(name = "compareatprice")
    private Double compareatprice;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "trackinventory")
    private Integer trackinventory;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "requiresshipping")
    private String requiresshipping;

    @Column(name = "dateadd")
    private ZonedDateTime dateadd;

    @Column(name = "dateupd")
    private ZonedDateTime dateupd;

    @Column(name = "chargetaxes")
    private Double chargetaxes;

    @Column(name = "dimension")
    private String dimension;

    @Column(name = "inventorypolicy")
    private String inventorypolicy;

    @Column(name = "idparent")
    private Integer idparent;

    @Column(name = "combinations")
    private String combinations;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public Products productid(Integer productid) {
        this.productid = productid;
        return this;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getShopifyproductid() {
        return shopifyproductid;
    }

    public Products shopifyproductid(Integer shopifyproductid) {
        this.shopifyproductid = shopifyproductid;
        return this;
    }

    public void setShopifyproductid(Integer shopifyproductid) {
        this.shopifyproductid = shopifyproductid;
    }

    public Integer getShopifyvariantid() {
        return shopifyvariantid;
    }

    public Products shopifyvariantid(Integer shopifyvariantid) {
        this.shopifyvariantid = shopifyvariantid;
        return this;
    }

    public void setShopifyvariantid(Integer shopifyvariantid) {
        this.shopifyvariantid = shopifyvariantid;
    }

    public Integer getImageid() {
        return imageid;
    }

    public Products imageid(Integer imageid) {
        this.imageid = imageid;
        return this;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public String getSku() {
        return sku;
    }

    public Products sku(String sku) {
        this.sku = sku;
        return this;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public Products price(Double price) {
        this.price = price;
        return this;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalesprice() {
        return salesprice;
    }

    public Products salesprice(Double salesprice) {
        this.salesprice = salesprice;
        return this;
    }

    public void setSalesprice(Double salesprice) {
        this.salesprice = salesprice;
    }

    public Double getHandlingcharges() {
        return handlingcharges;
    }

    public Products handlingcharges(Double handlingcharges) {
        this.handlingcharges = handlingcharges;
        return this;
    }

    public void setHandlingcharges(Double handlingcharges) {
        this.handlingcharges = handlingcharges;
    }

    public Double getTransactioncharges() {
        return transactioncharges;
    }

    public Products transactioncharges(Double transactioncharges) {
        this.transactioncharges = transactioncharges;
        return this;
    }

    public void setTransactioncharges(Double transactioncharges) {
        this.transactioncharges = transactioncharges;
    }

    public Double getCompareatprice() {
        return compareatprice;
    }

    public Products compareatprice(Double compareatprice) {
        this.compareatprice = compareatprice;
        return this;
    }

    public void setCompareatprice(Double compareatprice) {
        this.compareatprice = compareatprice;
    }

    public Double getWeight() {
        return weight;
    }

    public Products weight(Double weight) {
        this.weight = weight;
        return this;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBarcode() {
        return barcode;
    }

    public Products barcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getTrackinventory() {
        return trackinventory;
    }

    public Products trackinventory(Integer trackinventory) {
        this.trackinventory = trackinventory;
        return this;
    }

    public void setTrackinventory(Integer trackinventory) {
        this.trackinventory = trackinventory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Products quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRequiresshipping() {
        return requiresshipping;
    }

    public Products requiresshipping(String requiresshipping) {
        this.requiresshipping = requiresshipping;
        return this;
    }

    public void setRequiresshipping(String requiresshipping) {
        this.requiresshipping = requiresshipping;
    }

    public ZonedDateTime getDateadd() {
        return dateadd;
    }

    public Products dateadd(ZonedDateTime dateadd) {
        this.dateadd = dateadd;
        return this;
    }

    public void setDateadd(ZonedDateTime dateadd) {
        this.dateadd = dateadd;
    }

    public ZonedDateTime getDateupd() {
        return dateupd;
    }

    public Products dateupd(ZonedDateTime dateupd) {
        this.dateupd = dateupd;
        return this;
    }

    public void setDateupd(ZonedDateTime dateupd) {
        this.dateupd = dateupd;
    }

    public Double getChargetaxes() {
        return chargetaxes;
    }

    public Products chargetaxes(Double chargetaxes) {
        this.chargetaxes = chargetaxes;
        return this;
    }

    public void setChargetaxes(Double chargetaxes) {
        this.chargetaxes = chargetaxes;
    }

    public String getDimension() {
        return dimension;
    }

    public Products dimension(String dimension) {
        this.dimension = dimension;
        return this;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getInventorypolicy() {
        return inventorypolicy;
    }

    public Products inventorypolicy(String inventorypolicy) {
        this.inventorypolicy = inventorypolicy;
        return this;
    }

    public void setInventorypolicy(String inventorypolicy) {
        this.inventorypolicy = inventorypolicy;
    }

    public Integer getIdparent() {
        return idparent;
    }

    public Products idparent(Integer idparent) {
        this.idparent = idparent;
        return this;
    }

    public void setIdparent(Integer idparent) {
        this.idparent = idparent;
    }

    public String getCombinations() {
        return combinations;
    }

    public Products combinations(String combinations) {
        this.combinations = combinations;
        return this;
    }

    public void setCombinations(String combinations) {
        this.combinations = combinations;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Products)) {
            return false;
        }
        return id != null && id.equals(((Products) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Products{" +
            "id=" + getId() +
            ", productid=" + getProductid() +
            ", shopifyproductid=" + getShopifyproductid() +
            ", shopifyvariantid=" + getShopifyvariantid() +
            ", imageid=" + getImageid() +
            ", sku='" + getSku() + "'" +
            ", price=" + getPrice() +
            ", salesprice=" + getSalesprice() +
            ", handlingcharges=" + getHandlingcharges() +
            ", transactioncharges=" + getTransactioncharges() +
            ", compareatprice=" + getCompareatprice() +
            ", weight=" + getWeight() +
            ", barcode='" + getBarcode() + "'" +
            ", trackinventory=" + getTrackinventory() +
            ", quantity=" + getQuantity() +
            ", requiresshipping='" + getRequiresshipping() + "'" +
            ", dateadd='" + getDateadd() + "'" +
            ", dateupd='" + getDateupd() + "'" +
            ", chargetaxes=" + getChargetaxes() +
            ", dimension='" + getDimension() + "'" +
            ", inventorypolicy='" + getInventorypolicy() + "'" +
            ", idparent=" + getIdparent() +
            ", combinations='" + getCombinations() + "'" +
            "}";
    }
}
