package com.example.d_mybatistask.controller;


import com.example.d_mybatistask.domain.dto.ProductDetailDTO;
import com.example.d_mybatistask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String index() {return "product/index";}

    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("products", productService.selectList());

        return "product/productList";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        ProductDetailDTO product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/detail";
    }

    @GetMapping("/write")
    public String goWriteForm(Model model) {
        model.addAttribute("product", new ProductDetailDTO());
        return "product/writeForm";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        ProductDetailDTO product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/writeForm"; // edit 페이지 필요
    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        productService.deleteProductById(id); // 삭제 로직 필요
//        return "redirect:/product";
//    }

}
