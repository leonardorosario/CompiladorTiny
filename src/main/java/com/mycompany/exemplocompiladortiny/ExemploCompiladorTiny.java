package com.mycompany.exemplocompiladortiny;

import com.mycompany.tiny.compiler.*;

import java.io.StringReader;
import java.util.Scanner;

public class ExemploCompiladorTiny {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite a expressão: ");
        String entrada = teclado.nextLine();

        SimpleCharStream stream = new SimpleCharStream(new StringReader(entrada));
        TinyTokenManager lexer = new TinyTokenManager(stream);
        Token t;

        try {
            System.out.println("\n--- Resultado da Análise Léxica ---");
            do {
                t = lexer.getNextToken();
                if (t.kind != TinyConstants.EOF) {
                    System.out.println("Lido: '" + t.image + "' -> Reconhecido como: " + TinyConstants.tokenImage[t.kind]);
                }
            } while (t.kind != TinyConstants.EOF);

            System.out.println("\nExpressão Aceita! (Nenhum erro léxico)");

        } catch(TokenMgrError erro) {
            System.out.println("\nExpressão Não aceita!: " + erro.getMessage());
        }
        teclado.close();
    }
}