package com.example.Pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PasteController {

    @Autowired
    private final PasteService pasteService;

    public PasteController(PasteService pasteService) {
        this.pasteService = pasteService;
    }

    @GetMapping("/api/v1/paste")
    public String homePage(Model model) {
        List<Paste> listPaste = pasteService.listAllPaste();
        model.addAttribute("listPaste", listPaste);
        return "index";
    }

    @GetMapping("/api/v1/paste/createPaste")
    public String addPaste(Model model) {
        Paste paste = new Paste();
        model.addAttribute("pastebin", paste);
        return "createPaste";
    }

    @RequestMapping (value = "/api/v1/paste/savePaste", method = RequestMethod.POST)
    public String savePaste(@ModelAttribute("pastebin") Paste paste) {
        pasteService.save(paste);
        return "redirect:/api/v1/paste";
    }

    @RequestMapping("/api/v1/paste/editPaste/{id}")
    public String editPaste(@PathVariable(value = "id") long id, Model model) {
        Paste paste = pasteService.getPasteById(id);
        model.addAttribute("pastebin", paste);
        return "updatePaste";
    }

    @RequestMapping("/api/v1/paste/deletePaste/{id}")
    public String deletePaste(@PathVariable(name = "id") long id) {
        pasteService.delete(id);
        return "redirect:/api/v1/paste";
    }
}
