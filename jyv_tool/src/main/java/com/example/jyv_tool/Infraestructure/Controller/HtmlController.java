package com.example.jyv_tool.Infraestructure.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/Home")
    public String index(Model model) {
        return "bienvenida"; 
    }
    @GetMapping("/login")
    public String index2(Model model) {
        return "Inicio_sesion"; 
    }
    @GetMapping("/registrar")
    public String index3(Model model) {
        return "registrar"; 
    }
    @GetMapping("/PaginaPrincipal")
    public String index4(Model model) {
        return "herramienta"; 
    }
    @GetMapping("/Perfil")
    public String index5(Model model) {
        return "PerfilUsuario"; 
    }
    @GetMapping("/Reservas")
    public String index6(Model model) {
        return "reservaciones"; 
    }
    @GetMapping("/Pagos")
    public String index7(Model model) {
        return "pagos"; 
    }
    @GetMapping("/Factura")
    public String index9(Model model) {
        return "facturas"; 
    }

    
}
