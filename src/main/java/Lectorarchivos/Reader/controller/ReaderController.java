package Lectorarchivos.Reader.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ReaderController {


        @GetMapping("/")
        public String test(){
            return "llego";
        }
}

