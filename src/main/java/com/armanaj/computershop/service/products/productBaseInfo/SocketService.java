package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.Socket;
import com.armanaj.computershop.repository.products.productBaseInfo.SocketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocketService {

    private final SocketRepository socketRepository;

    public SocketService(SocketRepository socketRepository) {
        this.socketRepository = socketRepository;
    }

    public List<Socket> getAllSockets() {
        return socketRepository.findAll().stream().toList();
    }

    public Socket getSocketById(Integer id) {
        return socketRepository.findById(id).orElseThrow();
    }

    public Socket save(String name) {
        Socket socket = new Socket(name);
        return socketRepository.save(socket);
    }
}
