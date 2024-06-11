package com.example.f_board_basic_login.controller;


import com.example.f_board_basic_login.domain.dto.ProductDTO;
import com.example.f_board_basic_login.domain.dto.ProductDetailDTO;
import com.example.f_board_basic_login.domain.vo.ProductVO;
import com.example.f_board_basic_login.service.PagingService;
import com.example.f_board_basic_login.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    // 페이징 테스트
    private final PagingService pagingService;

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
    public String write(@ModelAttribute ProductVO vo, RedirectAttributes redirectAttributes) {

        if(vo.getId() != null){
            productService.updateProduct(vo);
            return "redirect:/product/detail/" + vo.getId();
        }

        // 만약 삽입 하고 나서 바로 상세보기를 보고 싶다면
        // 시퀀스 번호를 받아오는 쿼리를 짜서 해야한다.
        int isInserted = productService.insert(vo);

        if (isInserted != 0) {
            redirectAttributes.addFlashAttribute("msg", "게시글이 정상적으로 추가되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "예상치 못한 오류가 발생했습니다. 다시 시도해주세요.");
        }

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
            redirectAttributes.addFlashAttribute("msg", "삭제가 정상적으로 완료되었습니다!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "삭제에 실패하였습니다. 다시 시도해주세요.");
        }

        return "redirect:/product/list";
    }


    @GetMapping("/paging")
    public String listProducts(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "pageSize", defaultValue = "2") int pageSize,
                               Model model) {
        int totalProducts = pagingService.countProducts();
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        int pageGroupSize = 5;
        int startPage = ((page - 1) / pageGroupSize) * pageGroupSize + 1;
        int endPage = Math.min(startPage + pageGroupSize - 1, totalPages);

        List<ProductDTO> products = pagingService.selectProducts(page, pageSize);



        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", pageSize);

        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "product/paging"; // Thymeleaf 템플릿 파일 이름
    }

}
