package com.example.client;

import com.example.shared.GreetingService;
import com.example.shared.GreetingServiceAsync;
import com.example.shared.dto.UserDTO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Smart implements EntryPoint {
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    @Override
    public void onModuleLoad() {
        Button button = new Button("Отправить RPC запрос");
        TextBox textBox = new TextBox();
        textBox.setText("GWT Разработчик");

        button.addClickHandler(event -> {
            greetingService.greetServer(new UserDTO(), new AsyncCallback<UserDTO>() {

                @Override
                public void onFailure(Throwable caught) {

                }

                @Override
                public void onSuccess(UserDTO result) {
                    Window.alert(result.getEmail());

                }
            });


            greetingService.greetServer(textBox.getText(), new AsyncCallback<String>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Ошибка сервера: " + caught.getMessage());
                }

                @Override
                public void onSuccess(String result) {
                    Window.alert(result);
                }
            });
        });

        RootPanel.get("inputContainer").add(textBox);
        RootPanel.get("buttonContainer").add(button);

    }
}
