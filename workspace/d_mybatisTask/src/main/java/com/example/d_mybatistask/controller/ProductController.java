package com.example.d_mybatistask.controller;


import com.example.d_mybatistask.domain.dto.ProductDetailDTO;
import com.example.d_mybatistask.domain.vo.ProductVO;
import com.example.d_mybatistask.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
@Slf4j
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

    // @ModelAttribute 는 요청 데이터를 객체에 자동으로 바인딩해주는 역할을 한다.
    // 생략이 가능하다.
    @PostMapping("/write")
    public String write(@ModelAttribute ProductVO vo) {

        if(vo.getId() != null){
            productService.updateProduct(vo);
            return "redirect:/product/detail/" + vo.getId();
        }

        // 만약 삽입 하고 나서 바로 상세보기를 보고 싶다면
        // 시퀀스 번호를 받아오는 쿼리를 짜서 해야한다.
        productService.insert(vo);
        // html 이 아닌 다른 컨트롤러를 요청할 때 사용한다.
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        ProductDetailDTO product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/writeForm";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        int isDeleted = productService.deleteById(id);

        if (isDeleted != 0) {
            redirectAttributes.addFlashAttribute("message", "삭제가 정상적으로 완료되었습니다!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "삭제에 실패하였습니다. 다시 시도해주세요.");
        }

        return "redirect:/product/list";
    }

}
