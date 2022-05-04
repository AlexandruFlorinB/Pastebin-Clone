package com.example.Pastebin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PasteService {

    @Autowired
    private final PasteRepository pasteRepository;

    public PasteService(PasteRepository pasteRepository) {
        this.pasteRepository = pasteRepository;
    }

    public List<Paste> listAllPaste() {
        return pasteRepository.findAll();
    }

    public void save(Paste paste) {
        pasteRepository.save(paste);
    }

    public void delete(long id) {
        pasteRepository.deleteById(id);
    }

    public Paste getPasteById(long id) {
        Optional<Paste> optional = pasteRepository.findById(id);
        Paste paste;
        if (optional.isPresent()) {
            paste = optional.get();
        } else {
            throw new RuntimeException("Pastebin not found for id: " + id);
        }
        return paste;
    }
}
