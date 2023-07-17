package com.springboot.application.controllers;

import java.util.List;

import com.springboot.application.models.Pedido;
import com.springboot.application.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PedidoService {

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    private PedidoRepository pedidoRepository;

    @GetMapping("/cadastrarPedido")
    public String cadastrarPedido(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "cadastrarPedido";
    }

    @PostMapping("/cadastrarPedido")
    public String addPedido(@ModelAttribute Pedido pedido, Model model) {
        pedidoRepository.save(pedido);
        listarPedidos(model);
        return "listarPedidos";
    }

    @GetMapping("/listarPedidos")
    public String listarPedidos(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("listaPedidos", pedidos);
        return "listarPedidos";
    }


    @GetMapping("/excluirPedido/{id}")
    public String excluirPedido(@PathVariable Long id, Model model) {
        pedidoRepository.deleteById(id);
        listarPedidos(model);
        return "listarPedidos";
    }

    @GetMapping("/alterarPedido/{id}")
    public String alterarPedido(@PathVariable Long id, Model model) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        model.addAttribute("pedido", pedido);
        return "alterarPedido";
    }

    @PostMapping("/alterarPedido")
    public String alterarPedido(@ModelAttribute Pedido pedido, Model model) {
        pedidoRepository.save(pedido);
        listarPedidos(model);
        return "listarPedidos";
    }
}
