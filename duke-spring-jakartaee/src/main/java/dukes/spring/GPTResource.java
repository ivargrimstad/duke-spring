package dukes.spring;

import dukes.ai.JakartaGPT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GPTResource {

    @Autowired
    private JakartaGPT model;

    @GetMapping(value = "/prompt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String prompt(@RequestParam("message") String message) {

        return model.chat(message);
    }
}
