package com.xproject.master.app.entrypoint.mercadolivre;

import com.xproject.master.app.dataprovider.mercadolivre.MercadoLivreDataProviderImpl;
import com.xproject.master.app.entrypoint.dto.CodeGeneratorDTO;
import feign.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "mercadolivre")
public class MercadoLivreRestController {

    private MercadoLivreDataProviderImpl mercadoLivreDataProvider;

    @PostMapping("/start")
    public ResponseEntity codeGenerator(@RequestBody CodeGeneratorDTO request) {

        mercadoLivreDataProvider.codeGenerator(request.getClientId(), request.getRedirectUri());
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/auth")
    public ResponseEntity codeResult(@RequestParam String code, @RequestParam String state) {


        String codeLocal = code;
        String stateLocal = state;

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
