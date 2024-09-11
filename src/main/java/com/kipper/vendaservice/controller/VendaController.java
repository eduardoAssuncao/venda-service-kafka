package com.kipper.vendaservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
@RequiredArgsConstructor
public class VendaController {


    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public ResponseEntity<Void> realizarVenda(@RequestBody String idProduto){
        kafkaTemplate.send("estoque-topico", idProduto);
        return ResponseEntity.ok().build();
    }
}
