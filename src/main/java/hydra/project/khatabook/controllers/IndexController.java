package hydra.project.khatabook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping({"","/","home"})
@Controller
public class IndexController {
@GetMapping({""})
public String homePage() {
	return "index.html";
}
}
