package dukes.spring;

import dukes.ai.JakartaGTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GPTResource {

    @Autowired
    private JakartaGTP jakartaGTP;

    @GetMapping(value = "/prompt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String prompt(@RequestParam("message") String message) {

        return jakartaGTP.chat(message);
    }
}
