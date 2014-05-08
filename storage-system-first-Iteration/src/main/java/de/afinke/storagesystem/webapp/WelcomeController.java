package de.afinke.storagesystem.webapp;

import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

@Component
@ManagedBean
@SessionScoped
public class WelcomeController {

    public Date getDate() {
        return new Date();
    }

}
