package com.example.demo;

import lombok.Getter;

@Getter public class C {
A a;
B b;
int val;

    C(A a, B b,int val)
    {
        this.a=a;
        this.b=b;
        this.val=val;
    }

}
