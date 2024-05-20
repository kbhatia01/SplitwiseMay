package org.scaler.splitwisemay;

import org.scaler.splitwisemay.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseMayApplication implements CommandLineRunner {

    private Scanner sc = new Scanner(System.in);

    private CommandExecutor executor;

    SplitwiseMayApplication(){
        this.executor = new CommandExecutor();
    }


    public static void main(String[] args) {
        SpringApplication.run(SplitwiseMayApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            String input = sc.nextLine();
            executor.execute(input);
            System.out.println("Done..");
        }
    }
}
