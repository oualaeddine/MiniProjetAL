package dz.univconstantineii.archlog.lightmanager.control.ui;

import dz.univconstantineii.archlog.lightmanager.model.dao.LogsDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
    private LogsDAO dao;
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
