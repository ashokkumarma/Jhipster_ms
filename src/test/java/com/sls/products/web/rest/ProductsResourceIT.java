package com.sls.products.web.rest;

import com.sls.products.ProductsApp;
import com.sls.products.domain.Products;
import com.sls.products.repository.ProductsRepository;
import com.sls.products.service.ProductsService;
import com.sls.products.service.dto.ProductsDTO;
import com.sls.products.service.mapper.ProductsMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static com.sls.products.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ProductsResource} REST controller.
 */
@SpringBootTest(classes = ProductsApp.class)

@AutoConfigureMockMvc
@WithMockUser
public class ProductsResourceIT {

    private static final Integer DEFAULT_PRODUCTID = 1;
    private static final Integer UPDATED_PRODUCTID = 2;

    private static final Integer DEFAULT_SHOPIFYPRODUCTID = 1;
    private static final Integer UPDATED_SHOPIFYPRODUCTID = 2;

    private static final Integer DEFAULT_SHOPIFYVARIANTID = 1;
    private static final Integer UPDATED_SHOPIFYVARIANTID = 2;

    private static final Integer DEFAULT_IMAGEID = 1;
    private static final Integer UPDATED_IMAGEID = 2;

    private static final String DEFAULT_SKU = "AAAAAAAAAA";
    private static final String UPDATED_SKU = "BBBBBBBBBB";

    private static final Double DEFAULT_PRICE = 1D;
    private static final Double UPDATED_PRICE = 2D;

    private static final Double DEFAULT_SALESPRICE = 1D;
    private static final Double UPDATED_SALESPRICE = 2D;

    private static final Double DEFAULT_HANDLINGCHARGES = 1D;
    private static final Double UPDATED_HANDLINGCHARGES = 2D;

    private static final Double DEFAULT_TRANSACTIONCHARGES = 1D;
    private static final Double UPDATED_TRANSACTIONCHARGES = 2D;

    private static final Double DEFAULT_COMPAREATPRICE = 1D;
    private static final Double UPDATED_COMPAREATPRICE = 2D;

    private static final Double DEFAULT_WEIGHT = 1D;
    private static final Double UPDATED_WEIGHT = 2D;

    private static final String DEFAULT_BARCODE = "AAAAAAAAAA";
    private static final String UPDATED_BARCODE = "BBBBBBBBBB";

    private static final Integer DEFAULT_TRACKINVENTORY = 1;
    private static final Integer UPDATED_TRACKINVENTORY = 2;

    private static final Integer DEFAULT_QUANTITY = 1;
    private static final Integer UPDATED_QUANTITY = 2;

    private static final String DEFAULT_REQUIRESSHIPPING = "AAAAAAAAAA";
    private static final String UPDATED_REQUIRESSHIPPING = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_DATEADD = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DATEADD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_DATEUPD = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DATEUPD = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Double DEFAULT_CHARGETAXES = 1D;
    private static final Double UPDATED_CHARGETAXES = 2D;

    private static final String DEFAULT_DIMENSION = "AAAAAAAAAA";
    private static final String UPDATED_DIMENSION = "BBBBBBBBBB";

    private static final String DEFAULT_INVENTORYPOLICY = "AAAAAAAAAA";
    private static final String UPDATED_INVENTORYPOLICY = "BBBBBBBBBB";

    private static final Integer DEFAULT_IDPARENT = 1;
    private static final Integer UPDATED_IDPARENT = 2;

    private static final String DEFAULT_COMBINATIONS = "AAAAAAAAAA";
    private static final String UPDATED_COMBINATIONS = "BBBBBBBBBB";

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductsMapper productsMapper;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProductsMockMvc;

    private Products products;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Products createEntity(EntityManager em) {
        Products products = new Products()
            .productid(DEFAULT_PRODUCTID)
            .shopifyproductid(DEFAULT_SHOPIFYPRODUCTID)
            .shopifyvariantid(DEFAULT_SHOPIFYVARIANTID)
            .imageid(DEFAULT_IMAGEID)
            .sku(DEFAULT_SKU)
            .price(DEFAULT_PRICE)
            .salesprice(DEFAULT_SALESPRICE)
            .handlingcharges(DEFAULT_HANDLINGCHARGES)
            .transactioncharges(DEFAULT_TRANSACTIONCHARGES)
            .compareatprice(DEFAULT_COMPAREATPRICE)
            .weight(DEFAULT_WEIGHT)
            .barcode(DEFAULT_BARCODE)
            .trackinventory(DEFAULT_TRACKINVENTORY)
            .quantity(DEFAULT_QUANTITY)
            .requiresshipping(DEFAULT_REQUIRESSHIPPING)
            .dateadd(DEFAULT_DATEADD)
            .dateupd(DEFAULT_DATEUPD)
            .chargetaxes(DEFAULT_CHARGETAXES)
            .dimension(DEFAULT_DIMENSION)
            .inventorypolicy(DEFAULT_INVENTORYPOLICY)
            .idparent(DEFAULT_IDPARENT)
            .combinations(DEFAULT_COMBINATIONS);
        return products;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Products createUpdatedEntity(EntityManager em) {
        Products products = new Products()
            .productid(UPDATED_PRODUCTID)
            .shopifyproductid(UPDATED_SHOPIFYPRODUCTID)
            .shopifyvariantid(UPDATED_SHOPIFYVARIANTID)
            .imageid(UPDATED_IMAGEID)
            .sku(UPDATED_SKU)
            .price(UPDATED_PRICE)
            .salesprice(UPDATED_SALESPRICE)
            .handlingcharges(UPDATED_HANDLINGCHARGES)
            .transactioncharges(UPDATED_TRANSACTIONCHARGES)
            .compareatprice(UPDATED_COMPAREATPRICE)
            .weight(UPDATED_WEIGHT)
            .barcode(UPDATED_BARCODE)
            .trackinventory(UPDATED_TRACKINVENTORY)
            .quantity(UPDATED_QUANTITY)
            .requiresshipping(UPDATED_REQUIRESSHIPPING)
            .dateadd(UPDATED_DATEADD)
            .dateupd(UPDATED_DATEUPD)
            .chargetaxes(UPDATED_CHARGETAXES)
            .dimension(UPDATED_DIMENSION)
            .inventorypolicy(UPDATED_INVENTORYPOLICY)
            .idparent(UPDATED_IDPARENT)
            .combinations(UPDATED_COMBINATIONS);
        return products;
    }

    @BeforeEach
    public void initTest() {
        products = createEntity(em);
    }

    @Test
    @Transactional
    public void createProducts() throws Exception {
        int databaseSizeBeforeCreate = productsRepository.findAll().size();

        // Create the Products
        ProductsDTO productsDTO = productsMapper.toDto(products);
        restProductsMockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isCreated());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeCreate + 1);
        Products testProducts = productsList.get(productsList.size() - 1);
        assertThat(testProducts.getProductid()).isEqualTo(DEFAULT_PRODUCTID);
        assertThat(testProducts.getShopifyproductid()).isEqualTo(DEFAULT_SHOPIFYPRODUCTID);
        assertThat(testProducts.getShopifyvariantid()).isEqualTo(DEFAULT_SHOPIFYVARIANTID);
        assertThat(testProducts.getImageid()).isEqualTo(DEFAULT_IMAGEID);
        assertThat(testProducts.getSku()).isEqualTo(DEFAULT_SKU);
        assertThat(testProducts.getPrice()).isEqualTo(DEFAULT_PRICE);
        assertThat(testProducts.getSalesprice()).isEqualTo(DEFAULT_SALESPRICE);
        assertThat(testProducts.getHandlingcharges()).isEqualTo(DEFAULT_HANDLINGCHARGES);
        assertThat(testProducts.getTransactioncharges()).isEqualTo(DEFAULT_TRANSACTIONCHARGES);
        assertThat(testProducts.getCompareatprice()).isEqualTo(DEFAULT_COMPAREATPRICE);
        assertThat(testProducts.getWeight()).isEqualTo(DEFAULT_WEIGHT);
        assertThat(testProducts.getBarcode()).isEqualTo(DEFAULT_BARCODE);
        assertThat(testProducts.getTrackinventory()).isEqualTo(DEFAULT_TRACKINVENTORY);
        assertThat(testProducts.getQuantity()).isEqualTo(DEFAULT_QUANTITY);
        assertThat(testProducts.getRequiresshipping()).isEqualTo(DEFAULT_REQUIRESSHIPPING);
        assertThat(testProducts.getDateadd()).isEqualTo(DEFAULT_DATEADD);
        assertThat(testProducts.getDateupd()).isEqualTo(DEFAULT_DATEUPD);
        assertThat(testProducts.getChargetaxes()).isEqualTo(DEFAULT_CHARGETAXES);
        assertThat(testProducts.getDimension()).isEqualTo(DEFAULT_DIMENSION);
        assertThat(testProducts.getInventorypolicy()).isEqualTo(DEFAULT_INVENTORYPOLICY);
        assertThat(testProducts.getIdparent()).isEqualTo(DEFAULT_IDPARENT);
        assertThat(testProducts.getCombinations()).isEqualTo(DEFAULT_COMBINATIONS);
    }

    @Test
    @Transactional
    public void createProductsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = productsRepository.findAll().size();

        // Create the Products with an existing ID
        products.setId(1L);
        ProductsDTO productsDTO = productsMapper.toDto(products);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProductsMockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkProductidIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setProductid(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkShopifyproductidIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setShopifyproductid(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkShopifyvariantidIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setShopifyvariantid(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkImageidIsRequired() throws Exception {
        int databaseSizeBeforeTest = productsRepository.findAll().size();
        // set the field null
        products.setImageid(null);

        // Create the Products, which fails.
        ProductsDTO productsDTO = productsMapper.toDto(products);

        restProductsMockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        // Get all the productsList
        restProductsMockMvc.perform(get("/api/products?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(products.getId().intValue())))
            .andExpect(jsonPath("$.[*].productid").value(hasItem(DEFAULT_PRODUCTID)))
            .andExpect(jsonPath("$.[*].shopifyproductid").value(hasItem(DEFAULT_SHOPIFYPRODUCTID)))
            .andExpect(jsonPath("$.[*].shopifyvariantid").value(hasItem(DEFAULT_SHOPIFYVARIANTID)))
            .andExpect(jsonPath("$.[*].imageid").value(hasItem(DEFAULT_IMAGEID)))
            .andExpect(jsonPath("$.[*].sku").value(hasItem(DEFAULT_SKU)))
            .andExpect(jsonPath("$.[*].price").value(hasItem(DEFAULT_PRICE.doubleValue())))
            .andExpect(jsonPath("$.[*].salesprice").value(hasItem(DEFAULT_SALESPRICE.doubleValue())))
            .andExpect(jsonPath("$.[*].handlingcharges").value(hasItem(DEFAULT_HANDLINGCHARGES.doubleValue())))
            .andExpect(jsonPath("$.[*].transactioncharges").value(hasItem(DEFAULT_TRANSACTIONCHARGES.doubleValue())))
            .andExpect(jsonPath("$.[*].compareatprice").value(hasItem(DEFAULT_COMPAREATPRICE.doubleValue())))
            .andExpect(jsonPath("$.[*].weight").value(hasItem(DEFAULT_WEIGHT.doubleValue())))
            .andExpect(jsonPath("$.[*].barcode").value(hasItem(DEFAULT_BARCODE)))
            .andExpect(jsonPath("$.[*].trackinventory").value(hasItem(DEFAULT_TRACKINVENTORY)))
            .andExpect(jsonPath("$.[*].quantity").value(hasItem(DEFAULT_QUANTITY)))
            .andExpect(jsonPath("$.[*].requiresshipping").value(hasItem(DEFAULT_REQUIRESSHIPPING)))
            .andExpect(jsonPath("$.[*].dateadd").value(hasItem(sameInstant(DEFAULT_DATEADD))))
            .andExpect(jsonPath("$.[*].dateupd").value(hasItem(sameInstant(DEFAULT_DATEUPD))))
            .andExpect(jsonPath("$.[*].chargetaxes").value(hasItem(DEFAULT_CHARGETAXES.doubleValue())))
            .andExpect(jsonPath("$.[*].dimension").value(hasItem(DEFAULT_DIMENSION)))
            .andExpect(jsonPath("$.[*].inventorypolicy").value(hasItem(DEFAULT_INVENTORYPOLICY)))
            .andExpect(jsonPath("$.[*].idparent").value(hasItem(DEFAULT_IDPARENT)))
            .andExpect(jsonPath("$.[*].combinations").value(hasItem(DEFAULT_COMBINATIONS)));
    }
    
    @Test
    @Transactional
    public void getProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        // Get the products
        restProductsMockMvc.perform(get("/api/products/{id}", products.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(products.getId().intValue()))
            .andExpect(jsonPath("$.productid").value(DEFAULT_PRODUCTID))
            .andExpect(jsonPath("$.shopifyproductid").value(DEFAULT_SHOPIFYPRODUCTID))
            .andExpect(jsonPath("$.shopifyvariantid").value(DEFAULT_SHOPIFYVARIANTID))
            .andExpect(jsonPath("$.imageid").value(DEFAULT_IMAGEID))
            .andExpect(jsonPath("$.sku").value(DEFAULT_SKU))
            .andExpect(jsonPath("$.price").value(DEFAULT_PRICE.doubleValue()))
            .andExpect(jsonPath("$.salesprice").value(DEFAULT_SALESPRICE.doubleValue()))
            .andExpect(jsonPath("$.handlingcharges").value(DEFAULT_HANDLINGCHARGES.doubleValue()))
            .andExpect(jsonPath("$.transactioncharges").value(DEFAULT_TRANSACTIONCHARGES.doubleValue()))
            .andExpect(jsonPath("$.compareatprice").value(DEFAULT_COMPAREATPRICE.doubleValue()))
            .andExpect(jsonPath("$.weight").value(DEFAULT_WEIGHT.doubleValue()))
            .andExpect(jsonPath("$.barcode").value(DEFAULT_BARCODE))
            .andExpect(jsonPath("$.trackinventory").value(DEFAULT_TRACKINVENTORY))
            .andExpect(jsonPath("$.quantity").value(DEFAULT_QUANTITY))
            .andExpect(jsonPath("$.requiresshipping").value(DEFAULT_REQUIRESSHIPPING))
            .andExpect(jsonPath("$.dateadd").value(sameInstant(DEFAULT_DATEADD)))
            .andExpect(jsonPath("$.dateupd").value(sameInstant(DEFAULT_DATEUPD)))
            .andExpect(jsonPath("$.chargetaxes").value(DEFAULT_CHARGETAXES.doubleValue()))
            .andExpect(jsonPath("$.dimension").value(DEFAULT_DIMENSION))
            .andExpect(jsonPath("$.inventorypolicy").value(DEFAULT_INVENTORYPOLICY))
            .andExpect(jsonPath("$.idparent").value(DEFAULT_IDPARENT))
            .andExpect(jsonPath("$.combinations").value(DEFAULT_COMBINATIONS));
    }

    @Test
    @Transactional
    public void getNonExistingProducts() throws Exception {
        // Get the products
        restProductsMockMvc.perform(get("/api/products/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        int databaseSizeBeforeUpdate = productsRepository.findAll().size();

        // Update the products
        Products updatedProducts = productsRepository.findById(products.getId()).get();
        // Disconnect from session so that the updates on updatedProducts are not directly saved in db
        em.detach(updatedProducts);
        updatedProducts
            .productid(UPDATED_PRODUCTID)
            .shopifyproductid(UPDATED_SHOPIFYPRODUCTID)
            .shopifyvariantid(UPDATED_SHOPIFYVARIANTID)
            .imageid(UPDATED_IMAGEID)
            .sku(UPDATED_SKU)
            .price(UPDATED_PRICE)
            .salesprice(UPDATED_SALESPRICE)
            .handlingcharges(UPDATED_HANDLINGCHARGES)
            .transactioncharges(UPDATED_TRANSACTIONCHARGES)
            .compareatprice(UPDATED_COMPAREATPRICE)
            .weight(UPDATED_WEIGHT)
            .barcode(UPDATED_BARCODE)
            .trackinventory(UPDATED_TRACKINVENTORY)
            .quantity(UPDATED_QUANTITY)
            .requiresshipping(UPDATED_REQUIRESSHIPPING)
            .dateadd(UPDATED_DATEADD)
            .dateupd(UPDATED_DATEUPD)
            .chargetaxes(UPDATED_CHARGETAXES)
            .dimension(UPDATED_DIMENSION)
            .inventorypolicy(UPDATED_INVENTORYPOLICY)
            .idparent(UPDATED_IDPARENT)
            .combinations(UPDATED_COMBINATIONS);
        ProductsDTO productsDTO = productsMapper.toDto(updatedProducts);

        restProductsMockMvc.perform(put("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isOk());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeUpdate);
        Products testProducts = productsList.get(productsList.size() - 1);
        assertThat(testProducts.getProductid()).isEqualTo(UPDATED_PRODUCTID);
        assertThat(testProducts.getShopifyproductid()).isEqualTo(UPDATED_SHOPIFYPRODUCTID);
        assertThat(testProducts.getShopifyvariantid()).isEqualTo(UPDATED_SHOPIFYVARIANTID);
        assertThat(testProducts.getImageid()).isEqualTo(UPDATED_IMAGEID);
        assertThat(testProducts.getSku()).isEqualTo(UPDATED_SKU);
        assertThat(testProducts.getPrice()).isEqualTo(UPDATED_PRICE);
        assertThat(testProducts.getSalesprice()).isEqualTo(UPDATED_SALESPRICE);
        assertThat(testProducts.getHandlingcharges()).isEqualTo(UPDATED_HANDLINGCHARGES);
        assertThat(testProducts.getTransactioncharges()).isEqualTo(UPDATED_TRANSACTIONCHARGES);
        assertThat(testProducts.getCompareatprice()).isEqualTo(UPDATED_COMPAREATPRICE);
        assertThat(testProducts.getWeight()).isEqualTo(UPDATED_WEIGHT);
        assertThat(testProducts.getBarcode()).isEqualTo(UPDATED_BARCODE);
        assertThat(testProducts.getTrackinventory()).isEqualTo(UPDATED_TRACKINVENTORY);
        assertThat(testProducts.getQuantity()).isEqualTo(UPDATED_QUANTITY);
        assertThat(testProducts.getRequiresshipping()).isEqualTo(UPDATED_REQUIRESSHIPPING);
        assertThat(testProducts.getDateadd()).isEqualTo(UPDATED_DATEADD);
        assertThat(testProducts.getDateupd()).isEqualTo(UPDATED_DATEUPD);
        assertThat(testProducts.getChargetaxes()).isEqualTo(UPDATED_CHARGETAXES);
        assertThat(testProducts.getDimension()).isEqualTo(UPDATED_DIMENSION);
        assertThat(testProducts.getInventorypolicy()).isEqualTo(UPDATED_INVENTORYPOLICY);
        assertThat(testProducts.getIdparent()).isEqualTo(UPDATED_IDPARENT);
        assertThat(testProducts.getCombinations()).isEqualTo(UPDATED_COMBINATIONS);
    }

    @Test
    @Transactional
    public void updateNonExistingProducts() throws Exception {
        int databaseSizeBeforeUpdate = productsRepository.findAll().size();

        // Create the Products
        ProductsDTO productsDTO = productsMapper.toDto(products);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProductsMockMvc.perform(put("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(productsDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Products in the database
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProducts() throws Exception {
        // Initialize the database
        productsRepository.saveAndFlush(products);

        int databaseSizeBeforeDelete = productsRepository.findAll().size();

        // Delete the products
        restProductsMockMvc.perform(delete("/api/products/{id}", products.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Products> productsList = productsRepository.findAll();
        assertThat(productsList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
