package com.sls.products.service.dto;

import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.sls.products.domain.Products} entity.
 */
public class ProductsDTO implements Serializable {
    
    private Long id;

    @NotNull
    private Integer productid;

    @NotNull
    private Integer shopifyproductid;

    @NotNull
    private Integer shopifyvariantid;

    @NotNull
    private Integer imageid;

    private String sku;

    private Double price;

    private Double salesprice;

    private Double handlingcharges;

    private Double transactioncharges;

    private Double compareatprice;

    private Double weight;

    private String barcode;

    private Integer trackinventory;

    private Integer quantity;

    private String requiresshipping;

    private ZonedDateTime dateadd;

    private ZonedDateTime dateupd;

    private Double chargetaxes;

    private String dimension;

    private String inventorypolicy;

    private Integer idparent;

    private String combinations;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getShopifyproductid() {
        return shopifyproductid;
    }

    public void setShopifyproductid(Integer shopifyproductid) {
        this.shopifyproductid = shopifyproductid;
    }

    public Integer getShopifyvariantid() {
        return shopifyvariantid;
    }

    public void setShopifyvariantid(Integer shopifyvariantid) {
        this.shopifyvariantid = shopifyvariantid;
    }

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(Double salesprice) {
        this.salesprice = salesprice;
    }

    public Double getHandlingcharges() {
        return handlingcharges;
    }

    public void setHandlingcharges(Double handlingcharges) {
        this.handlingcharges = handlingcharges;
    }

    public Double getTransactioncharges() {
        return transactioncharges;
    }

    public void setTransactioncharges(Double transactioncharges) {
        this.transactioncharges = transactioncharges;
    }

    public Double getCompareatprice() {
        return compareatprice;
    }

    public void setCompareatprice(Double compareatprice) {
        this.compareatprice = compareatprice;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getTrackinventory() {
        return trackinventory;
    }

    public void setTrackinventory(Integer trackinventory) {
        this.trackinventory = trackinventory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRequiresshipping() {
        return requiresshipping;
    }

    public void setRequiresshipping(String requiresshipping) {
        this.requiresshipping = requiresshipping;
    }

    public ZonedDateTime getDateadd() {
        return dateadd;
    }

    public void setDateadd(ZonedDateTime dateadd) {
        this.dateadd = dateadd;
    }

    public ZonedDateTime getDateupd() {
        return dateupd;
    }

    public void setDateupd(ZonedDateTime dateupd) {
        this.dateupd = dateupd;
    }

    public Double getChargetaxes() {
        return chargetaxes;
    }

    public void setChargetaxes(Double chargetaxes) {
        this.chargetaxes = chargetaxes;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getInventorypolicy() {
        return inventorypolicy;
    }

    public void setInventorypolicy(String inventorypolicy) {
        this.inventorypolicy = inventorypolicy;
    }

    public Integer getIdparent() {
        return idparent;
    }

    public void setIdparent(Integer idparent) {
        this.idparent = idparent;
    }

    public String getCombinations() {
        return combinations;
    }

    public void setCombinations(String combinations) {
        this.combinations = combinations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductsDTO productsDTO = (ProductsDTO) o;
        if (productsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), productsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ProductsDTO{" +
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
