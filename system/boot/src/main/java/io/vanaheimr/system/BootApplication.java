package io.vanaheimr.system;

import io.micronaut.runtime.Micronaut;

public class BootApplication {
    public static void main(String[] args) {
        Micronaut.run(BootApplication.class)
                .start();
    }
}
