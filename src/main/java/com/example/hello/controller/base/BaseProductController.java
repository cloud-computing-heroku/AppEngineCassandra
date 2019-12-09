package com.example.hello.controller.base;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.utils.UUIDs;
import com.example.hello.model.Product;
import com.example.hello.model.ProductDetails;
import com.example.hello.model.ProductType;
import com.example.hello.request.ProductRequest;
import com.example.hello.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/admin")
public class BaseProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductDetailService productDetailService;

    private Optional<Product> listProducts = null;
    private Optional<ProductDetails> listProductDetail = null;
    private ProductRequest productRequest = null;

    @RequestMapping(value = "/product-info")
    public String getAll(Model model) {
        model.addAttribute("productList", this.productService.getAllProduct());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Product");
        return "product-info";
    }

    @RequestMapping(value = "/product-detail/{id}")
    public String detailProduct(Model model, @PathVariable String id) {
        listProducts = this.productService.getProduct(UUID.fromString(id));
        listProductDetail = this.productDetailService.getProductDetails(id);
        productRequest = new ProductRequest();
        productRequest.setId(id);
        productRequest.setName(listProducts.get().getName());
        productRequest.setSupplierName(listProducts.get().getSupplierName());
        productRequest.setProducerName(listProducts.get().getProducerName());
        productRequest.setTypeName(listProducts.get().getTypeName());
        productRequest.setCost(listProducts.get().getCost());
        productRequest.setSale(listProducts.get().getSale());
        productRequest.setRemain(listProducts.get().getRemain().toString());
        productRequest.setCreatedAt(listProducts.get().getCreatedAt());
        productRequest.setCpu(listProductDetail.get().getCpu());
        productRequest.setRam(listProductDetail.get().getRam());
        productRequest.setRom(listProductDetail.get().getRom());
        productRequest.setScreen(listProductDetail.get().getScreen());
        productRequest.setPort(listProductDetail.get().getPort());
        productRequest.setCamera(listProductDetail.get().getCamera());
        productRequest.setPin(listProductDetail.get().getPin());
        productRequest.setOs(listProductDetail.get().getOs());
        productRequest.setConnect(listProductDetail.get().getConnect());
        productRequest.setSize(listProductDetail.get().getSize());
        productRequest.setColor(listProductDetail.get().getColor());
        productRequest.setWeight(listProductDetail.get().getWeight());
        productRequest.setOther(listProductDetail.get().getOther());
        model.addAttribute("productDetails", productRequest);
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Product");
        return "product-details";
    }

    @RequestMapping(value = "/product-create")
    public String createProduct(Model model) {
        model.addAttribute("product", new ProductRequest());
        model.addAttribute("producers", this.producerService.getAllProducerName());
        model.addAttribute("suppliers", this.supplierService.getAllSupplierName());
        model.addAttribute("producTypes", this.productTypeService.getAllProductType());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Product");
        return "product-create";
    }

    @RequestMapping(value = "/product-do-create")
    public String doCreateProduct(@ModelAttribute ProductRequest product) {
        Product pro = new Product();
        ProductDetails productDetails = new ProductDetails();
        pro.setId(UUIDs.timeBased());
        String id = String.valueOf(pro.getId());
        BigDecimal cost = new BigDecimal(product.getCost());
        BigDecimal sale = new BigDecimal(product.getSale());
        String remain = cost.subtract(sale).toString();
        pro.setName(product.getName());
        pro.setProducerName(product.getProducerName());
        pro.setSupplierName(product.getSupplierName());
        pro.setTypeName(product.getTypeName());
        pro.setCost(cost.toString());
        pro.setSale(sale.toString());
        pro.setRemain(remain);
        pro.setCreatedAt(LocalDate.fromYearMonthDay(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth()));
        productDetails.setId(id);
        productDetails.setCpu(product.getCpu());
        productDetails.setRam(product.getRam());
        productDetails.setRom(product.getRom());
        productDetails.setScreen(product.getScreen());
        productDetails.setScreen(product.getPort());
        productDetails.setCamera(product.getCamera());
        productDetails.setPin(product.getPin());
        productDetails.setOs(product.getOs());
        productDetails.setConnect(product.getConnect());
        productDetails.setPort(product.getPort());
        productDetails.setSize(product.getSize());
        productDetails.setColor(product.getColor());
        productDetails.setWeight(product.getWeight());
        productDetails.setOther(product.getOther());
        this.productService.saveProduct(pro);
        this.productDetailService.saveProductDetails(productDetails);
        return "redirect:/admin/product-info";
    }

    @RequestMapping(value = "/product-update/{id}")
    public String updateProduct(Model model, @PathVariable String id) {
        listProducts = this.productService.getProduct(UUID.fromString(id));
        listProductDetail = this.productDetailService.getProductDetails(id);
        productRequest = new ProductRequest();
        productRequest.setId(id);
        productRequest.setName(listProducts.get().getName());
        productRequest.setSupplierName(listProducts.get().getSupplierName());
        productRequest.setProducerName(listProducts.get().getProducerName());
        productRequest.setTypeName(listProducts.get().getTypeName());
        productRequest.setCost(listProducts.get().getCost());
        productRequest.setSale(listProducts.get().getSale());
        productRequest.setRemain(listProducts.get().getRemain().toString());
        productRequest.setCreatedAt(listProducts.get().getCreatedAt());
        productRequest.setCpu(listProductDetail.get().getCpu());
        productRequest.setRam(listProductDetail.get().getRam());
        productRequest.setRom(listProductDetail.get().getRom());
        productRequest.setScreen(listProductDetail.get().getScreen());
        productRequest.setPort(listProductDetail.get().getPort());
        productRequest.setCamera(listProductDetail.get().getCamera());
        productRequest.setPin(listProductDetail.get().getPin());
        productRequest.setOs(listProductDetail.get().getOs());
        productRequest.setConnect(listProductDetail.get().getConnect());
        productRequest.setSize(listProductDetail.get().getSize());
        productRequest.setColor(listProductDetail.get().getColor());
        productRequest.setWeight(listProductDetail.get().getWeight());
        productRequest.setOther(listProductDetail.get().getOther());
        model.addAttribute("productDetails", productRequest);
        model.addAttribute("producers", this.producerService.getAllProducerName());
        model.addAttribute("suppliers", this.supplierService.getAllSupplierName());
        model.addAttribute("producTypes", this.productTypeService.getAllProductType());
        model.addAttribute("root", "Category");
        model.addAttribute("sub_root", "Components");
        model.addAttribute("sub_active", "Product");
        return "product-update";
    }

    @RequestMapping(value = "/product-do-update/{id}")
    public String doUpdateProduct(Model model, @ModelAttribute ProductRequest product, @PathVariable String id) {
        Product pro = new Product();
        ProductDetails productDetails = new ProductDetails();
        pro.setId(UUID.fromString(id));
        BigDecimal cost = new BigDecimal(product.getCost());
        BigDecimal sale = new BigDecimal(product.getSale());
        String remain = cost.subtract(sale).toString();
        pro.setName(product.getName());
        pro.setProducerName(product.getProducerName());
        pro.setSupplierName(product.getSupplierName());
        pro.setTypeName(product.getTypeName());
        pro.setCost(cost.toString());
        pro.setSale(sale.toString());
        pro.setRemain(remain);
        pro.setCreatedAt(LocalDate.fromYearMonthDay(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth()));
        productDetails.setId(id);
        productDetails.setCpu(product.getCpu());
        productDetails.setRam(product.getRam());
        productDetails.setRom(product.getRom());
        productDetails.setScreen(product.getScreen());
        productDetails.setScreen(product.getPort());
        productDetails.setCamera(product.getCamera());
        productDetails.setPin(product.getPin());
        productDetails.setOs(product.getOs());
        productDetails.setConnect(product.getConnect());
        productDetails.setPort(product.getPort());
        productDetails.setSize(product.getSize());
        productDetails.setColor(product.getColor());
        productDetails.setWeight(product.getWeight());
        productDetails.setOther(product.getOther());
        this.productService.saveProduct(pro);
        this.productDetailService.saveProductDetails(productDetails);
        return "redirect:/admin/product-info";
    }

    @RequestMapping(value = "/product-delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        listProducts = this.productService.getProduct(UUID.fromString(id));
        listProductDetail = this.productDetailService.getProductDetails(id);
        if (listProductDetail != null && listProducts != null) {
            this.productDetailService.deleteProductDetails(id);
            this.productService.deleteProduct(UUID.fromString(id));
        }
        return "redirect:/admin/product-info";
    }
}
