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
    @GetMapping("/loginVista")
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
    @GetMapping("/admin_reporte")
    public String index8(Model model) {
        return "admin_reporte"; 
    }
        @GetMapping("/Factura")
    public String index9(Model model) {
        return "facturas"; 
    }
    @GetMapping("/RegistroHerramientas")
    public String index10(Model model) {
        return "registro_Herramientas"; 
    }
    @GetMapping("/admin_registrar")
    public String index11(Model model) {
        return "admin_registrar"; 
    }
    @GetMapping("/admin_historial")
    public String index12(Model model) {
        return "admin_historial"; 
    }
    @GetMapping("/admin_herramienta")
    public String index13(Model model) {
        return "admin_herramienta"; 
    }    
    @GetMapping("/admin_eliminar")
    public String index14(Model model) {
        return "admin_eliminar"; 
    }
    @GetMapping("/admin_devolucion")
    public String index15(Model model) {
        return "admin_devolucion"; 
    }
    @GetMapping("/Historial")
    public String index16(Model model) {
        return "Historial"; 
    }
    
}
