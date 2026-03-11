package com.douaa.accessoires.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.douaa.accessoires.entities.Accessoire;
import com.douaa.accessoires.entities.Couleur;
import com.douaa.accessoires.service.AccessoireService;
import jakarta.validation.Valid;

@Controller
public class AccessoireController {

    @Autowired
    AccessoireService accessoireService;

    @RequestMapping("/ListeAccessoires")
    public String listeAccessoires(ModelMap modelMap,
            @RequestParam(name="page", defaultValue="0") int page,
            @RequestParam(name="size", defaultValue="2") int size) {
        Page<Accessoire> accs = accessoireService.getAllAccessoiresParPage(page, size);
        modelMap.addAttribute("accessoires", accs);
        modelMap.addAttribute("pages", new int[accs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeAccessoires";
    }

    @RequestMapping("/showCreate")
    public String showCreate(ModelMap modelMap) {
        List<Couleur> couls = accessoireService.getAllCouleurs();
        modelMap.addAttribute("accessoire", new Accessoire());
        modelMap.addAttribute("mode", "new");
        modelMap.addAttribute("couleurs", couls);
        return "formAccessoire";
    }

    @RequestMapping("/saveAccessoire")
    public String saveAccessoire(@Valid @ModelAttribute("accessoire") Accessoire accessoire, 
            BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.addAttribute("couleurs", accessoireService.getAllCouleurs());
            modelMap.addAttribute("mode", "new");
            return "formAccessoire";
        }
        accessoireService.saveAccessoire(accessoire);
        return ("redirect:/ListeAccessoires");
    }
    @RequestMapping("/supprimerAccessoire")
    public String supprimerAccessoire(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name="page", defaultValue="0") int page,
            @RequestParam(name="size", defaultValue="3") int size) {
        accessoireService.deleteAccessoireById(id);
        Page<Accessoire> accs = accessoireService.getAllAccessoiresParPage(page, size);
        modelMap.addAttribute("accessoires", accs);
        modelMap.addAttribute("pages", new int[accs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeAccessoires";
    }

    @RequestMapping("/modifierAccessoire")
    public String editerAccessoire(@RequestParam("id") Long id, ModelMap modelMap) {
        Accessoire a = accessoireService.getAccessoire(id);
        List<Couleur> couls = accessoireService.getAllCouleurs();
        modelMap.addAttribute("accessoire", a);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("couleurs", couls);
        return "formAccessoire";
    }
}