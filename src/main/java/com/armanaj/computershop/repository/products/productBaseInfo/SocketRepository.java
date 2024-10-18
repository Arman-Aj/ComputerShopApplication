package com.armanaj.computershop.repository.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.Socket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketRepository extends JpaRepository<Socket, Integer> {
}
