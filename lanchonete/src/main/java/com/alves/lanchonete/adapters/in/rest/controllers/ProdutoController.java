package com.alves.lanchonete.adapters.in.rest.controllers;

import com.alves.lanchonete.adapters.in.rest.data.request.ProdutoRequest;
import com.alves.lanchonete.adapters.in.rest.data.response.ProdutoResponse;
import com.alves.lanchonete.adapters.in.rest.mappers.ProdutoRestMapper;
import com.alves.lanchonete.applications.ports.in.produto.*;
import com.alves.lanchonete.domain.models.Produto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final SaveProdutoUseCase saveProdutoUseCase;
    private final ProdutoRestMapper produtoRestMapper;
    private final FindAllProdutoUseCase findAllProdutoUseCase;
    private final DeleteProdutoByIdUseCase deleteProdutoByIdUseCase;
    private final FindProdutoByIdUseCase findProdutoByIdUseCase;
    private final UpdateProdutoUseCase updateProdutoUseCase;

    @PostMapping
    public ResponseEntity<ProdutoResponse> save(@RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produto = produtoRestMapper.toDomain(produtoRequest);
        produto = saveProdutoUseCase.save(produto);
        ProdutoResponse produtoResponse = produtoRestMapper.toResponse(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        List<ProdutoResponse> produtoResponsesList = findAllProdutoUseCase.findAll().stream()
                .map(produtoRestMapper::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(produtoResponsesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        Produto produto = findProdutoByIdUseCase.findById(id);
        ProdutoResponse produtoResponse = produtoRestMapper.toResponse(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update(@PathVariable long id,
                                                  @RequestBody ProdutoRequest produtoRequest) {
        Produto produto = findProdutoByIdUseCase.findById(id);
        BeanUtils.copyProperties(produtoRequest, produto, "id");
        produto = updateProdutoUseCase.update(produto);
        ProdutoResponse produtoResponse = produtoRestMapper.toResponse(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        deleteProdutoByIdUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
