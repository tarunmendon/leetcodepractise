package com.example.demo;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter public class B {
    String val;
    B(String val)
    {
        this.val=val;
    }
}
