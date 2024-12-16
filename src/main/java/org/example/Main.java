package org.example;
import System.*;
import System.ViewLayer.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();

        while(true)
            view.ExecuteUseCases();
    }
}