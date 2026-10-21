package com.example.shared;

import com.example.shared.dto.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync {
    void greetServer(String name, AsyncCallback<String> callback);

    void greetServer(UserDTO userDTO, AsyncCallback<UserDTO> callback);
}
