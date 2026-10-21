package com.example.server;

import com.example.shared.GreetingService;
import com.example.shared.dto.UserDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
    @Override
    public String greetServer(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя пустое!");
        }
        return "Привет от исправленного многомодульного сервера, " + name + "!";
    }

    @Override
    public UserDTO greetServer(UserDTO userDTO) {
        userDTO.setEmail("aaa@kz.kz");
        return userDTO;
    }
}
